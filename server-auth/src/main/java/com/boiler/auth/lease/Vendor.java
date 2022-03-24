package com.boiler.auth.lease;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Vendor implements Cloneable {
    private StoreCd storeCd;
    private String leasCustCd;
    private String venNm;
    private LeasGbcd leasGbcd;
    //List<Deduction> deductions;
    //Money.amount
    
    @Builder
    public Vendor(StoreCd storeCd, String leasCustCd) {
        leasCustCdValidation(leasCustCd);
        this.storeCd = storeCd;
        this.leasCustCd = leasCustCd;
    }

    public Vendor(StoreCd storeCd, String leasCustCd, String venNm, LeasGbcd leasGbcd) {
        leasCustCdValidation(leasCustCd);

        this.storeCd = storeCd;
        this.leasCustCd = leasCustCd;
        this.venNm = venNm;
        this.leasGbcd = leasGbcd;
    }

    private void leasCustCdValidation(String leasCustCd) {
        final String REGEX = "^[0-9]{5}$";

        if(!leasCustCd.matches(REGEX)) {
            throw new IllegalArgumentException("협력사코드는 숫자 5자리로 등록해주세요.");
        }
    }

    public void setVenNm(String venNm) {
        this.venNm = venNm;
    }

    public void setLeasGbcd(LeasGbcd leasGbcd) {
        this.leasGbcd = leasGbcd;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vendor) {
            Vendor vendor = (Vendor) obj;
            if (this.storeCd == vendor.getStoreCd()) {
                if (this.leasCustCd.equals(vendor.getLeasCustCd())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.storeCd, this.leasCustCd);
    }

    @Override
    protected Vendor clone() throws CloneNotSupportedException {
        return (Vendor) super.clone();
    }
}
