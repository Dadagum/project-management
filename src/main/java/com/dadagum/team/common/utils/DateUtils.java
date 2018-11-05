package com.dadagum.team.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private DateUtils(){}

    public static String getDetialedCurrentTime() {
        return formater.format(new Date());
    }
}
