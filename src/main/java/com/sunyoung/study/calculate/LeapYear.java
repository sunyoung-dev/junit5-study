package com.sunyoung.study.calculate;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year < 0) {
            return false;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }
}
