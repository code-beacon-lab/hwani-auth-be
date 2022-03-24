package com.boiler.auth.lease;

public enum LeasGbcd {
    임대갑(1),
    임대을(2),
    기타임대(3);

    private final int leasGbcd;

    private LeasGbcd(int leasGbcd) {
        this.leasGbcd = leasGbcd;
    }

    public int getLeasGbcd() {
        return leasGbcd;
    }
}
