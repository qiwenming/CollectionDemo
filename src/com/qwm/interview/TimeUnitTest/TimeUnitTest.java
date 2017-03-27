package com.qwm.interview.TimeUnitTest;

import sun.util.resources.zh.TimeZoneNames_zh_CN;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Author: qiwenming<br>
 * Create Date: 2017/3/27
 * Description: TimeUnit测试
 */
public class TimeUnitTest {
    public static void main(String[] args){
        System.out.println( TimeUnit.DAYS.toHours(2)  );
        System.out.println( TimeUnit.HOURS.toMinutes(2)  );
        System.out.println( TimeUnit.MINUTES.toSeconds(2)  );
        System.out.println( TimeUnit.DAYS.convert(24,TimeUnit.HOURS) );
    }
}
