package com.boiler.auth.lease;

public enum StoreCd {
    기준점("000"),
    본점("210"),
    김포아울렛("720")
    ;
    private final String storeCd;

    private StoreCd(String storeCd) {
        this.storeCd = storeCd;
    }

    public String getStoreCd() {
        return storeCd;
    }
}
