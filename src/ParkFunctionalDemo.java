import model.Park;
import service.ParkService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


public class ParkFunctionalDemo {
    public static void main(String[] args) {

        List<Park>list =  ParkService.makeListFromCSV("src\\Parks.csv");

//        //Sorting
//        Collections.sort(list,(x,y) ->
//                x.getParkKey().length() - y.getParkKey().length()); //파라미터 2개 들어가야 함(소팅할 것, 하는 방식)
//
//        //filtering
//        list.removeIf(x -> ! x.getCity().startsWith("B"));//국가가 US인 것 필터링하기
//
//        //Printing
//        list.forEach(x -> System.out.println(x));//x 프린팅 하기.
//        list.forEach(System.out::println); //이렇게도 적을 수 있음.
//        System.out.println(list.size());

        //Stream 사용 방식(중개연산 필요 없다. 종단연산만 있음 됨.)
//        long us = list.stream()
//                .sorted((x, y) ->
//                        x.getParkKey().compareTo(y.getParkKey()))
//                .filter(x -> ! x.getCity().startsWith("B"))
//                .count();//filter 는 false 인 것이 filtering 됨. compareTo는 글자대로 비교하는 것.
//        // startsWith 는 특정 문자로 시작하는 것 처리할 때 씀
//
//        System.out.println(us);



//        //parkAlias 에 정보 없는 곳을 "없음"이라고 바꿔서 데이터 출력하는 것 (mapping : 데이터 갯수는 같음, 각각 데이터들의 내용이 바뀜)
//
//        list.stream()
//                .map(x -> {
//                    String alias = x.getParkAlias();
//                    if (alias == null || alias.equals("")) {
//                        alias = "없음";
//                    }
//                    x.setParkAlias(alias); //x 에다가 새롭게 setParkAlias 를 짜주는 것.
//                    return  x;
//                })
//                .forEach(x -> System.out.println(x));


//        //City 에 있는 정보들을 모두 소문자로 바꾸기.(이 역시 mapping 사용)
//        list.stream()
//                .map(x -> {
//
//                    x.setCity(x.getCity().toLowerCase()); //city 에 변경된 정보 한 방에 넣기
//                    return x;
//                    })
//                .forEach(x -> System.out.println(x));

//
// City 에 있는 정보들을 출력될 때 세 글자로만 출력되도록 바꾸기 + state 를 소문자로 바꾸기
//        list.stream()
//                .map(x -> {
//                    x.setCity(x.getCity().substring(0,3));
//                    return x;
//                })
//                .map(x -> {
//                    x.setState(x.getState().toLowerCase());//toLowerCase 메서드는 소문자로 바꿔줌
//                    return x;
//                })
//                .forEach(x -> System.out.println(x));

//
        //10개 skip 하고 limit 으로 10개 걸고
        // country 에서 US 면 미국, MX 면 멕시코, JP 면 일본, CA 면 캐나다, AU 는 호주, PR 은 푸에르토리코, 무명국(MX 지정 안 함)은 안 나오게 함.
        List<Park> resultList = list.stream()
                .skip(10)//10개 스킵 한 것
                .limit(10)
                .peek(System.out::println)// 이것도 forEach 처럼 출력함(로그처럼 중간중간 데이터를 체크할 수 있음.)
                .map(x ->{
                    x.setcountry(ParkService.resolveCountry(x.getcountry()));//별도의 함수로 뺌(ParkService 상단에 위치)
                    return x;
                })
                .filter(x -> !x.getcountry().equals("무명국"))//무명국은 안 나옴
                //.forEach(System.out::println);
                .collect(Collectors.toList()); //반드시 종단연산 필요함.

        resultList.forEach(System.out::println);


        //ParkName의 숫자로 mapping 하고 그 숫자로 average 구하기.

//        OptionalDouble d = list.stream() //변수 정해놓기 stream 이 비어있다면 그냥 double 을 return 해주기 그러니까 ..optional붙임
//                .mapToInt(x -> x.getParkName().length()) //문자열을 인트형으로 변환해주는 mapToInt
//                .peek(System.out::println)
//                .average();//평균 구하기
//
//        if (d.isPresent()) {
//            System.out.println(d.getAsDouble());
//        } else {
//            System.out.println("값이 없어요");
//        }
//
////        System.out.println(d);//람다식으로 forEach 쓰면 에러가 남. 그래서 앞에서 변수 정해놓고 출력


    }

}
