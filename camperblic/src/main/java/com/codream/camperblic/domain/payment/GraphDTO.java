package com.codream.camperblic.domain.payment;

public class GraphDTO {

    private int tentTotalPrice;
    private int chairTotalPrice;
    private int matTotalPrice;
    private int cookTotalPrice;
    private int etcTotalPrice;
    private int totalPriceSum;

    public GraphDTO(int tentTotalPrice, int chairTotalPrice, int matTotalPrice, int cookTotalPrice, int etcTotalPrice, int totalPriceSum) {
        this.tentTotalPrice = tentTotalPrice;
        this.chairTotalPrice = chairTotalPrice;
        this.matTotalPrice = matTotalPrice;
        this.cookTotalPrice = cookTotalPrice;
        this.etcTotalPrice = etcTotalPrice;
        this.totalPriceSum = totalPriceSum;
    }


    public int getTentTotalPrice() {
        return tentTotalPrice;
    }

    public void setTentTotalPrice(int tentTotalPrice) {
        this.tentTotalPrice = tentTotalPrice;
    }

    public int getChairTotalPrice() {
        return chairTotalPrice;
    }

    public void setChairTotalPrice(int chairTotalPrice) {
        this.chairTotalPrice = chairTotalPrice;
    }

    public int getMatTotalPrice() {
        return matTotalPrice;
    }

    public void setMatTotalPrice(int matTotalPrice) {
        this.matTotalPrice = matTotalPrice;
    }

    public int getCookTotalPrice() {
        return cookTotalPrice;
    }

    public void setCookTotalPrice(int cookTotalPrice) {
        this.cookTotalPrice = cookTotalPrice;
    }

    public int getEtcTotalPrice() {
        return etcTotalPrice;
    }

    public void setEtcTotalPrice(int etcTotalPrice) {
        this.etcTotalPrice = etcTotalPrice;
    }

    public int getTotalPriceSum() {
        return totalPriceSum;
    }

    public void setTotalPriceSum(int totalPriceSum) {
        this.totalPriceSum = totalPriceSum;
    }
}