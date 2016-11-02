package andrey019.interview.top10tasks;


import org.apache.commons.lang3.RandomStringUtils;

public class ReplaceCharacters {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        String text = getText(10000);
        System.out.println("generation time: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        //System.out.println(replace(text, 'f', 'W'));
        String ololo = replace(text, 'f', 'W');
        System.out.println("charArray: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        //System.out.println(replaceSplit(text, 'f', 'W'));
        ololo = replaceSplit(text, 'f', 'W');
        System.out.println("split time: " + (System.currentTimeMillis() - time));
    }

    private static String replace(String str, char oldChar, char newChar) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == oldChar) {
                array[i] = newChar;
            }
        }
        return new String(array);
    }

    private static String replaceSplit(String str, char oldChar, char newChar) {
        String[] array = str.split(Character.toString(oldChar));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            stringBuilder.append(array[i]);
            stringBuilder.append(newChar);
        }
        stringBuilder.append(array[array.length - 1]);
        return stringBuilder.toString();
    }

    private static String getText(int thousands) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < thousands; i++) {
            stringBuilder.append(RandomStringUtils.random(1000, true, true));
            stringBuilder.append("\r\n");
        }
        return stringBuilder.toString();
    }
}
