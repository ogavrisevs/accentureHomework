package com.bla.laa.PrimeChecker;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

import static java.lang.System.*;


class Prime{

    public void checkPrime(int... pp) {
        for(int input: pp) {
            if (input < 2)
                continue;

            boolean flag = false;
            for(int i = 2; i <= input / 2; ++i) {
                if(input % i == 0){
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.print(input + " ");
        }
        out.println();
    }
}

public class Main {

    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            int n1=Integer.parseInt(br.readLine());
            int n2=Integer.parseInt(br.readLine());
            int n3=Integer.parseInt(br.readLine());
            int n4=Integer.parseInt(br.readLine());
            int n5=Integer.parseInt(br.readLine());
            Prime ob=new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1,n2);
            ob.checkPrime(n1,n2,n3);
            ob.checkPrime(n1,n2,n3,n4,n5);
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++)
            {
                if(set.contains(methods[i].getName()))
                {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if(overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
