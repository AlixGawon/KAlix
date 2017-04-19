import model.Park;

/**
 * Created by danawacomputer on 2017-04-12.
 */
public class ParkMain {
    public static void main(String[] args) {
        //Park에서 데이터받으려고 세팅해놓은 것 가져오는 작업하기

        Park cubs = new Park();
        cubs.setParkKey("CHI11");
        cubs.setParkName("Wrigley Field");
        cubs.setParkAlias("Weeghman Park; cubs Park");
        cubs.setState("IL");
        cubs.setCity("Chicago");
        cubs.setcountry("USA");


    }
}
