package cn.eatammy.common.utils;

import cn.eatammy.common.exception.BizException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 郭旭辉 on 2016/8/12.
 * 通用工具类
 */
public class CommonUtils {

    public static Calendar calendar = Calendar.getInstance();
    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    public static Integer CURRENTYEAR = calendar.get(Calendar.YEAR);
    public static Integer CURRENTMONTH = calendar.get(Calendar.MONTH);
    public static Integer WEEK_OF_YEAR = calendar.get(Calendar.WEEK_OF_YEAR);

    /**
     * 获取无“-”的UUID
     *
     * @return 返回，32位的UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * list类型转化
     *
     * @param list
     * @return
     */
    public static List<Object> transList(List<String> list) {
        List<Object> result = new ArrayList<>();
        for (String s : list) {
            result.add(s);
        }
        return result;
    }

    /**
     * 生成随机时间
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @return 返回，随机日期
     */
    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            //构造开始日期
            Date start = format.parse(beginDate);
            //构造结束日期
            Date end = format.parse(endDate);
            if (start.getTime() >= end.getTime()) {
                throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
            }
            long date = random(start.getTime(), end.getTime());
            return new Date(date);
        } catch (ParseException e) {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        //如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }


    /**
     * 根据当前时间获取一周中的第一天和最后一天的日期
     *
     * @return 返回，日期集合
     */
    public static Map getWeekDay() {
        Map<String, String> map = new HashMap<String, String>();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); //获取本周一的日期
        map.put("mon", format.format(calendar.getTime()));
        //这种输出的是上个星期周日的日期，因为老外那边把周日当成第一天
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        //增加一个星期，才是我们中国人理解的本周日的日期
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        map.put("sun", format.format(calendar.getTime()));
        return map;
    }

    /**
     * 根据当前时间获取本月的第一天和最后一天
     *
     * @return 返回，日期集合
     */
    public static Map getMonthDate() {
        Map<String, String> map = new HashMap<String, String>();
        // 获取Calendar
        // 设置时间,当前时间不用设置
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        map.put("monthF", format.format(calendar.getTime()));
        // 设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        map.put("monthL", format.format(calendar.getTime()));
        return map;
    }

    /**
     * 获取月份步长
     *
     * @param year  年份
     * @param month 月份，0~11：1月~12月
     * @return 返回，步长值
     */
    public static int getMonthSpan(int year, int month) {
        int curmonth = calendar.get(Calendar.MONTH) + 1;
        if (year > CURRENTYEAR) {
            throw new BizException(ERRORCODE.NO_DATA.getCode(), ERRORCODE.NO_DATA.getMessage());
        }
        if (CURRENTYEAR == year) {
            return curmonth - month;
        }
        if (CURRENTYEAR > year) {
            return curmonth + 12 - month;
        }
        return 0;
    }

    /**
     * 获取当前为本月的那一天
     *
     * @param year  年份
     * @param month 月数
     * @return 返回，天数
     */
    public static int getDayOfMonth(int year, int month) {
        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(Calendar.MONTH) + 1;
        int curDay = calendar.get(Calendar.DAY_OF_MONTH);
        if (curYear != year || curMonth != month) {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(year, month - 1, 1);
            curDay = calendar.getActualMaximum(Calendar.DATE);
        }
        return curDay;
    }

    /**
     * 获取年份数组
     *
     * @return 返回年份数组
     */
    public static List<Integer> generateYears() {
        List<Integer> result = new ArrayList<>();
        for (int i = 2016; i <= calendar.get(Calendar.YEAR); i++) {
            result.add(i);
        }
        return result;
    }


    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "北京");
        map.put(2, "天津");
        map.put(3, "河北");
        map.put(4, "山西");
        map.put(5, "内蒙古");
        map.put(6, "辽宁");
        map.put(7, "吉林");
        map.put(8, "黑龙江");
        map.put(9, "上海");
        map.put(10, "江苏");
        map.put(11, "浙江");
        map.put(12, "安徽");
        map.put(13, "福建");
        map.put(14, "江西");
        map.put(15, "山东");
        map.put(16, "河南");
        map.put(17, "湖北");
        map.put(18, "湖南");
        map.put(19, "广东");
        map.put(20, "海南");
        map.put(21, "广西");
        map.put(22, "甘肃");
        map.put(23, "陕西");
        map.put(24, "新疆");
        map.put(25, "青海");
        map.put(26, "宁夏");
        map.put(27, "重庆");
        map.put(28, "四川");
        map.put(29, "贵州");
        map.put(30, "云南");
        map.put(31, "西藏");
        map.put(32, "台湾");
        map.put(33, "澳门");
        map.put(34, "香港");
        return map;
    }

    public static void main(String[] args) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2017, 0, 1);
        System.out.println(calendar1.get(Calendar.WEEK_OF_YEAR));
    }


}
