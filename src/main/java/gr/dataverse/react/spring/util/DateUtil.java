package gr.dataverse.react.spring.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    //Get Current Date formatted (use for application submission date)

    public static String getCurrentDateFormatted(){

        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());

        return date;
    }

    public static LocalDate convertEpochMilliToDate(Long epochMilli){
        return Instant.ofEpochMilli(epochMilli).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static String convertFormatDate(String formattedDate) throws ParseException {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(formattedDate);
        String savedPattern = "yyyy/MM/dd";
        simpleDateFormat = new SimpleDateFormat(savedPattern);
        String newDate = simpleDateFormat.format(date);
        return newDate;
    }

    // from yyyy/MM/dd to dd/MM/yyyy
    public static String convertFormatDateMethod(String formattedDate) throws ParseException {
        String pattern = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(formattedDate);
        String savedPattern = "dd/MM/yyyy";
        simpleDateFormat = new SimpleDateFormat(savedPattern);
        String newDate = simpleDateFormat.format(date);
        return newDate;
    }
}
