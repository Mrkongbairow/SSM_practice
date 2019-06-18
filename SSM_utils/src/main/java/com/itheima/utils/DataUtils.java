package com.itheima.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils  {

    //字符串类型转日期
    public static Date  strToDate( String data, String partt ) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(partt);

        Date parse = simpleDateFormat.parse(data);

        return parse;
    }

    //日期类型转字符串
    public static String dateToString(Date date , String partt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(partt);

        String format = simpleDateFormat.format(date);
        return format;
    }
}
