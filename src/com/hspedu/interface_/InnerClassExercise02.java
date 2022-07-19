package com.hspedu.interface_;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课");
            }
        });
    }
}

class CellPhone{
    public void alarmClock(Bell bell){
        bell.ring();
    }
}

interface Bell{
    void ring();
}
