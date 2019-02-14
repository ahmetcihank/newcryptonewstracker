package com.example.software02.newcryptotracker.Model;

public class Platform {

    private  Integer id = 0;
    private  String name = "";
    private  String symbol = "";
    private  String slug = "";
    private  String token_address ="";


    public Platform(Integer id, String name, String symbol, String slug, String token_address) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
        this.token_address = token_address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getToken_address() {
        return token_address;
    }

    public void setToken_address(String token_address) {
        this.token_address = token_address;
    }
}
