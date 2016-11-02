package andrey019.interview.top10tasks;


import andrey019.interview.InitTests.InitObj;

import java.util.Comparator;

public class InitObjComparator implements Comparator<InitObj> {


    @Override
    public int compare(InitObj o1, InitObj o2) {
        if (o1.getSomeValue() > o2.getSomeValue()) {
            return 1;
        } else if (o1.getSomeValue() == o2.getSomeValue()) {
            return 0;
        } else {
            return -1;
        }
    }
}
