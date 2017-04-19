package service;

import model.Park;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-12.
 */
public class ParkService {
    public static void main(String[] args) throws Exception {
        //정보 저장할 장소 만들기
        List<Park> list = new ArrayList();
        //csv 파일 읽기
        BufferedReader br = new BufferedReader(new FileReader("src\\Parks.csv"));
        br.readLine(); //첫 번째 라인 스킵. 안 그러면 String하고 int값 준 것이 혼선 올 수 있음.

        //읽은 파일 while 문 돌려서 list 안에 넣기

        String line = "";//while 문 돌릴 때 사용

        while ((line = br.readLine()) != null) {

            //String[]의 객체를 splitted로 생성한 후 , 단위로 나누고 list안에 넣는다.
            String[] splitted = line.split(",");
            list.add(new Park(splitted[0], splitted[1], splitted[2], splitted[3], splitted[4], splitted[5]));

            //주별로 정리됨. 람다식으로 정리

            Collections.sort(list, (o1, o2) -> {
                String st1 = o1.getState();
                String st2 = o2.getState();
                return st1.compareTo(st2);
            });

            //Comparator 사용해서 List에 있는 데이터 sorting 하기
//            Comparator c = new Comparator<Park>() { //MyComparator라는 클래스 대신 사용. 익명 컴페레터라고도 함. 여기서 에러뜨면 빨간 전구 눌러서 메서드를 생성하여 오버라이드 하면 됨
//                @Override
//                public int compare(Park o1, Park o2) {
//                    String first = o1.getcountry().toUpperCase();
//                    String second = o2.getcountry().toUpperCase();
//
//                    return first.compareTo(second);
//                }
//            };//;꼭 써줘야 함
//            Collections.sort(list, c);
            System.out.println(list);
        }
    }
}
