package andrey019.interview.top10tasks;


import andrey019.interview.InitTests.InitObj;

import java.util.*;

public class CompareTests {

    public static void main(String[] args) {
        SortedSet<InitObj> sortedSet = getPopulatedSet(10);
        System.out.println(sortedSet.toString());
        sortedSet = Collections.synchronizedSortedSet(sortedSet);

    }

    private static SortedSet<InitObj> getPopulatedSet(int amount) {
        SortedSet<InitObj> sortedSet = new TreeSet<>(new InitObjComparator());
        Random random = new Random();
        for (int i = 0; i < amount; i++){
            sortedSet.add(new InitObj(random.nextInt(100)));
        }
        return sortedSet;
    }

    public static class OloloComparator implements Comparator<CompareTests> {

        private int value;

        @Override
        public int compare(CompareTests o1, CompareTests o2) {
            return 0;
        }
    }
}
