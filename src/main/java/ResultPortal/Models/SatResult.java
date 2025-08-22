package ResultPortal.Models;

public class SatResult {
    private String name;
    private String address;
    private String city;
    private String country;
    private String pincode;
    private int satScore;
    private boolean passed;


    public SatResult() {}

    public SatResult(String name, String address, String city, String country, String pincode, int satScore) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
        this.satScore = satScore;
        this.passed = satScore > 30;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPincode() {
        return pincode;
    }

    public int getSatScore() {
        return satScore;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setSatScore(int satScore) {
        this.satScore = satScore;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    @Override
    public String toString() {
        return "SatResult{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", pincode='" + pincode + '\'' +
                ", satScore=" + satScore +
                ", passed=" + passed +
                '}';
    }
}