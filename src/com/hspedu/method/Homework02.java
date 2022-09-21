package com.hspedu.method;

public class Homework02 {
    //(1) 有2个用户分别从同一个卡上取钱(总额：10000)
    //(2) 每次都取1000，当余额不足时，就不能取款了
    //(3) 不能出现超取现象 =》 线程同步问题
    public static void main(String[] args) {
        T t = new T();
        Thread thread01 = new Thread(t);
        thread01.setName("T1");
        Thread thread02 = new Thread(t);
        thread02.setName("T2");
        thread01.start();
        thread02.start();


    }
}

class T implements Runnable {

    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this){
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }

                money -= 1000;

                System.out.println(Thread.currentThread().getName() + "取出1000元，剩余余额=" + money);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
