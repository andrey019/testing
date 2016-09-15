package andrey019;


import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Letters {

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
        String text = stringBuilder.toString();
        System.out.println("String generation time: " + (System.currentTimeMillis() - time) + "ms");



        // kalash method, pure hashmap
        time = System.currentTimeMillis();
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
        Character character;
        for (int i = 0; i < text.length(); i++) {
            character = text.charAt(i);
            if (letters.containsKey(character)) {
                letters.put(character, letters.get(character) + 1);
            } else {
                letters.put(character, 1);
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
        System.out.println("Pure hashmap: " + result.getKey() + " = " + result.getValue() + ", " +
                (System.currentTimeMillis() - time) + "ms");


        // kalash method, obj hashmap
        time = System.currentTimeMillis();
        HashMap<Character, NumberObj> letters1 = new HashMap();
        Character character1;
        for (int i = 0; i < text.length(); i++) {
            character1 = text.charAt(i);
            if (letters1.containsKey(character1)) {
                letters1.get(character1).addOne();
            } else {
                letters1.put(character1, new NumberObj());
            }
        }
        Map.Entry<Character, NumberObj> result1 = null;
        for (Map.Entry<Character, NumberObj> entry : letters1.entrySet()) {
            if (result1 == null) {
                result1 = entry;
            } else {
                if (entry.getValue().getNumber() > result1.getValue().getNumber()) {
                    result1 = entry;
                }
            }
        }
        System.out.println("Obj hashmap: " + result1.getKey() + " = " + result1.getValue().getNumber() + ", " +
                (System.currentTimeMillis() - time) + "ms");



        // timon method (what i thought it would be like)
//        time = System.currentTimeMillis();
//        ArrayList<Character> characters = new ArrayList<>();
//        ArrayList<NumberObj> integers = new ArrayList<>();
//        Character character2;
//        for (int i = 0; i < text.length(); i++) {
//            character2 = text.charAt(i);
//            if (characters.contains(character2)) {
//                //integers.add(characters.indexOf(character2), integers.get(characters.indexOf(character2)) + 1);
//                integers.get(characters.indexOf(character2)).addOne();
//            } else {
//                characters.add(character2);
//                integers.add(new NumberObj());
//            }
//        }
//
//        long intResult = 0;
//        int position = 0;
//        for (int i = 0; i < characters.size(); i++) {
//            if (intResult < integers.get(i).getNumber()) {
//                intResult = integers.get(i).getNumber();
//                position = i;
//            }
//        }
//        System.out.println(characters.get(position) + " = " + integers.get(position).getNumber() + ", " +
//                (System.currentTimeMillis() - time) + "ms");



        // timon method (what i thought it would be like)
//        time = System.currentTimeMillis();
//        ArrayList<Character> characters = new ArrayList<>();
//        ArrayList<Integer> integers = new ArrayList<>();
//        Character character2;
//        for (int i = 0; i < text.length(); i++) {
//            character2 = text.charAt(i);
//            if (characters.contains(character2)) {
//                integers.add(characters.indexOf(character2), integers.get(characters.indexOf(character2)) + 1);
//                integers.remove(characters.indexOf(character2) + 1);
//            } else {
//                characters.add(character2);
//                integers.add(1);
//            }
//        }
//
//        Integer intResult = 0;
//        int position = 0;
//        for (int i = 0; i < characters.size(); i++) {
//            if (intResult < integers.get(i)) {
//                intResult = integers.get(i);
//                position = i;
//            }
//        }
//        System.out.println(characters.get(position) + " = " + integers.get(position) + ", " +
//                (System.currentTimeMillis() - time) + "ms");



        // timon method (what it actually happened to be)
//        String kalash = text;
//        time = System.currentTimeMillis();
//        String[] stringname = new String[kalash.length()];
//        int[] intcount = new int[kalash.length()];
//        for (int i=0; i<stringname.length; i++)
//        {
//            boolean exist = false;
//            int RememberEmptySlot = -1;
//            int RememberFullSlot = -1;
//            for( int j=0; j<stringname.length; j++)
//            {
//                if (i == kalash.length() - 1) {
//                    if(kalash.substring(i).equals(stringname[j]))
//                    {
//                        exist = true;
//                        RememberFullSlot = j;
//                    }
//                    else if(stringname[j]==null && RememberEmptySlot==-1)
//                    {
//                        RememberEmptySlot = j;
//                    }
//                } else {
//                    if(kalash.substring(i,i+1).equals(stringname[j]))
//                    {
//                        exist = true;
//                        RememberFullSlot = j;
//                    }
//                    else if(stringname[j]==null && RememberEmptySlot==-1)
//                    {
//                        RememberEmptySlot = j;
//                    }
//                }
//
//            }
//            if(exist==false)
//            {
//                if (i == kalash.length() - 1) {
//                    stringname[RememberEmptySlot] = kalash.substring(i);
//                    intcount[RememberEmptySlot] += 1;
//                } else {
//                    stringname[RememberEmptySlot] = kalash.substring(i, i + 1);
//                    intcount[RememberEmptySlot] += 1;
//                }
//
//            }
//            else
//            {
//                intcount[RememberFullSlot] += 1;
//            }
//            exist = false;
//            RememberEmptySlot = -1;
//        }
//        int max = 0;
//        int index = -1;
//        for(int i=0; i<intcount.length;i++)
//        {
//            if(max<intcount[i])
//            {
//                max = intcount[i];
//                index = i;
//            }
//        }
//
//        System.out.println("MAX="+ intcount[index] + " Char is " + stringname[index] + ", " +
//                (System.currentTimeMillis() - time) + "ms");
    }
}
