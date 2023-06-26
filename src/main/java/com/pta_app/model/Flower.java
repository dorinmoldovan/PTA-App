package com.pta_app.model;

import java.io.Serializable;
import java.util.*;

public class Flower implements Serializable {

    private List<Double> position;
    private Random rand;
    private Double fitness;
    private Integer D;
    private Double FT;
    private Double RT;
    private Double FR_min;
    private Double FR_max;
    private Double eps;
    private Double X_min;
    private Double X_max;

    public Flower(Random rand, Integer d, Double FT, Double RT, Double FR_min, Double FR_max, Double eps, Double X_min, Double X_max) {
        this.rand = rand;
        this.D = d;
        this.FT = FT;
        this.RT = RT;
        this.FR_min = FR_min;
        this.FR_max = FR_max;
        this.eps = eps;
        this.X_min = X_min;
        this.X_max = X_max;
        this.position = new ArrayList<>();
        for(int i = 0; i < this.D; i++) {
            double value = (X_max - X_min) * rand.nextDouble() + X_min;
            this.position.add(value);
        }
    }

    public void computePosition() {

    }

    public List<Double> getPosition() {
        return position;
    }

    public void setPosition(List<Double> position) {
        this.position = position;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public Double getFitness() {
        return fitness;
    }

    public void setFitness(Double fitness) {
        this.fitness = fitness;
    }

    public Integer getD() {
        return D;
    }

    public void setD(Integer d) {
        D = d;
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

    public Double getX_min() {
        return X_min;
    }

    public void setX_min(Double x_min) {
        X_min = x_min;
    }

    public Double getX_max() {
        return X_max;
    }

    public void setX_max(Double x_max) {
        X_max = x_max;
    }
}
