package org.example.pojo;

public class Money {
    private String country;

    @Override
    public String toString() {
        return "Money{" +
                "country='" + country + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Money() {
    }

    public Money(String country) {
        this.country = country;
    }
}
