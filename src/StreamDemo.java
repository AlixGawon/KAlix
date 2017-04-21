import salaryNStream.SalaryNStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by danawacomputer on 2017-04-21.
 */
public class StreamDemo {
    public static void main(String[] args) {

        //람다식으로 적기

        try {
            Map<String, SalaryNStream> map =
            Files.lines(Paths.get("src\\Salaries.csv")) //Files.lines 자체로 stream 이 생성됨. // 귀찮게 BufferedReader 안 읽어도 됨.
                    .skip(1) //한 줄 띄어넘기.
                    .map(x -> {
                        String[] spl = x.split(","); //하나씩 쪼개기
                        return new SalaryNStream(LocalDate.of(Integer.parseInt(spl[0]),1,1)
                                ,spl[1],spl[2],spl[3],Integer.parseInt(spl[4]));
                    })
//                    .collect(Collectors.toList()); //stream 을 List 에 담기.
            .collect(Collectors.toMap(
                    x -> String.valueOf(new Random().nextInt()), x -> x));//랜덤한 자료를 인트로 바꾼 뒤 String 형태로 변환해서? key가 중복되지 않아야 함.
            //Mapping 에는 첫 번째 파라미터로 key, 두 번째 value 들어감

            map.forEach((k,v) -> System.out.println(k + ":" + v));

            //직접 Stream 생성하기

//            Stream.of("a","b","c","d")
//                    .forEach(System.out::println);

            //숫자의 Stream 생성하기

//           long sum =  LongStream.range(1,10000000)
//                   .sum();
//            System.out.println(sum);

            //1이라는 숫자를 생산. 무한 스트림 (Stream 은 Lazy 방식. 단점 : 데이터가 한 번 흘러가면 다시 돌아오지 못 한다. 재사용 못 함. )

//            IntStream.generate(() -> 1)
//                    .forEach(System.out::println);

            //무한 스트림

//            Random r = new Random();
//            r.ints().forEach(System.out::println);

            //주사위 굴리기

//            Random r1 = new Random();
//            r1.ints(1,7)
//                    .limit(1000000)
//                    .forEach((System.out::println));




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
