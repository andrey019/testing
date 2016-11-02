package andrey019.interview;


import andrey019.NumberObj;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {
        System.out.print("String length in thousands: ");
        int thousands = new Scanner(System.in).nextInt();
        long time = System.currentTimeMillis();

        // random text generation
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < thousands; i++) {
            stringBuilder.append(RandomStringUtils.random(1000, true, true));
            stringBuilder.append("\r\n");
        }
        System.out.println("StringBuilder generation time: " + (System.currentTimeMillis() - time) + "ms");
        time = System.currentTimeMillis();
        String text = stringBuilder.toString();
        System.out.println("String conversion time: " + (System.currentTimeMillis() - time) + "ms");

        // method 1
        time = System.currentTimeMillis();

        Character answer = findNonRepeatedChar(text);

        System.out.println("method 1 time: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println("answer: " + answer);

        // method 2
        time = System.currentTimeMillis();

        Character answer1 = findNonRepeatedCharNew(text);

        System.out.println("method 2 time: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println("answer: " + answer1);

        // method 3
        time = System.currentTimeMillis();

        Character answer2 = findNonRepeatedCharNew(text);

        System.out.println("method 3 time: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println("answer: " + answer2);
    }

    public static Character findNonRepeatedChar(String text) {
        HashMap<Character, Long> lettersRepeats = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (lettersRepeats.containsKey(text.charAt(i))) {
                lettersRepeats.put(text.charAt(i), lettersRepeats.get(text.charAt(i)) + 1);
            } else {
                lettersRepeats.put(text.charAt(i), 1L);
            }
        }
        Character answer = null;
        for (int i = 0; i < text.length(); i++) {
            answer = text.charAt(i);
            if (lettersRepeats.get(answer) == 1) {
                return answer;
            }
        }
        return null;
    }

    public static Character findNonRepeatedCharNew(String text) {
        HashMap<Character, NumberObj> lettersRepeats = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (lettersRepeats.containsKey(text.charAt(i))) {
                lettersRepeats.get(text.charAt(i)).addOne();
            } else {
                lettersRepeats.put(text.charAt(i), new NumberObj());
            }
        }
        Character answer = null;
        for (int i = 0; i < text.length(); i++) {
            answer = text.charAt(i);
            if (lettersRepeats.get(answer).getNumber() == 1) {
                return answer;
            }
        }
        return null;
    }

    public static Character findNonMethod3(String text) {
        for (char letter : text.toCharArray()) {
            if (text.indexOf(letter) == text.lastIndexOf(letter)) {
                return letter;
            }
        }
        return null;
    }
}
