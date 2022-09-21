package com.hspedu.method;

public class ThreadMethodExercise {

    /*
    练习：
    1.主线程每隔1s,输出hi,一共10次
    2.当输出到hi 5时，启动一个子线程(要求实现Runnable)，
    每隔1s输出hello,等该线程输出10次hello后，退出
    3.主线程继续输出hi，直到主线程退出
     */
    public static void main(String[] args) {

        Thread thread = new Thread(new thread01());

        for (int i = 1; i <= 10; i++) {
            System.out.println("hi" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 5) {
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class thread01 implements Runnable {
    public int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}

