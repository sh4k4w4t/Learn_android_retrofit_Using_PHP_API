package com.alivepython.mobilebankingappusingphpapi.model;

public class History {
    String type;
    String amount;
    String number;
    String dateTime;
    String response;

    public History() {
    }

    public History(String type,String amount, String number, String dateTime, String response) {
        this.type = type;
        this.amount = amount;
        this.number = number;
        this.dateTime = dateTime;
        this.response = response;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
