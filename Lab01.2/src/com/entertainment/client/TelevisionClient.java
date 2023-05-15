package com.entertainment.client;

import com.entertainment.Television;

import java.sql.SQLOutput;

public class TelevisionClient {

    public static void main(String[] args) {

        Television tv1 = new Television();
        Television tv2 = new Television("RCA", 10);
        System.out.println(tv1);

        tv1.changeChannel(9);
        System.out.println(tv1);

        Television A = new Television("Sony", 50);
        Television B = new Television("Sony", 50);

        System.out.println("A == B: " + (A==B)) ;

        System.out.println("A.equals(B): " + A.equals(B));
    }


}