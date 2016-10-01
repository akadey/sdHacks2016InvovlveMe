package com.gateszeng.sdhacks2016;

import java.util.ArrayList;

/**
 * Created by gates on 10/1/2016.
 */

public class Person {
    String firstName, lastName;
    String homePhone, cellPhone, workPhone;
    String houseAddress;
    String emailAddress;

    public Person(String fName, String lName) {
        firstName = fName;
        lastName = lName;
    }

    /* Getters & Setters */
    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getHomePhone() { return homePhone; }

    public String getCellPhonePhone() { return cellPhone; }

    public String getWorkPhone() { return workPhone; }

    public String getHouseAddress() { return houseAddress; }

    public String getEmailAddress() { return emailAddress; }

    public void setFirstName(String fname) { firstName = fname; }

    public void setLastName(String lName) { lastName = lName; }

    public void setHomePhone(String num) { homePhone = num; }

    public void setCellPhone(String num) { cellPhone = num; }

    public void setWorkPhone(String num) { workPhone = num; }

    public void setHouseAddress(String hAddress) { houseAddress = hAddress; }

    public void setEmailAddress(String eAddress) { emailAddress = eAddress; }

}
