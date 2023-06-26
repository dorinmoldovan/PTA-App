package com.pta_app.algorithm;

import com.pta_app.model.Flower;

public class Result {

    private String logs;
    private Flower globalBest;
    private Double runningTime;

    public Result() {
        this.logs = "";
    }

    public Result(String logs, Flower globalBest, double runningTime) {
        this.logs = logs;
        this.globalBest = globalBest;
        this.runningTime = runningTime;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public Flower getGlobalBest() {
        return globalBest;
    }

    public void setGlobalBest(Flower globalBest) {
        this.globalBest = globalBest;
    }

    public Double getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Double runningTime) {
        this.runningTime = runningTime;
    }
}
