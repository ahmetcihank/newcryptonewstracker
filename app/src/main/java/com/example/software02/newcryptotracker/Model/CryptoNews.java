package com.example.software02.newcryptotracker.Model;

import java.util.List;

public class CryptoNews {
    String status = "";
    Integer totalResults =0;
    List<Articals> articles = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Articals> getArticals() {
        return articles;
    }

    public void setArticals(List<Articals> articles) {
        this.articles = articles;
    }
}
