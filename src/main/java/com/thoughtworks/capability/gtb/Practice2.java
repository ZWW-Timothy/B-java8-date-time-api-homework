package com.thoughtworks.capability.gtb;

import java.time.LocalDate;

/**
 * 对任意日期获取下一个工作日, 不考虑节假日
 *
 * @author itutry
 * @create 2020-05-15_17:20
 */
public class Practice2 {

  public static LocalDate getNextWorkDate(LocalDate date) {

    LocalDate nextWorkDay = date.plusDays(1);
    int nextWorkDayValue = nextWorkDay.getDayOfWeek().getValue();
    if (nextWorkDayValue > 5) {
      nextWorkDay = nextWorkDayValue > 6 ? nextWorkDay.plusDays(1): nextWorkDay.plusDays(2);
    }
    return nextWorkDay;
  }
}
