package top.lconcise.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 用于查询n个工作日（包含法定节假日、双休日、调休）后的日期
 *
 * @author liusj
 */
public class HolidayUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // 节假日数据源
    private static String[] holidayDays =
            {"2020-01-01", "2020-01-24", "2020-01-25", "2020-01-26", "2020-01-27", "2020-01-28", "2020-01-29", "2020-01-30", "2020-01-31", "2020-02-01", "2020-02-02",
                    "2020-04-04", "2020-04-05", "2020-04-06", "2020-05-01", "2020-05-02", "2020-05-03", "2020-05-04", "2020-05-05", "2020-06-25", "2020-06-26",
                    "2020-06-27", "2020-10-01", "2020-10-02", "2020-10-03", "2020-10-04", "2020-10-05", "2020-10-06", "2020-10-07", "2020-10-08"};
    // 节后补班数据源
    private static String[] workWeekDay = {"2020-01-19", "2020-04-26", "2020-05-09", "2020-06-28", "2020-09-27", "2020-10-10"};

    /**
     * 用于判断n个工作日(排除节假日、周六日包含节后补班数据)后的日期
     *
     * @param today 计算开始时间
     * @param num   多少个工作日 根据需要自行安排
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("deprecation")
    public static Date getScheduleActiveDate(Date today, int num) throws ParseException {
        List<String> holidayDayList = Arrays.asList(holidayDays);
        List<String> weekDayList = Arrays.asList(workWeekDay);
        String today1 = HolidayUtils.parseDate(today, "yyyy-MM-dd");
        Date tomorrow = null;
        int delay = 1;
        while (delay <= num) {
            tomorrow = getTomorrow(today);
            //当前日期+1即tomorrow,判断是否是节假日,同时要判断是否是周末,都不是则将scheduleActiveDate日期+1,直到循环num次即可------不是节假日不是周末并且不是补班
            if ((!isWeekend(sdf.format(tomorrow)) && !isHoliday(sdf.format(tomorrow), holidayDayList)) || isWorkWeekDay(sdf.format(tomorrow), weekDayList)) {
                if (isWorkWeekDay(sdf.format(tomorrow), weekDayList)) {
                    System.out.println(sdf.format(tomorrow) + "::是节假日调休补班");
                } else {
                    System.out.println(sdf.format(tomorrow) + "::是正常工作日");
                }
                delay++;
                today = tomorrow;
            } else if (isHoliday(sdf.format(tomorrow), holidayDayList)) {
//                tomorrow = getTomorrow(tomorrow);
                today = tomorrow;
                System.out.println(sdf.format(tomorrow) + "::是节假日");
            } else if (isWeekend(sdf.format(tomorrow))) {//是周六日并且不是节后补班
                if (!isWorkWeekDay(sdf.format(tomorrow), weekDayList)) {
                    today = tomorrow;
                    System.out.println(sdf.format(tomorrow) + "::是休息日");
                }

            }
        }
        System.out.println(today1 + "后" + num + "个工作日后,日期为::" + sdf.format(today));
        return today;
    }

    /**
     * 获取明天的日期
     */
    public static Date getTomorrow(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 判断是否是weekend
     */
    public static boolean isWeekend(String sdate) throws ParseException {
        Date date = sdf.parse(sdate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否是holiday
     */
    public static boolean isHoliday(String sdate, List<String> list) throws ParseException {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (sdate.equals(list.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否是补班
     */
    public static boolean isWorkWeekDay(String sdate, List<String> list) throws ParseException {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (sdate.equals(list.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 把日期格式化成字符串
     *
     * @param date
     * @param format 例: yyyy-MM-dd
     * @return
     */
    public static String parseDate(Date date, String format) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        String dateString;
        dateString = formater.format(date);
        return dateString;
    }
}