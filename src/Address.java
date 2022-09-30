import java.io.Serializable;

public class Address implements Serializable {
    private String city;
    private String street;
    private int house;

    public Address(String city, String street, int house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    private void setHouse(int house) {
        this.house = house;
    }

    private String getCity() {
        return this.city;
    }

    private String getStreet() {
        return this.street;
    }

    private int getHouse() {
        return this.house;
    }


    @Override
    public String toString() {
        return city + ", " + street + " " + house;
    }
}
