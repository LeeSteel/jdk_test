package com.thinkive.util;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/6/3 11:10
 * @Copyright: Copyright (c) 2019
 */
public class SqlUtil {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            System.out.println();
            /**
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_MONTH_TYPE_" + i + ".OCCUR_MONTH IS '统计月份' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_MONTH_TYPE_" + i + ".CLIENT_ID IS '客户编号' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_MONTH_TYPE_" + i + ".MONTH_INCOME IS '月收益' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_MONTH_TYPE_" + i + ".MONTH_YIELD IS '月收益率' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_MONTH_TYPE_" + i + ".PURCHASE_COUNT IS '当月买入次数' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_MONTH_TYPE_" + i + ".PURCHASE_AMOUNT IS '当月买入金额' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_MONTH_TYPE_" + i + ".PRODUCT_TYPE IS '产品类型' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_MONTH_TYPE_" + i + ".MONTH_COST_BEGIN IS '月初成本' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_MONTH_TYPE_" + i + ".MONTH_COST_END IS '月末成本' ;");
                */


            /**
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_PERFORMANCE_" + i + ".CLIENT_ID IS '客户编号' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_PERFORMANCE_" + i + ".OCCUR_DATE IS '统计时间yyyyMMdd' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_PERFORMANCE_" + i + ".RET_YTD IS '今年以来收益' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_PERFORMANCE_" + i + ".RET_YTD_JJ IS '今年以来收益(基金)' ;");
            */
            /**
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_TOTALYLD_" + i + ".TOTAL_INCOME_JJ IS '累计收益(基金)' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_TOTALYLD_" + i + ".DAILY_INCOME_JJ IS '今日收益(基金)' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_TOTALYLD_" + i + ".TOTAL_INCOME_SYPZ IS '累计收益(收益凭证)' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_TOTALYLD_" + i + ".DAILY_INCOME_SYPZ IS '今日收益(收益凭证)' ;");
            */
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_TOTALYLD_LC_" + i + ".OCCUR_DATE IS '统计日期yyyyMMdd' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_TOTALYLD_LC_" + i + ".CLIENT_ID IS '客户编号' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_TOTALYLD_LC_" + i + ".DAILY_INCOME IS '当日收益' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_TOTALYLD_LC_" + i + ".TOTAL_INCOME IS '累计收益' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_TOTALYLD_LC_" + i + ".TOTAL_FEE IS '累计费用' ;");
            System.out.println("COMMENT ON COLUMN CF_TRADE.T_CLIENT_TOTALYLD_LC_" + i + ".CREATED_DATE IS '创建时间' ;");


        }
    }
}
