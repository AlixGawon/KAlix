import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.*;

/**
 * Created by danawacomputer on 2017-04-13.
 */
public class Exception2 {
    public static void main(String[] args) throws java.lang.Exception {

        FileReader fr = null;
        try{
            fr = new FileReader("src\\Parks.csva");//csv인데 a가 오타처리 남.
        }
        catch (FileNotFoundException e) {//오타가 나서 파일을 못 읽는 상황을 유연히 넘기기 위한 Exception
            System.out.println("파일이 없어요");
            System.exit(0);
        }

        BufferedReader br = new BufferedReader(fr);
    }
}
