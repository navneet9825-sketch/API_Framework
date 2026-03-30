package pojo.registration;

public class Address
{
    /*
    "address": {
                    "street": "Street 1",
                    "city": "City",
                    "state": "State",
                    "country": "Country",
                    "postal_code": "1234AA"
                  }
     */

    private String street;
    private String city;
    private String state;
    private String country;
    private String postal_code;

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public Address setPostal_code(String postal_code) {
        this.postal_code = postal_code;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

}
