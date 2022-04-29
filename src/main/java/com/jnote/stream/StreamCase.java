package com.jnote.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * @author bobwang
 */
public class StreamCase {
    public static void main(String[] args) {
//        // filter
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//        // foreach
//        System.out.println(filtered);
//        strings.stream().forEach(System.out::println);

//        //map
//        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//        List<Integer> squaresList = numbers.stream().map(i->i*i).collect(Collectors.toList());
//        numbers.stream().map(i->i*i).forEach(System.out::println);
//        System.out.println(squaresList);
            //limit
//        Random random = new Random();
//        random.ints(1).limit(100).forEach(System.out::println);

//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//        System.out.println(strings.stream().anyMatch(string->string.contains("b")));
//        strings.stream().map(s -> s+"a").map(s-> s+"b").collect(Collectors.toList()).forEach(System.out::println);


//        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//        // 获取对应的平方数
////        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
//        List<Integer> squaresList = numbers.stream()
//                .map(i -> i * i)
//                .sorted((x, y) -> y - x)
//                .collect(Collectors.toList());
////        squaresList.forEach(System.out::println);
//        squaresList.forEach(num -> {
//            num++;
//            System.out.println(num);
//        });
//
//        List<String> strList = Arrays.asList("a", "ba", "bb", "abc", "cbb", "bba", "cab");
//        System.out.println(strList.stream().collect(Collectors.toMap(p->p, p->p+"value")));

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }
}
