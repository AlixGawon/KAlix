import java.util.Scanner;

/**
 * Created by danawacomputer on 2017-04-12.
 */
public class Exception {

    public static void main(String[] args) {

        while(true) {
            System.out.println("숫자를 입력하세요.");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            try{
                int converted = Integer.parseInt(userInput);//
                System.out.printf("당신이 입력한 숫자는 %d 입니다.", converted);
                break;//이것을 해줘야지 올바를 때 무한반복 안 함.
            } catch (NumberFormatException e) {
                System.out.println("잘못된 숫자를 입력하셨습니다.");
            }
        }
    }
}
