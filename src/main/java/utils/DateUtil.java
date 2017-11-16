package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangletian on 2017/1/17.
 */
public class DateUtil {

    /**
     * 格式化时间
     *
     * @param duration
     * @return
     */
    public static String formatTime(long duration) {
        float formatTime = Float.parseFloat(Long.toString(duration));
        return (formatTime >= 60000) ? String.format("%.2f", (formatTime / 60000)) + "m" : String.format("%.2f", formatTime / 1000) + "s";
    }

    /**
     * 格式化时间
     *
     * @return
     */
    public static String formatTime() {
        SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
        return time.format(new Date()).toString();
    }

    /**
     * 返回当前时间，格式为：2014-12-18 15:11:50
     *
     * @return String
     */
    public static String getSimpleDateFormat() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
}
