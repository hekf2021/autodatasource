package com.eck.auto.test;

import com.eck.auto.utils.HttpRequest;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/7/22.
 */
public class Test {
    public static void main(String[] args){
        String url1="http://localhost:8080/app/hekf/1";
        String url2="http://localhost:8080/all/lp/2";
        MyThread mt1 = new MyThread(10000,"ds1",url1);
        MyThread mt2 = new MyThread(10000,"ds2",url2);

        MyThread mt3 = new MyThread(10010,"ds3",url1);
        mt1.start();
        mt2.start();
        mt3.start();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str =scanner.next();
            System.out.println("当前输入:"+str);
        }
    }
}
