package service;

import com.opencsv.CSVReader;
import model.Park;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-12.
 */
public class ParkService {

    public static String resolveCountry(String code) {
        switch (code) {
            case "US":
                return "미국";
            case "CA":
                return "캐나다";
            case "AU":
                return "호주";
            case "JP":
                return "일본";
            case "PR":
                return "푸에르토리코";
            default:
                return "무명국"; //일부러 MX 멕시코 제외함.
        }
    }
   public static List<Park> makeListFromCSV(String filename) {

       List<Park> list = new ArrayList<>(); //container for Park objects. null 쓰지 않으려고. 예외가 발생하면 비어있는 list가 return 됨
       try {
           CSVReader reader = new CSVReader(new FileReader(filename)); //split 사용 안 해도 됨.


           reader.readNext(); //skip the first line
           String[] spl = null;
           while ((spl = reader.readNext()) != null) {
               list.add(new Park(spl[0],spl[1],spl[2],spl[3],spl[4],spl[5]));
           }

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return list;//정상적으로 끝나지 않을 때를 대비 하지만 null 을 return 하는 것은 별로 옳은 일 아님 의도를 알 수 없음.
   }
}
