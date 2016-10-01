package com.gateszeng.sdhacks2016;

import java.util.ArrayList;

/**
 * Created by gates on 10/1/2016.
 */

public class Person {
    String firstLastName;
    String homePhone, cellPhone, workPhone;
    String houseAddress;
    String emailAddress;

    public Person(String flName) {
        firstLastName = flName;
    }

    public Person(String pName, String hPhone, String cPhone,
                  String wPhone, String hAddress,String eAddress) {
        firstLastName = pName;
        homePhone = hPhone;
        cellPhone = cPhone;
        workPhone = wPhone;
        houseAddress = hAddress;
        emailAddress = eAddress;
    }

    /* Getters & Setters */
    public String getfirstLastName() { return firstLastName; }


    public String getHomePhone() { return homePhone; }

    public String getCellPhone() { return cellPhone; }

    public String getWorkPhone() { return workPhone; }

    public String getHouseAddress() { return houseAddress; }

    public String getEmailAddress() { return emailAddress; }

    public void setFirstLastName(String pname) { firstLastName = pname; }



    public void setHomePhone(String num) { homePhone = num; }

    public void setCellPhone(String num) { cellPhone = num; }

    public void setWorkPhone(String num) { workPhone = num; }

    public void setHouseAddress(String hAddress) { houseAddress = hAddress; }

    public void setEmailAddress(String eAddress) { emailAddress = eAddress; }

}
