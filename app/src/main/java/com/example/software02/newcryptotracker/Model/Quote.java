package com.example.software02.newcryptotracker.Model;

public class Quote {
    USD usd = null;

    public Quote(USD usd) {
        this.usd = usd;
    }

    public USD getUsd() {
        return usd;
    }

    public void setUsd(USD usd) {
        this.usd = usd;
    }
}
