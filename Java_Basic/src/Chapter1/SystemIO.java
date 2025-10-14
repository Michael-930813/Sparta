package Chapter1;

import java.util.Scanner;

public class SystemIO {
    public static void main(String[] args) {
        // - Output
        // - print : 일반 출력함수 (변수명 + "") 자료형에 따라 박싱/언박싱이 일어날 수 있음
        System.out.print("붙");
        System.out.print("여");
        System.out.print("쓰");
        System.out.print("기\n");
        // - printf : 포맷 형식(formatter)이 적용됨. 호출마다 파싱함.
        System.out.printf("포맷형식 출력, 정수 : %d, 실수 : %f\n", 3, 0.03f);
        // - println : print에 \n추가
        System.out.println("자");
        System.out.println("동");
        System.out.println("줄");
        System.out.println("바");
        System.out.println("꿈");

        // - Input
        // - Scanner
        Scanner input = new Scanner(System.in);

        // - Char
        System.out.print("글자 하나 입력 : ");
        char c = input.next().charAt(0);
        System.out.println("입력한 글자 : " + c);

        // - int
        System.out.print("정수 입력 : ");
        int i = input.nextInt();
        System.out.println("입력한 정수 : " + i);

        // - float
        System.out.print("실수 입력 : ");
        float f = input.nextFloat();
        System.out.println("입력한 실수 : " + f);
    }
}