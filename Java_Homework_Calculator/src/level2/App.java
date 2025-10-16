package level2;

// - Level2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
// - Step1 : 사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Clculator 클래스 생성
// - Step2 : Lv1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
// - Step3 : App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정(캡슐화)
// - Step4 : Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정

public class App {
    public static void main(String[] args) {
        Calculator calc = new  Calculator();

        long sum = calc.Calculate(1349, 30143, '*');
        System.out.println(sum);
    }
}
