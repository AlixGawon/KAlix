import com.opencsv.CSVReader;
import model.Park;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by danawacomputer on 2017-04-19.
 */
public class Test {
    public static void main(String[] args) {

        //한 라인씩 나눠주고 저절로 나눠줌 CSVReader를 쓰면 BufferedReader 보다 더 쉽게 사용할 수 있음(따로 파일 저장해서 써야 함.)
        try {
            CSVReader reader = new CSVReader(new FileReader("src\\Parks.csv"));

            List<Park> list = new ArrayList<>();

            reader.readNext(); //skip the first line

            String[] spl = null;//저절로 split 시켜주니까 변수명 이렇게 지정
            while ((spl = reader.readNext()) != null){
                list.add(new Park(spl[0],spl[1],spl[2],spl[3],spl[4],spl[5]));
            }
            //sorting 하기

            Collections.sort(list, (a, b) -> a.getState().compareTo(b.getState()));



            //boolean 을 return 하는 식

//            Predicate<Park> p = new Predicate<Park>() {
//                @Override
//                public boolean test(Park park) {
//                   return park.getParkAlias() == null || park.getParkAlias().equals("");
//                }
//            };

            //filtering 하기. remove 하는 것 한 줄로 바꾸기
            list.removeIf(p -> p.getParkAlias() == null || p.getParkAlias().equals(""));

            //list.removeIf(p);//parkAlias가 없는 데이터 제거 후 출력

            //printing 하기.
//           for문 람다식으로 바꾸기
//            for (Park e : list) {
//                System.out.println(e);
//            }
            list.forEach(e -> System.out.println(e));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
