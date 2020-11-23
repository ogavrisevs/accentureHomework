package com.bla.laa.JavaStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> inputList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
                String input=sc.next();
                inputList.add(input);
        }

        for (String str : inputList){
            System.out.println(process(str));
        }

    }

    private static  Boolean process(String in){
        while (true) {
            if  (in.contains("{}")) {
                in = in.replace("{}", "");
                continue;
            } else if (in.contains("()")) {
                in = in.replace("()", "");
                continue;
            } else if (in.contains("[]")) {
                in = in.replace("[]", "");
                continue;
            }

            if (in.length() >= 1)
                return Boolean.FALSE;

            if (in.length() == 0)
                return Boolean.TRUE;
        }
    }
}
