package com.thoughtworks.capability.gtb;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * �Զ�����ϵͳv3.0
 * 1.��ǰ����ʱ��"2020-04-01 14:30:00"��ʾ�׶صı���ʱ�䣬��������»���ʱ����֥�Ӹ�ı���ʱ��
 *   ������
 *   a:�ϸ��������׶ص�ͬ�¶��ģ����ڽ����������ʱ����"2020-04-01 14:30:00"����������Ҫ�������ַ������׶صı���ʱ��
 *   b:�������ڵ�ǰʱ��(����ʱ��)ʹ��ϵͳ
 *   c:�������ú��»���ʱ���Ҫ����֥�Ӹ��ͬ�²鿴�����Ը�ʽ������»���ʱ��Ҫ����֥�Ӹ�ı���ʱ��
 * 2.��Period��ʵ���¸�����ʱ��ļ���
 *
 * @author itutry
 * @create 2020-05-19_18:43
 */
public class MeetingSystemV3 {

  private final static ZoneId ZONE_ID_BEIJING = ZoneId.of("Asia/Shanghai");
  private final static ZoneId ZONE_ID_CHICAGO = ZoneId.of("America/Chicago");
  private final static ZoneId ZONE_ID_LONDON = ZoneId.of("Europe/London");

  public static void main(String[] args) {
    String timeStr = "2020-04-01 14:30:00";

    // ���ݸ�ʽ������ʽ����
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // ���ַ��������õ�����ʱ��
    LocalDateTime meetingTime = LocalDateTime.parse(timeStr, formatter);

    ZonedDateTime meetingTimeLondon = meetingTime.atZone(ZONE_ID_LONDON);
    ZonedDateTime meetingTimeBeijing = meetingTimeLondon.withZoneSameInstant(ZONE_ID_BEIJING);
    ZonedDateTime now = LocalDateTime.now().atZone(ZONE_ID_BEIJING);

    if (now.isAfter(meetingTimeBeijing)) {
      ZonedDateTime nextMeetingTimeLondon = meetingTimeLondon.plus(Period.ofDays(1));
      ZonedDateTime nextMeetingTimeChicago = nextMeetingTimeLondon.withZoneSameInstant(ZONE_ID_CHICAGO);

      // ��ʽ���»���ʱ��
      String showTimeStr = formatter.format(nextMeetingTimeChicago);
      System.out.println(showTimeStr);
    } else {
      System.out.println("���黹û��ʼ��");
    }
  }
}
