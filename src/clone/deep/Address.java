package clone.deep;

public class Address implements Cloneable {

    private String state;
    private String country;

    public Address(String state, String country) {
        this.state = state;
        this.country = country;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}