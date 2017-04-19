package model;

/**
 * Created by danawacomputer on 2017-04-12.
 */
public class Park {
    //필드 설정. 데이터의 속성을 담는 용도

    private String parkKey;
    private String parkName;
    private String parkAlias;
    private String city;
    private String state;
    private String country;

    //생성자 만들기

    public Park() {
    }

    public Park(String parkKey, String parkName, String parkAlias, String city, String state, String country) {
        this.parkKey = parkKey;
        this.parkName = parkName;
        this.parkAlias = parkAlias;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    //private 처리를 하였기 때문에 다른 class에서 사용할 수 없기 때문에 setter, getter 만들기!

    public String getParkKey() {
        return parkKey;
    }

    public void setParkKey(String parkKey) {
        this.parkKey = parkKey;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkAlias() {
        return parkAlias;
    }

    public void setParkAlias(String parkAlias) {
        this.parkAlias = parkAlias;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getcountry() {
        return country;
    }

    public void setcountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Park{" +
                "parkKey='" + parkKey + '\'' +
                ", parkName='" + parkName + '\'' +
                ", parkAlias='" + parkAlias + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}