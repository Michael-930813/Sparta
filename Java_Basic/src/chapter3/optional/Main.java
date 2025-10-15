package chapter3.optional;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void  main(String[] args) {
        CampService camp = new CampService();
        Optional<Student[]> Opt_students = camp.getStudents();
        Scanner sc = new Scanner(System.in);
        String input_name = "";

        while(Opt_students.isPresent()) {
            System.out.print("검색할 수강생 이름을 입력하세요(eixt 입력시 종료) : ");
            input_name = sc.nextLine();
            if(input_name.equals("exit")) { break; }

            if(isIncamp(Opt_students.get(), input_name)) {
                System.out.println(input_name + "학생은 캠프에 등록되어 있습니다.");
            }
            else {
                System.out.println(input_name + "학생은 캠프에 등록되어 있지 않습니다.");
            }
        }
    }

    public static boolean isIncamp(Student[] camp, String name)
    {
        for( Student student : camp)
        {
            if(name.equals(student.getName())) { return true; }
        }
        return false;
    }
}
