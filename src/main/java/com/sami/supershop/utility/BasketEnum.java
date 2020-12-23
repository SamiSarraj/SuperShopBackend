package com.sami.supershop.utility;

public enum BasketEnum {
    EMPTY("empty"),
    NOT_EMPTY("not empty");

    private final String basketStatus;

    private BasketEnum(final String basketStatus) {
        this.basketStatus = basketStatus;
    }

    public String getBasketStatus() {
        return basketStatus;
    }
}
