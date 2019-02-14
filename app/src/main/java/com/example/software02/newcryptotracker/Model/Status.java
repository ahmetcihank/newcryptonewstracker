package com.example.software02.newcryptotracker.Model;

public class Status {
    private  String timestamp = "";
    private  double error_code = 0;
    private  String error_message = "";
    private Integer elapsed = 0;
    private Integer credit_count = 0;

    public Status(String timestamp, double error_code, String error_message,
                  Integer elapsed, Integer credit_count) {
        this.timestamp = timestamp;
        this.error_code = error_code;
        this.error_message = error_message;
        this.elapsed = elapsed;
        this.credit_count = credit_count;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getError_code() {
        return error_code;
    }

    public void setError_code(double error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public Integer getElapsed() {
        return elapsed;
    }

    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }

    public Integer getCredit_count() {
        return credit_count;
    }

    public void setCredit_count(Integer credit_count) {
        this.credit_count = credit_count;
    }
}
