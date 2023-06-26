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
    private Double X_min;
    private Double X_max;

    public PTA() {
        this.rand = new Random(System.currentTimeMillis());
    }

    public Result run() {
        Result result = new Result();
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
