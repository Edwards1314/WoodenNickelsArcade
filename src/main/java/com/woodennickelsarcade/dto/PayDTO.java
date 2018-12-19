package com.woodennickelsarcade.dto;

import com.woodennickelsarcade.datastore.Pay;
import java.math.BigInteger;

public class PayDTO {
    private int id;
    private String name;
    private BigInteger cardnumber;
    private String cardtype;
    private Double amount;

    public PayDTO() {
    }
    public PayDTO(Pay p) {
        id = p.getId();
        name = p.getName();
        cardnumber = p.getCardnumber();
        cardtype = p.getCardtype();
        amount = p.getAmount();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(BigInteger cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
