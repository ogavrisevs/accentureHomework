package com.bla.laa.JavaDequeue;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        HashSet uniqSet = new HashSet();
        int n = in.nextInt();
        int m = in.nextInt();
        Integer uniq = 0 ;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.addLast(num);
            uniqSet.add(num);

            if (deque.size() == (m + 1) ){
                Integer removed  = deque.removeFirst();
                if (!deque.contains(removed)) {
                    uniqSet.remove(removed);
                }
            }

            if (uniq < uniqSet.size())
                uniq = uniqSet.size();

        }
        System.out.println(uniq);
    }
}
