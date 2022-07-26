package com.hspedu.homework.homework02;

/**
 * 输入用户名，密码，邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
 * (1)用户名长度为2或3或4
 * (2)密码的长度为6，要求全是数字,isDigital
 * (3)邮箱中包含@和. 并且@在.的前面
 */

public class Homework02 {
    public static void main(String[] args) {
            String name = "jack";
            String pwd = "123456";
            String email = "123@q.com";

        try {
            userRegister(name,pwd,email);
            System.out.println("恭喜你，注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    // 注册流程校验
    public static void userRegister(String name, String pwd, String email) {

        // 判断输入的参数是否为空
        if (!(name != null && pwd != null && email != null)) {
            throw new RuntimeException("输入的参数不能为null");
        }

        // 判断用户名
        // (1)用户名长度为2或3或4
        int userLength = name.length();
        if (!(userLength >= 2 && userLength <= 4)) {
            throw new RuntimeException("用户名长度为2或3或4");
        }

        // 校验密码
        if (!(pwd.length() == 6 && isDigital(pwd))) {
            throw new RuntimeException("密码的长度为6，要求全是数字");
        }

        // 校验邮箱
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && j > i)) {
            throw new RuntimeException("邮箱中包含@和. 并且@在.的前面");
        }

    }

    // 校验密码方法
    // 密码的长度为6，要求全是数字,isDigital
    public static boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!(chars[i] > '0' || chars[i] < '9')) {
                return false;
            }
        }
        return true;
    }
}


