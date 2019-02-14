package com.example.software02.newcryptotracker.Model;

public class Data {

    private  double id = 0;
    private  String name = "";
    private  String symbol = "";
    private  String slug = "";


    private  double circulating_supply = 0;
    private  double total_supply = 0;
    private  double max_supply = 0;
    private  String date_added = "";
    private  double num_market_pairs = 0;
    private  String tags []= {};
    private  Platform platform = null;
    private  double cmc_rank= 0;
    private  String last_updated = "";
    private  Quote quote = null;

    public Data(double id, String name, String symbol, double circulating_supply,
                double total_supply, double max_supply, String date_added,
                double num_market_pairs, String[] tags, Platform platform, double cmc_rank,
                String last_updated, Quote quote) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.circulating_supply = circulating_supply;
        this.total_supply = total_supply;
        this.max_supply = max_supply;
        this.date_added = date_added;
        this.num_market_pairs = num_market_pairs;
        this.tags = tags;
        this.platform = platform;
        this.cmc_rank = cmc_rank;
        this.last_updated = last_updated;
        this.quote = quote;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public double getId() {
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

    public double getCirculating_supply() {
        return circulating_supply;
    }

    public void setCirculating_supply(Integer circulating_supply) {
        this.circulating_supply = circulating_supply;
    }

    public double getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(Integer total_supply) {
        this.total_supply = total_supply;
    }

    public double getMax_supply() {
        return max_supply;
    }

    public void setMax_supply(Integer max_supply) {
        this.max_supply = max_supply;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public double getNum_market_pairs() {
        return num_market_pairs;
    }

    public void setNum_market_pairs(Integer num_market_pairs) {
        this.num_market_pairs = num_market_pairs;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public double getCmc_rank() {
        return cmc_rank;
    }

    public void setCmc_rank(Integer cmc_rank) {
        this.cmc_rank = cmc_rank;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
