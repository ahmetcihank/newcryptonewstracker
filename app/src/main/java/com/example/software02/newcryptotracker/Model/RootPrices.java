package com.example.software02.newcryptotracker.Model;

import java.util.List;

public class RootPrices {

    private Status status = null;
    private List<Data> data = null;

    public RootPrices(Status status, List<Data> data) {
        this.status = status;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
