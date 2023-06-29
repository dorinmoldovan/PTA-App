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

    public Flower(Random rand, Integer d, Double FT, Double RT, Double FR_min, Double FR_max, Double eps) {
        this.rand = rand;
        this.D = d;
        this.FT = FT;
        this.RT = RT;
        this.FR_min = FR_min;
        this.FR_max = FR_max;
        this.eps = eps;
        this.position = new ArrayList<>();
        for(int i = 0; i < this.D; i++) {
            this.position.add(0.0);
        }
    }

    public void fruitinessPhase(Flower plum) {
        for(int i = 0; i < this.D; i++) {
            double value = this.position.get(i) + (FR_min + rand.nextDouble() * (FR_max - FR_min))
                    * (plum.getPosition().get(i) - this.position.get(i));
            this.position.set(i, value);
        }
    }

    public void ripenessPhase(Flower ripePlum, Flower unripePlum) {
        for(int i = 0; i < this.D; i++) {
            double r1 = rand.nextDouble();
            double r2 = rand.nextDouble();
            double value = this.position.get(i) + 2 * r1 * (ripePlum.getPosition().get(i) - this.position.get(i))
                    + 2 * r2 * (unripePlum.getPosition().get(i) - this.position.get(i));
            this.position.set(i, value);
        }
    }

    public void storenessPhase(Flower plum, Flower ripePlum) {
        double sigma_ripe = 1.0;
        if (plum.getFitness() >= ripePlum.getFitness()) {
            sigma_ripe = Math.exp((ripePlum.getFitness() - plum.getFitness()) / (Math.abs(plum.getFitness()) + eps));
        }
        for (int i = 0; i < this.D; i++) {
            double value = plum.getPosition().get(i) * (1 + rand.nextGaussian() * sigma_ripe);
            this.position.set(i, value);
        }
    }

    public void adjustPosition() {
        for (int i = 0; i < this.D; i++) {
            double value = this.getPosition().get(i);
            if (value < X_min) {
                value = X_min;
            }
            if (value > X_max) {
                value = X_max;
            }
            this.position.set(i, value);
        }
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
