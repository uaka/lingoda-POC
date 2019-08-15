package models;

import helper.RandomDataHelper;


public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String skype;
    private String birthPlace;
    private String invoiceAddress;
    private String level;
    private String countryName;
    private String continent;
    private String city;

    public Student() {
        this.firstName = RandomDataHelper.getFirstName();
        this.lastName = RandomDataHelper.getLastName();
        this.email = RandomDataHelper.getEmail(firstName);
        this.phone = RandomDataHelper.getRandomMobile();
        this.password = "password";
        this.skype = "StudentSkype";
        this.birthPlace = RandomDataHelper.getRandomCity();
        this.invoiceAddress = RandomDataHelper.getRandomSecondaryAddress();
        this.level = "A1.1";
        this.countryName = RandomDataHelper.getRandomCountry();
        this.continent = "Europe";
        this.city = RandomDataHelper.getRandomCity();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getSkype() {
        return skype;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public String getLevel() {
        return level;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getContinent() {
        return continent;
    }

    public String getCity() {
        return city;
    }
}
