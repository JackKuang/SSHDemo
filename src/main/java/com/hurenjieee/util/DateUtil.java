package com.hurenjieee.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * �������� YYYY-MM-DD
	 * 
	 * @return
	 */
	public static String getToday() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		return sFormat.format(date);
	}

	/**
	 * ���ַ������͵�����ת���� YYYY-MM-dd
	 * 
	 * @return
	 */

	public static String stringTocalendar(String s1) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			Date odate = sFormat.parse(s1);
			sFormat = new SimpleDateFormat("yyyy-MM-dd");
			s1 = sFormat.format(odate);
		} catch (Exception e) {
			return "";
		}
		return s1;
	}

	/**
	 * ���ַ������͵�ʱ��ת���� hh:mm:ss
	 * 
	 * @return
	 */

	public static String stringTotime(String s1) {
		SimpleDateFormat sFormat = new SimpleDateFormat("HHmmss");
		try {
			Date odate = sFormat.parse(s1);
			sFormat = new SimpleDateFormat("HH:mm:ss");
			s1 = sFormat.format(odate);
		} catch (Exception e) {
			return "";
		}
		return s1;
	}

	/**
	 * �Զ����ʽ������� yyyyMMdd
	 */
	public static String getToday(String sFormatStr) {
		SimpleDateFormat sFormat = new SimpleDateFormat(sFormatStr);
		java.util.Date date = new java.util.Date();
		return sFormat.format(date);
	}

	public static String getToday4LocaleDate() {
		Date date = new Date();
		String dd = date.toLocaleString();
		dd = dd.substring(dd.indexOf(":") - 2);
		if (dd.charAt(0) == ' ') {
			dd = "0" + dd.substring(1);
		}
		return dd;
	}

	public static String getToday4LocaleTime() {
		java.util.Date date = new java.util.Date();
		String dd = date.toLocaleString();
		dd.split(":");
		return null;
	}

	/**
	 * getDate
	 * 
	 * @param pdate
	 * @param pattern
	 * @return
	 */
	public static final String getDate(Date pdate, String pattern) {
		if (pattern == null)
			pattern = "yyyyMMdd";
		return (new SimpleDateFormat(pattern)).format(pdate);

	}

	/**
	 * ����������ʽ�����ڸ�ʽ
	 * 
	 * @param date
	 * @return
	 */
	public static String getDate(java.util.Date date) {
		return getDate(date, "yyyy-MM-dd");
	}

	/**
	 * ����������ʽ�����ڸ�ʽ,��ȷ��ʱ����
	 */
	public static String getDateHms(java.util.Date date) {
		return getDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * ���������ʽ,����ʱ���ַ���
	 * 
	 * @return
	 */
	public static String getNowDateFormat(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		return sdf.format(date);

	}

	/**
	 * YYYY-MM
	 * 
	 * @return
	 */
	public static String getYearMonth() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM");
		java.util.Date date = new java.util.Date();
		return sFormat.format(date);
	}

	/**
	 * YYYY-MM ��һ��
	 * 
	 * @param sDate
	 * @return
	 */
	public static String getPrevYearMonth(String sDate) {
		String sBack = "";
		if (sDate == null)
			return "";
		sDate = sDate.trim();
		String[] ss = sDate.split("-");
		if (ss.length != 2)
			return "";
		try {
			int iYear = new Integer(ss[0]).intValue();
			int iMonth = new Integer(ss[1]).intValue();
			if (iYear < 1900 || iYear > 2100)
				iYear = new Integer(getYear()).intValue();
			if (iMonth < 1 || iMonth > 12)
				iMonth = 1;
			if (iMonth == 1) { // ����
				iYear--;
				iMonth = 12;
			} else
				iMonth--;
			sBack = iYear + "-" + (iMonth < 10 ? "0" : "") + iMonth;
		} catch (Exception e) {
			return "";
		}
		return sBack;
	}

	/**
	 * YYYY-MM ��һ�·�
	 * 
	 * @param sDate
	 * @return
	 */
	public static String getNextYearMonth(String sDate) {
		String sBack = "";
		if (sDate == null)
			return "";
		sDate = sDate.trim();
		String[] ss = sDate.split("-");
		if (ss.length != 2)
			return "";
		try {
			int iYear = new Integer(ss[0]).intValue();
			int iMonth = new Integer(ss[1]).intValue();
			if (iYear < 1900 || iYear > 2100)
				iYear = new Integer(getYear()).intValue();
			if (iMonth < 1 || iMonth > 12)
				iMonth = 1;
			if (iMonth == 12) { // ����
				iYear++;
				iMonth = 1;
			} else
				iMonth++;
			sBack = iYear + "-" + (iMonth < 10 ? "0" : "") + iMonth;
		} catch (Exception e) {
			return "";
		}
		return sBack;
	}

	/**
	 * ��
	 * 
	 * @return
	 */
	public static String getDay() {
		SimpleDateFormat sFormat = new SimpleDateFormat("dd");
		java.util.Date date = new java.util.Date();
		return sFormat.format(date);
	}

	/**
	 * �������ں�ʱ��YYYY-MM-DD HH:MM:SS
	 * 
	 * @return
	 */
	public static String getTodayTime() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		return sFormat.format(date);
	}

	/**
	 * ����������תΪ��������
	 */
	public static String chgWeekToGB(int iWeek) {
		switch (iWeek) {
		case 1:
			return "������";
		case 2:
			return "����һ";
		case 3:
			return "���ڶ�";
		case 4:
			return "������";
		case 5:
			return "������";
		case 6:
			return "������";
		case 7:
			return "������";
		default:
			return null;
		}
	}

	/**
	 * ����������תΪӢ������
	 * 
	 * @param iWeek
	 * @return
	 */
	public static String chgWeekToEN(int iWeek) {
		int i = 0;
		switch (iWeek) {
		case 1:
			return (i == 0) ? "SUNDAY" : "SUN";
		case 2:
			return (i == 0) ? "MONDAY" : "MON";
		case 3:
			return (i == 0) ? "TUESDAY" : "TUE";
		case 4:
			return (i == 0) ? "WEDNESDAY" : "WED";
		case 5:
			return (i == 0) ? "THURSDAY" : "THU";
		case 6:
			return (i == 0) ? "FRIDAY" : "FRI";
		case 7:
			return (i == 0) ? "SATURDAY" : "SAT";
		default:
			return null;
		}
	}

	/**
	 * ����������תΪ����
	 * 
	 * @param iWeek
	 * @return
	 */
	public static int chgWeekToInt(String sWeek) {
		if (sWeek.equals("������"))
			return 1;
		else if (sWeek.equals("����һ"))
			return 2;
		else if (sWeek.equals("���ڶ�"))
			return 3;
		else if (sWeek.equals("������"))
			return 4;
		else if (sWeek.equals("������"))
			return 5;
		else if (sWeek.equals("������"))
			return 6;
		else if (sWeek.equals("������"))
			return 7;
		else
			return 0;
	}

	/**
	 * ���ص�ǰ���������ڼ�
	 * 
	 * @return
	 */
	public static int getDayOfWeek() {
		return getDayOfWeek(getToday());
	}

	/**
	 * ����ָ�����������ڼ�
	 * 
	 * @param sDate
	 * @return
	 */
	public static int getDayOfWeek(String sDate) {
		Calendar cal = getCalendar(sDate);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * ȡ��ָ�������·ݵĿ�ʼ����
	 * 
	 * @param sMonth
	 */
	public static String getMonthBegin(String sMonth) {
		return getPrevYearMonth(sMonth) + "-26";
	}

	public static String getMonthBegin() {
		return getMonthBegin(getYearMonth());
	}

	/**
	 * ȡ��ָ�������·ݵĽ�������
	 * 
	 * @param sMonth
	 */
	public static String getMonthEnd(String sMonth) {
		return sMonth + "-25";
	}

	public static String getMonthEnd() {
		return getMonthEnd(getYearMonth());
	}

	/**
	 * ��"YYYY-MM-DD"�����ַ����õ�������
	 * 
	 * @param sDate
	 * @return
	 */
	public static Date parseDate(String sDate) {
		if (sDate == null || sDate.trim().length() == 0)
			return null;
		try {
			Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
			return d1;
		} catch (Exception ex) {
			return null;
		}
	}

	public static Date getDate(String sDate, String sFormat) {
		try {
			Date d1 = new SimpleDateFormat(sFormat).parse(sDate);
			return d1;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * ����YYYY-MM-DD�������ַ���תΪ Calendar ��
	 */
	public static Calendar getCalendar(String sDate) {
		Date date = parseDate(sDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// cal.setTimeInMillis(date.getTime());
		return cal;
	}

	public static Calendar getCalendar(String sDate, String sFormat) {
		Date date = getDate(sDate, sFormat);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// cal.setTimeInMillis(date.getTime());
		return cal;
	}

	/**
	 * 
	 * @param sDate
	 *            sFormat yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Calendar getCalendar2(String sDate, String sFormat) {
		Date date = getDate(sDate, sFormat);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// cal.setTimeInMillis(date.getTime());
		return cal;
	}

	/**
	 * ָ������ +��- ���� sFormat: "yyyy-MM-dd HH:mm:ss"
	 */
	public static String calendarAddM(String sDate, int iTs, String sFormat) {
		Calendar cal = getCalendar2(sDate, sFormat);
		cal.add(Calendar.MINUTE, iTs);
		return calendarToTime(cal);
	}

	/**
	 * ָ������ +��- Сʱ sFormat: "yyyy-MM-dd HH:mm:ss"
	 */
	public static String calendarAddH(String sDate, int iTs, String sFormat) {
		Calendar cal = getCalendar2(sDate, sFormat);
		cal.add(Calendar.HOUR, iTs);
		return calendarToTime(cal);
	}

	/**
	 * ָ������ +��- �� sFormat: "yyyy-MM-dd HH:mm:ss"
	 */
	public static String calendarAddD(String sDate, int iTs, String sFormat) {
		Calendar cal = getCalendar2(sDate, sFormat);
		cal.add(Calendar.DATE, iTs);
		return calendarToTime(cal);
	}

	public static void main(String[] args) {
		// doPro();
		// String datetime = "2009-04-07 12:20:34";
		// String tmp = calendarAddD(datetime, -7, "yyyy-MM-dd");
		// DateUtil.getDate(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd
		// HH:mm:ss")
		// getDate(String sDate, String sFormat)
		// System.out.println(getToday("yyyy-MM-dd HH:mm:ss"));
		// System.out.println(getDate(getToday("yyyy-MM-dd
		// HH:mm:ss"),"yyyy-MM-dd HH:mm:ss"));
		// System.out.println(DateUtil.getMonthBegin());
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = DateUtil.getDate(ca.getTime());
		System.out.println("===============first:" + last);
	}

	// ��ȡ���µ�һ��
	public static String getFirstDay() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// ����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ��
		String first = DateUtil.getDate(c.getTime());
		return first;
	}

	// ��ȡ�������һ��
	public static String getLastDay() {
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = DateUtil.getDate(ca.getTime());
		return last;
	}

	/**
	 * ָ������+��-iTs��
	 */
	public static String calendarAdd(String sDate, int iTs) {
		Calendar cal = getCalendar(sDate, "yyyy-MM-dd");
		cal.add(Calendar.DATE, iTs);
		return calendarToDate(cal);
	}

	/**
	 * ָ������+��-iTs�� ��Time
	 */
	public static String calendarTimeAdd(String sDateTime, int iTs) {
		Calendar cal = getCalendar(sDateTime, "yyyy-MM-dd HH:mm:ss");
		cal.add(Calendar.DATE, iTs);
		return calendarToTime(cal);
	}

	/**
	 * ����ת��Ϊ yyyy-MM-dd HH:mm:ss���ַ���
	 */
	public static String calendarToDate(Calendar cal) {
		SimpleDateFormat sDateFormat = null;
		// java.util.Date date = new java.util.Date( cal.getTimeInMillis() );
		java.util.Date date = new java.util.Date(cal.getTime().getTime());
		sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return sDateFormat.format(date);
	}

	/**
	 * ����ת��Ϊ yyyy-MM-dd HH:mm:ss���ַ���
	 */
	public static String calendarToTime(Calendar cal) {
		SimpleDateFormat sDateFormat = null;
		// java.util.Date date = new java.util.Date( cal.getTimeInMillis() );
		java.util.Date date = new java.util.Date(cal.getTime().getTime());
		sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sDateFormat.format(date);
	}

	/**
	 * �õ� sBdate �� sEdate ֮�������(��ʵ��������)
	 */
	public static int getDays(String sBdate, String sEdate) {
		Date dateB = parseDate(sBdate);
		Date dateE = parseDate(sEdate);
		return (int) ((dateE.getTime() - dateB.getTime()) / (3600 * 24 * 1000));
	}

	/**
	 * ��ǰ���� +,- ���� ii ����(��Ϊ��)
	 */
	public static String getTodayAdd(int ii) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, ii);
		return calendarToDate(cal);
	}

	/**
	 * ȡ��ָ������·ݵ�����
	 */
	public static int getDaysMonth(int iYear, int iMonth) {
		int iFebDays = (iYear % 4 == 0 && (iYear % 100 != 0 || iYear % 400 == 0)) ? 29 : 28; // �������Ϊ29��
		int[] iDaysMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		iDaysMonth[1] = iFebDays;
		if (iMonth < 1 || iMonth > 12)
			return iDaysMonth[0];
		else
			return iDaysMonth[iMonth - 1];
	}

	public static int getDaysMonth(Calendar cal) {
		int iYear = cal.get(Calendar.YEAR); // ��
		int iMonth = cal.get(Calendar.MONTH) + 1; // ��
		return getDaysMonth(iYear, iMonth);
	}

	public static int getDaysMonth(String sDate) {
		return getDaysMonth(getCalendar(sDate));
	}

	/**
	 * ��ȡ��ǰ���ڵ����
	 */
	public static String getYear() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy");
		java.util.Date date = new java.util.Date();
		return sFormat.format(date);
	}

	/**
	 * ��ȡ��ǰ���ڵ��·�
	 */
	public static String getMonth() {
		SimpleDateFormat sFormat = new SimpleDateFormat("MM");
		java.util.Date date = new java.util.Date();
		return sFormat.format(date);
	}

	/**
	 * pdate�������ַ��� fpat:
	 */
	public static final String formatDate(String pdate, String fpat, String tpat) {

		if (pdate == null)
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat(fpat);
		Date tmp;
		try {
			tmp = formatter.parse(pdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		formatter.applyPattern(tpat);
		return formatter.format(tmp);
	}

	/** ����2�����ڵ�������������� - ǰ������ **/
	public static int daysBetween(Date smdate, Date bdate) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}
}
