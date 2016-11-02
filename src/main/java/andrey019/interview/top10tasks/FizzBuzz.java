package andrey019.interview.top10tasks;


import andrey019.interview.InitTests.InitObj;

import java.util.SortedSet;
import java.util.TreeSet;

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(50));
        SortedSet<InitObj> sortedSet = new TreeSet<>();
    }

    private static String fizzBuzz(int max) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < max; i++) {
            if ((i % (3 * 5)) == 0) {
                stringBuilder.append("fizzbuzz");
            } else if ((i % 5) == 0) {
                stringBuilder.append("buzz");
            } else if ((i % 3) == 0) {
                stringBuilder.append("fizz");
            } else {
                stringBuilder.append(i);
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
