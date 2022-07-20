package com.hspedu.homework;

/**
 * 有一个Car类，有属性temperature(温度),车内有Air(空调)类
 * 有吹风的功能flow,Air会监视车内的温度，如果温度超过40度则吹冷风，如果温度低于0度则吹暖气，如果在
 * 这之间则关掉空调，
 * 实例化具有不同温度的Car对象，调用空调flow方法，测试空调吹的风是否正确
 */
public class homework07 {
    public static void main(String[] args) {
        Car car = new Car(41);
        car.getAir().flow();
        Car car2 = new Car(-1);
        car2.getAir().flow();
        Car car3 = new Car(20);
        car3.getAir().flow();
    }
}

class Car{
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air{
        public void flow(){
            if(temperature>40){
                System.out.println("温度超过40度，空调输出冷气");
            }else if (temperature<0){
                System.out.println("温度低于0度，空调输出暖气");
            }else {
                System.out.println("空调关闭");
            }
        }
    }
    // 返回一个Air对象
    public Air getAir(){
        return new Air();
    }
}
