package salaryNStream;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class SalaryNStreamService {
    public static void main(String[] args) {
        //미리 데이터 넣을 장소 지정
        List<SalaryNStream> list = new ArrayList<>();

        //파일에서 데이터 불러오기 & 예외처리하기 & 데이터 list 에 넣기


        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("src\\Salaries.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            reader.readNext(); //skip the first line
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] spl = null;//저절로 split 시켜주니까 변수명 이렇게 지정
        try {
            while ((spl = reader.readNext()) != null) {

                LocalDate d = LocalDate.of(Integer.parseInt(spl[0]),1,1); //factory Method of로 객체 생성
                list.add(new SalaryNStream(d, spl[1], spl[2], spl[3], Integer.parseInt(spl[4])));
            }//LocalDate로 바꾸려면 of 써야 함 그리고 나서 인티저 타입으로 바꿔줘야 함.
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list);

        //본격 문제 풀이

        //1. 1900년대 평균 연봉 구하기(1985~1999)

        OptionalDouble twentyCentAver = list.stream() //mapToInt & average 쓰려면 OptionalDouble 써야함

                .filter(x -> x.getYearId().getYear() < 2000) // 애초에 LocalDate type 이니까 getYear() 메서드를 이용하기.
                .mapToInt(x -> x.getSalary()) //Salary 를 구해야 하니까
                .average();
        System.out.println(twentyCentAver);

        //2. 전체 레코드의 평균 연봉 구하기

        OptionalDouble recordAverage = list.stream()

                .mapToInt(x -> x.getSalary())
                .average();
        System.out.println(recordAverage);

        //3. 최고 연봉자와 최소 연봉자 구하기

        //최소

        list.stream()
                .sorted((o1, o2) -> o1.getSalary() - o2.getSalary()) //sort 이용해서 최소로 나오도록 mapping 하기
                .limit(1) //하나만 나오도록 (최소)
                .forEach(x -> System.out.println(x));

        //최대

        list.stream()
                .sorted((o1, o2) -> o2.getSalary() - o1.getSalary()) //sort 이용해서 최대로 나오도록 mapping 하기
                .limit(1) //하나만 나오도록 (최대)
                .forEach(x -> System.out.println(x));


        //4. NL 최고 연봉자 구하기

        OptionalDouble nlHigest = list.stream()
                .filter(x -> x.getLgId().equals("NL")) //NY 를 제외하는 값 제외
                .mapToInt(x -> x.getSalary())
                .average();


        //5.NYY 구단의 평균 연봉 구하기

        OptionalDouble nyyAver = list.stream()
                .filter(x -> x.getLgId().equals("NYY")) //NYY 를 제외하는 값 제외
                .mapToInt(x -> x.getSalary())
                .average();

        System.out.println(nyyAver);


        //6. 최상위 연봉자 10명의 평균을 구하세요

         OptionalDouble a = list.stream()
                 .sorted((o1, o2) -> o2.getSalary() - o1.getSalary())
                 .limit(10)
                 .mapToInt(x -> x.getSalary())
                 .average();
        System.out.printf("%.2f", a.getAsDouble());









    }
}
