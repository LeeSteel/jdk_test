package test.java.lang.comparable;

import java.util.Objects;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2021/9/6 11:20
 * @Copyright: Copyright (c) 2019
 */
public class ComparableBean implements Comparable<ComparableBean> {
    private int date;
    private int time;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public int compareTo(ComparableBean o) {
        if ((this.date > o.getDate() && this.time >= o.getTime())
                || (this.date == o.getDate() && this.time > o.getTime())
        ) {
            return -1;
        } else if ((this.date < o.getDate() && this.time <= o.getTime())
                || (this.date == o.getDate() && this.time < o.getTime())
        ) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComparableBean that = (ComparableBean) o;
        return date == that.date && time == that.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, time);
    }
}
