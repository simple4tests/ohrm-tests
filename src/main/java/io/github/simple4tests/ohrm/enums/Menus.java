package io.github.simple4tests.ohrm.enums;

public enum Menus {

    ADMIN("index.php/admin/viewAdminModule"),
    ADMIN__NATIONALITIES("index.php/admin/nationality"),
    PIM("index.php/pim/viewPimModule"),
    PIM__CONFIGURATION__OPTIONAL_FIELDS("index.php/pim/configurePim"),
    PIM__ADD_EMPLOYEE("index.php/pim/addEmployee"),
    MY_INFO("index.php/pim/viewMyDetails"),
    MY_INFO__EMERGENCY_CONTACTS("index.php/pim/viewMyDetails"),
    DASHBOARD("index.php/dashboard"),
    BUZZ("index.php/buzz/viewBuzz");

    public final String href;

    Menus(String href) {
        this.href = href;
    }
}
