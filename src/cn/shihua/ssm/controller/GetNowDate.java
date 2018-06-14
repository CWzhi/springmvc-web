package cn.shihua.ssm.controller;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class GetNowDate {  
    Calendar calendar = null;  
  
    public GetNowDate() {  
        calendar = Calendar.getInstance();  
        calendar.setTime(new Date());  
    }  
 
    public int getYear() {  
        return calendar.get(Calendar.YEAR);  
    }  
  
    public int getMonth() {  
        return 1 + calendar.get(Calendar.MONTH);  
    }  
  
    public int getDay() {  
        return calendar.get(Calendar.DAY_OF_MONTH);  
    }  
  
    public int getHour() {  
        return calendar.get(Calendar.HOUR_OF_DAY);  
    }  
  
    public int getMinute() {  
        return calendar.get(Calendar.MINUTE);  
    }  
  
    public int getSecond() {  
        return calendar.get(Calendar.SECOND);  
    }  
  
    public String getDate() {  
        return getMonth() + "/" + getDay() + "/" + getYear();  
    }  
  
    public String getTime() {  
        return getHour() + ":" + getMinute() + ":" + getSecond();  
    }  
    @Test
    public String getYMD() {  
        String yyyy = "0000", mm = "00", dd = "00";  
        yyyy = yyyy + getYear();  
        mm = mm + getMonth();  
        dd = dd + getDay();  
        yyyy = yyyy.substring(yyyy.length() - 4);  
        mm = mm.substring(mm.length() - 2);  
        dd = dd.substring(dd.length() - 2);  
        return yyyy + "-" + mm + "-" + dd;  
    }  
    @Test
    public String getHMS() {  
        String hh = "00", mm = "00", ss = "00";  
        hh = hh + getHour();  
        mm = mm + getMinute();  
        ss = ss + getSecond();  
        hh = hh.substring(hh.length() - 2, hh.length());  
        mm = mm.substring(mm.length() - 2, mm.length());  
        ss = ss.substring(ss.length() - 2, ss.length());  
        return hh + ":" + mm + ":" + ss;  
    }  
}  
