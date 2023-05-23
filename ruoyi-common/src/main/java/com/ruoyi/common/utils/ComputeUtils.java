package com.ruoyi.common.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class ComputeUtils {
    /**
     * 同比，环比均可用
     * 获取增长率,保留四位小数
     * 增长率=（本月数-上月数）/上月数×100%
     * 增长率=（本月数-去年本月数）/去年本月数×100%
     *
     * @param lastCount    上月的数据
     * @param currentCount 本月的数据
     * @return float
     */
        public static String getGrowthRate(double lastCount, double currentCount) {
        double growthRate;
        if (lastCount == 0 && currentCount == 0) {
            growthRate = 0;
        } else {
            if (lastCount == 0) {
                growthRate = 1;
            } else {
                growthRate = (float) (currentCount - lastCount) / lastCount;
            }
        }
        //保留1为小数
            String strNum = String.format("%.1f", growthRate );
            return stringChangePercentage(strNum);
    }
    /**
     * 将字符串格式数字转化为百分比
     *
     * @param strNum
     * @return
     */
    public static String stringChangePercentage(String strNum) {
        BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(strNum));
        //将结果转化为百分比
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(1);

        String format = percent.format(bigDecimal.doubleValue());
        format = format.replace(",", "");
        String trimTrim = format.trim();
        return trimTrim;
    }

}
