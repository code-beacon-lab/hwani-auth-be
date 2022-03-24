package com.boiler.auth.lease;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendorTest {

    @Test
    @DisplayName("협력사코드 검증")
    void leasCustCdValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Vendor(StoreCd.본점, "200000"));
        assertEquals("협력사코드는 숫자 5자리로 등록해주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("얕은복사 깊은복사 테스트")
    void copyTest() throws CloneNotSupportedException {
        Vendor vendorOrigin = new Vendor(StoreCd.본점, "20018", "크리스찬디올", LeasGbcd.임대을);
        Vendor shallowCopyVen = vendorOrigin; // 얕은복사
        Vendor deepCopyVen = (Vendor) vendorOrigin.clone(); // 깊은복사
        deepCopyVen.setVenNm("Dior");

        assertAll(
                () -> assertEquals(vendorOrigin.getVenNm(), shallowCopyVen.getVenNm()),
                () -> assertNotEquals(vendorOrigin.getVenNm(), deepCopyVen.getVenNm())
        );
    }

    @Test
    @DisplayName("equals 재정의 테스트")
    void equalsTest() {
        Vendor vendor = new Vendor(StoreCd.본점, "20018", "Dior", LeasGbcd.임대갑);
        Vendor compare1 = new Vendor(StoreCd.본점, "20018", "크리스찬디올", LeasGbcd.임대을);
        Vendor compare2 = new Vendor(StoreCd.김포아울렛, "20018");

        assertTrue(vendor.equals(compare1));
        assertFalse(vendor.equals(compare2), () -> "점코드, 협력사코드가 같아야 합니다.");
    }

    @Test
    @DisplayName("hashcode 재정의 테스트")
    void hashcodeTest() {
        Vendor vendor = new Vendor(StoreCd.본점, "20018", "Dior", LeasGbcd.임대갑);
        Vendor compare1 = new Vendor(StoreCd.본점, "20018", "크리스찬디올", LeasGbcd.임대을);
        Vendor compare2 = new Vendor(StoreCd.김포아울렛, "20018");

        assertEquals(vendor.hashCode(), compare1.hashCode());
        assertNotEquals(vendor.hashCode(), compare2.hashCode());
    }
}