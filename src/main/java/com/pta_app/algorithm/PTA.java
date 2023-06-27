package com.pta_app.algorithm;

import java.util.List;
import java.util.Random;

import com.pta_app.model.*;
import com.pta_app.objective_functions.OF;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.SerializationUtils;

public class PTA {

    private Integer N;
    private Integer I;
    private Integer D;
    private Random rand;
    private OF of;
    private Double FT;
    private Double RT;
    private Double FR_min;
    private Double FR_max;
    private Double eps;

    public PTA(int n, int i, int d, double FT, double RT, double minFR, double maxFR, double eps, OF of) {
        this.N = n;
        this.I = i;
        this.D = d;
        this.FT = FT;
        this.RT = RT;
        this.FR_min = minFR;
        this.FR_max = maxFR;
        this.eps = eps;
        this.of = of;
        this.rand = new Random(System.currentTimeMillis());
    }

    public List<Flower> generateFlowers() {
        List<Flower> flowers = new ArrayList<Flower>();
        for(int i = 0; i < this.N; i++) {
            Flower flower = new Flower(this.rand, this.D, this.FT, this.RT, this.FR_min, this.FR_max, this.eps, of.getMinValue(), of.getMaxValue());
            flowers.add(flower);
        }
        return flowers;
    }

    public Result run() {
        Result result = new Result();

        double startTime = System.currentTimeMillis();
        List<Flower> flowers = generateFlowers();
        for(int i = 0; i < flowers.size(); i++) {
            double fitness = of.compute(flowers.get(i).getPosition());
            flowers.get(i).setFitness(fitness);
        }
        List<Flower> plums = new ArrayList<>();
        for(int i = 0; i < flowers.size(); i++) {
            Flower plum = SerializationUtils.clone(flowers.get(i));
            plums.add(plum);
        }
        Flower gBest = null;
        for(int i = 0; i < plums.size(); i++) {
            if(i == 0) {
                gBest =  SerializationUtils.clone(plums.get(i));
            } else {
                if(plums.get(i).getFitness() < gBest.getFitness()) {
                    gBest =  SerializationUtils.clone(plums.get(i));
                }
            }
        }


        double endTime = System.currentTimeMillis();
        double duration = endTime - startTime;
        result.setGlobalBest(gBest);
        result.setRunningTime(duration);

        return result;
    }

    public Integer getN() {
        return N;
    }

    public void setN(Integer n) {
        N = n;
    }

    public Integer getI() {
        return I;
    }

    public void setI(Integer i) {
        I = i;
    }

    public Integer getD() {
        return D;
    }

    public void setD(Integer d) {
        D = d;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public OF getOf() {
        return of;
    }

    public void setOf(OF of) {
        this.of = of;
    }

    public Double getFT() {
        return FT;
    }

    public void setFT(Double FT) {
        this.FT = FT;
    }

    public Double getRT() {
        return RT;
    }

    public void setRT(Double RT) {
        this.RT = RT;
    }

    public Double getFR_min() {
        return FR_min;
    }

    public void setFR_min(Double FR_min) {
        this.FR_min = FR_min;
    }

    public Double getFR_max() {
        return FR_max;
    }

    public void setFR_max(Double FR_max) {
        this.FR_max = FR_max;
    }

    public Double getEps() {
        return eps;
    }

    public void setEps(Double eps) {
        this.eps = eps;
    }
}
