package com.eck.auto.test;

import com.eck.auto.utils.HttpRequest;

/**
 * Created by Administrator on 2018/7/22.
 */
public class MyThread extends Thread {
    int dsNo;
    String ds;
    String url;

    public MyThread(int no,String ds,String url){
        this.dsNo =no;
        this.ds=ds;
        this.url=url;
    }
    @Override
    public void run() {
        for(int i = 0; i< dsNo; i++) {
            String result1 = HttpRequest.sendGet(url);
            System.out.println(ds + "===" + result1);
        }
    }
}
