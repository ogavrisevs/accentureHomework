package com.bla.laa.JavaComparator;

import java.util.Comparator;

public class Checker implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        Player p1 = (Player) o;
        Player p2 = (Player) t1;

        if (p1.score < p2.score)
            return 1;

        if (p1.score > p2.score)
            return -1;

        if (p1.score == p2.score)
            return p1.name.compareTo(p2.name);

        return 0;
    }

}
