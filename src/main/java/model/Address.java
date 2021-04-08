package model;

public class Address {
    private int latitude;
    private int longitude;
    private String addressName;

    public Address(int latitude, int longitude, String addressName) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.addressName = addressName;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public String getAddressName() {
        return addressName;
    }
}
