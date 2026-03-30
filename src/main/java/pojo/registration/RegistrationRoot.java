package pojo.registration;

public class RegistrationRoot
{
    /*
              {
                  "first_name": "John",
                  "last_name": "Doe",
                  "address": {
                    "street": "Street 1",
                    "city": "City",
                    "state": "State",
                    "country": "Country",
                    "postal_code": "1234AA"
                  },
                  "phone": "0987654321",
                  "dob": "1970-01-01",
                  "password": "SuperSecure@123",
                  "email": "john@doe5.example"
                }
     */

    private String first_name;
    private String last_name;
    private Address address;
    private String phone;
    private String dob;
    private String password;
    private String email;

    public RegistrationRoot(String first_name,String last_name,Address address,
                            String phone,String dob,String password,String email)
    {
        this.first_name = first_name;
        this.last_name =  last_name;
        this.address = address;
        this.phone =  phone;
        this.dob = dob;
        this.password = password;
        this.email = email;
    }

    public RegistrationRoot(){

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

}
