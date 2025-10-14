package Chapter1;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        float a = 3.554f, b = 7.343f;

        System.out.println("테스트 출력");
        System.out.println(a);
        System.out.println(b);

        System.out.println("사칙연산");
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);

        System.out.println("대입, 복합대입연산");
        a = 5.554f;
        a += 1.3f;
        System.out.println(a);
        a -= 1.3f;
        System.out.println(a);
        a *= 1.1f;
        System.out.println(a);
        a /= 1.1f;
        System.out.println(a);

        System.out.println("증감 연산");
        System.out.println(++a);
        System.out.println(--a);
        System.out.println(a++);
        System.out.println(a--);

        System.out.println("비교 연산");
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a != b);

        System.out.println("논리 연산");
        System.out.println(a < b && b > a);
        System.out.println(a < b || a == b);
        System.out.println(!(a > b));

        System.out.println("기본 연산자 우선 순위(산술->비교->논리->대입");
        boolean flag = 10 + 3 > 12 && true;
        System.out.println(flag);

        System.out.println("문자열 비교는 String.equal(arg)");
        String text1 = "Hi";
        String text2 = "Hi";
        flag = text1.equals(text2);
        System.out.println(flag);

        System.out.println("실습과제1 : 정수 사칙연산 결과출력");
        int x = 10, y = 20;

        System.out.println("덧셈 결과 : " + (x + y));
        System.out.println("뺄셈 결과 : " + (x - y));
        System.out.println("곱셈 결과 : " + (x * y));
        System.out.println("나눗셈 결과 : " + (x / y));
        System.out.println("나머지 결과 : " + (x % y));

        System.out.println("실습과제2 : 정수 비교연산 결과출력");
        System.out.println("x가 y보다 큰가? : " + (x > y));
        System.out.println("x가 y보다 작은가? : " + (x < y));
        System.out.println("x가 y가 같은가? : " + (x == y));
        System.out.println("x가 y가 다른가? : " + (x != y));

        System.out.println("실습과제3 : 문자열 비교 결과출력");
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 문자열을 입력하세요: ");
        String str1 = sc.nextLine();
        System.out.print("두 번째 문자열을 입력하세요: ");
        String str2 = sc.nextLine();
        System.out.println("두 문자열이 같은가요? " + str1.equals(str2));
    }
}