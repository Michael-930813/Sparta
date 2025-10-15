package chapter3.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list_int = new ArrayList<>(List.of(1,2,3,4,5));

        // - Step1 : for
        List<Integer> list1 = new ArrayList<>();
        for( Integer num : list_int ) {
            int multiplenum = num * 10;
            list1.add(multiplenum);
        }
        System.out.println("List1 : " + list1);

        // - Step2 : stream
        List<Integer> list2 = list_int.stream()
                        .map(num -> num*10)
                        .collect(Collectors.toList());
        System.out.println("List2 : " + list2);

        // - Step3 : stream + function
        Function<Integer, Integer> fucntion = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*10;
            }
        };

        List<Integer> list3 = list_int.stream()
                .map(fucntion)
                .collect(Collectors.toList());
        System.out.println("List3 : " + list3);

        // - Step4 : stream + funciton + lambda
        Function<Integer, Integer> func_Lambda = (num -> num*10);
        List<Integer> list4 = list_int.stream()
                .map(func_Lambda)
                .collect(Collectors.toList());
        System.out.println("List4 : " + list4);

        // - Step5 : stream.map() + lambda
        List<Integer> list5 = list_int.stream()
                .map(num -> num*10)
                .collect(Collectors.toList());
        System.out.println("List5 : " + list5);

        // - Step6 : stream.filter() + stream.map() + lambda
        List<Integer> list6 = list_int.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * 10)
                .collect(Collectors.toList());
        System.out.println("List6 : " + list6);
    }
}
