package com.solvd.gui.amazon.components.filters;

public enum PriceEnum {
    UNDER500("500$"), TO600("$500 to $600"), TO700("$600 to $700"),
    TO800("$700 to $800"), TO1000("$800 to $1000"), ABOVE1000("$1000 & Above");

    private String price;

    PriceEnum(String laptopPrice) {
        this.price = laptopPrice;
    }

    public String getPrice() {
        return price;
    }
}
