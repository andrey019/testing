package andrey019;


import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Letters {

    public static void main(String[] args) {

        // random text generation
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(RandomStringUtils.random(100, true, true));
            stringBuilder.append("\r\n");
        }
        String text = stringBuilder.toString();
        long time = System.currentTimeMillis();



        // kalash method
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
        Character character1;
        for (int i = 0; i < text.length(); i++) {
            character1 = text.charAt(i);
            if (letters.containsKey(character1)) {
                letters.put(character1, letters.get(character1) + 1);
            } else {
                letters.put(character1, 1);
            }
        }
        Map.Entry<Character, Integer> result = null;
        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            if (result == null) {
                result = entry;
            } else {
                if (entry.getValue() > result.getValue()) {
                    result = entry;
                }
            }
        }
        System.out.println(result.getKey() + " = " + result.getValue() + ", " + (System.currentTimeMillis() - time));



        // timon method
        time = System.currentTimeMillis();
        ArrayList<Character> characters = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        Character character;
        for (int i = 0; i < text.length(); i++) {
            character = text.charAt(i);
            if (characters.contains(character)) {
                integers.add(characters.indexOf(character), integers.get(characters.indexOf(character)) + 1);
            } else {
                characters.add(character);
                integers.add(1);
            }
        }

        Integer intResult = 0;
        int position = 0;
        for (int i = 0; i < characters.size(); i++) {
            if (intResult < integers.get(i)) {
                intResult = integers.get(i);
                position = i;
            }
        }
        System.out.println(characters.get(position) + " = " + integers.get(position) + ", " + (System.currentTimeMillis() - time));
    }
}
