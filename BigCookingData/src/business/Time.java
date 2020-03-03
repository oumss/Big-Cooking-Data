package business;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	private int millisecond;
	private String[] monthsLong = new String[] { "January", "February", "March", "April", "May", "June", "Jully",
			"August", "September", "October", "November", "December" };
	private String[] monthsShort = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct",
			"Nov", "Dec" };
	private String[] days = new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
			"Sunday" };
	public static final int YEAR = 0;
	public static final int MONTH = 1;
	public static final int DAY = 2;
	public static final int HOUR = 3;
	public static final int MINUTE = 4;
	public static final int SECOND = 5;
	public static final int MILLISECOND = 6;
	public static final String CONSOLE = "[hh:min:ss]";
	public static final String ABSOLUTE = "ddmmyy_hh_min_ss_mil";
	public static final String TIME = "dd/mm/yy hh:min:ss.mil";
	public static final String PATH = "_mm_yy";
	public static final String SQL = "yy-mm-dd";
	public static final String DATE = "yy/mm/dd";

	/**
	 * Convert a string wich is in the format yyyy-mm-dd
	 * 
	 * @param date
	 *            - Date in the foramt yyyy-mm-dd
	 */
	public Time(String date) {
		this.setDate(date);
	}

	/**
	 * Copy a Time
	 * 
	 * @param date
	 *            - Time to copy
	 */
	public Time(Time date) {
		this.setDate(date);
	}

	/**
	 * Convert a Date
	 * 
	 * @param date
	 *            - Date to convert
	 */
	public Time(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (calendar.get(9) == 0) {
			this.setDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.get(10), calendar.get(12),
					calendar.get(13), calendar.get(14));
		} else {
			this.setDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.get(10) + 12, calendar.get(12),
					calendar.get(13), calendar.get(14));
		}
	}

	/**
	 * Initialize Time
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public Time(int year, int month, int day) {
		this.setDate(year, month, day, 0, 0, 0, 0);
	}

	/**
	 * Initialize Time
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @param millisecond
	 */
	public Time(int year, int month, int day, int hour, int minute, int second, int millisecond) {
		this.setDate(year, month, day, hour, minute, second, millisecond);
	}

	/**
	 * Initialize Time with the current date
	 */
	public Time() {
		Calendar calendar = Calendar.getInstance();
		if (calendar.get(9) == 0) {
			this.setDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.get(10), calendar.get(12),
					calendar.get(13), calendar.get(14));
		} else {
			this.setDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.get(10) + 12, calendar.get(12),
					calendar.get(13), calendar.get(14));
		}
	}

	/**
	 * Return a string in the format "mm/yyyy"
	 * 
	 * @return A string in the format "mm/yyyy"
	 */
	public String toString() {
		String month = this.month < 10 ? "0" + this.month : "" + this.month;
		String year = "" + this.year;
		return String.valueOf(month) + "/" + year;
	}

	/**
	 * 
	 * @return name of the day
	 */
	private String getDayName() {
		int dayNumber = this.month >= 3
				? (23 * this.month / 9 + 4 + this.day + this.year + this.year / 4 - this.year / 100 + this.year / 400
						- 2) % 7 - 1
				: (23 * this.month / 9 + 4 + this.day + this.year + (this.year - 1) / 4 - (this.year - 1) / 100
						+ (this.year - 1) / 400) % 7 - 1;
		dayNumber = dayNumber == -1 ? 6 : dayNumber;
		return this.days[dayNumber];
	}

	/**
	 * Return this Time at the given format with: - DD representing the name of
	 * the day (Example: Monday) - MMMM representing the full name of the month
	 * (Example: January) - MM representing the short name of the month
	 * (Example: Jan) - dd representing the day - mm representing the month - yy
	 * representing the year - hh representing the hour - min representing the
	 * minute - ss representing the second - mil representing the millisecond
	 * 
	 * @param format - Wanted format for this Time
	 * @return This Time at the given format
	 */
	public String format(String format) {
		String dayName = this.getDayName();
		String monthShort = this.monthsShort[this.month - 1];
		String monthLong = this.monthsLong[this.month - 1];
		String ret = format;
		String day = this.day < 10 ? "0" + this.day : "" + this.day;
		String month = this.month < 10 ? "0" + this.month : "" + this.month;
		String hour = this.hour < 10 ? "0" + this.hour : "" + this.hour;
		String minute = this.minute < 10 ? "0" + this.minute : "" + this.minute;
		String second = this.second < 10 ? "0" + this.second : "" + this.second;
		String millisecond = this.millisecond < 10 ? "00" + this.millisecond
				: (this.millisecond < 100 ? "0" + this.millisecond : "" + this.millisecond);
		String year = "" + this.year;
		ret = ret.replaceAll("DD", dayName);
		ret = ret.replaceAll("MMMM", monthLong);
		ret = ret.replaceAll("MM", monthShort);
		ret = ret.replaceAll("dd", day);
		ret = ret.replaceAll("mm", month);
		ret = ret.replaceAll("yy", year);
		ret = ret.replaceAll("hh", hour);
		ret = ret.replaceAll("min", minute);
		ret = ret.replaceAll("ss", second);
		ret = ret.replaceAll("mil", millisecond);
		return ret;
	}

	/**
	 * Compare an {@link Object} to this {@link Time}
	 * @return true if the given Object is a {@link Time} with the same value
	 */
	public boolean equals(Object obj) {
		if (!obj.getClass().equals(Time.class)) {
			return false;
		}
		Time compare = (Time) obj;
		if (compare.get(0) == this.year && compare.get(1) == this.month && compare.get(2) == this.day
				&& compare.get(3) == this.hour && compare.get(4) == this.minute && compare.get(5) == this.second
				&& compare.get(6) == this.millisecond) {
			return true;
		}
		return false;
	}

	/**
	 * Compare an Object to this {@link Time}
	 * @param obj- Object to compare
	 * @return true if the given Object is a Time before this Time
	 */
	public boolean isBefore(Object obj) {
		if (!obj.getClass().equals(Time.class)) {
			return false;
		}
		Time time = (Time) obj;
		if (time.get(0) > this.year) {
			return true;
		}
		if (time.get(0) < this.year) {
			return false;
		}
		if (time.get(1) > this.month) {
			return true;
		}
		if (time.get(1) < this.month) {
			return false;
		}
		if (time.get(2) > this.day) {
			return true;
		}
		if (time.get(2) < this.day) {
			return false;
		}
		if (time.get(3) > this.hour) {
			return true;
		}
		if (time.get(3) < this.hour) {
			return false;
		}
		if (time.get(4) > this.minute) {
			return true;
		}
		if (time.get(4) < this.minute) {
			return false;
		}
		if (time.get(5) > this.second) {
			return true;
		}
		if (time.get(5) < this.second) {
			return false;
		}
		if (time.get(6) > this.millisecond) {
			return true;
		}
		if (time.get(6) < this.millisecond) {
			return false;
		}
		return false;
	}

	/**
	 * Compare an Object to this {@link Time}
	 * @param obj
	 * @return true if the given Object is a Time after this {@link Time}
	 */
	public boolean isAfter(Object obj) {
		if (!obj.getClass().equals(Time.class)) {
			return false;
		}
		Time time = (Time) obj;
		if (time.get(0) < this.year) {
			return true;
		}
		if (time.get(0) > this.year) {
			return false;
		}
		if (time.get(1) < this.month) {
			return true;
		}
		if (time.get(1) > this.month) {
			return false;
		}
		if (time.get(2) < this.day) {
			return true;
		}
		if (time.get(2) > this.day) {
			return false;
		}
		if (time.get(3) < this.hour) {
			return true;
		}
		if (time.get(3) > this.hour) {
			return false;
		}
		if (time.get(4) < this.minute) {
			return true;
		}
		if (time.get(4) > this.minute) {
			return false;
		}
		if (time.get(5) < this.second) {
			return true;
		}
		if (time.get(5) > this.second) {
			return false;
		}
		if (time.get(6) < this.millisecond) {
			return true;
		}
		if (time.get(6) > this.millisecond) {
			return false;
		}
		return false;
	}

	/**
	 * Return one of the value of this {@link Time}
	 * @param part
	 * @return One of the value of this {@link Time}
	 */
	public int get(int part) {
		if (part == 0) {
			return this.year;
		}
		if (part == 1) {
			return this.month;
		}
		if (part == 2) {
			return this.day;
		}
		if (part == 3) {
			return this.hour;
		}
		if (part == 4) {
			return this.minute;
		}
		if (part == 5) {
			return this.second;
		}
		if (part == 6) {
			return this.millisecond;
		}
		return -1;
	}

	/**
	 * Return a Date corresponding to this {@link Time}
	 * @return A Date corresponding to this {@link Time}
	 */
	public Date getDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return format.parse(this.format("dd/mm/yy"));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Return a new {@link Time} corresponding to this {@link Time}
	 * @return A new {@link Time} corresponding to this {@link Time}
	 */
	public Time getTime() {
		return new Time(this.year, this.month, this.day, this.hour, this.minute, this.second, this.millisecond);
	}

	/**
	 * Increase one of the value of this {@link Time}
	 * @param part - Searched value of this {@link Time}
	 */
	public void add(int part) {
		if (part == 0) {
			++this.year;
		} else if (part == 1) {
			this.addMonth();
		} else if (part == 2) {
			this.addDay();
		} else if (part == 3) {
			this.addHour();
		} else if (part == 4) {
			this.addMinute();
		} else if (part == 5) {
			this.addSecond();
		} else if (part == 6) {
			this.addMillisecond();
		}
	}

	private void addMonth() {
		++this.month;
		if (this.month >= 13) {
			this.month = 1;
			++this.year;
		}
	}

	private void addDay() {
		++this.day;
		if (this.day >= 30 && this.month == 2 && this.year % 4 == 0 || this.day >= 29 && this.month == 2
				|| this.day >= 31 && (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)
				|| this.day >= 32 && (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7
						|| this.month == 8 || this.month == 10 || this.month == 12)) {
			this.day = 1;
			this.addMonth();
		}
	}

	private void addHour() {
		++this.hour;
		if (this.hour >= 24) {
			this.hour = 0;
			this.addDay();
		}
	}

	private void addMinute() {
		++this.minute;
		if (this.minute >= 60) {
			this.minute = 0;
			this.addHour();
		}
	}

	private void addSecond() {
		++this.second;
		if (this.second >= 60) {
			this.second = 0;
			this.addMinute();
		}
	}

	private void addMillisecond() {
		++this.millisecond;
		if (this.millisecond >= 1000) {
			this.millisecond = 0;
			this.addSecond();
		}
	}

	/**
	 * Decrease one of the value of this {@link Time}
	 * @param     part - Searched value of this {@link Time}
	 */
	public void decrease(int part) {
		if (part == 0) {
			--this.year;
		} else if (part == 1) {
			this.decreaseMonth();
		} else if (part == 2) {
			this.decreaseDay();
		} else if (part == 3) {
			this.decreaseHour();
		} else if (part == 4) {
			this.decreaseMinute();
		} else if (part == 5) {
			this.decreaseSecond();
		} else if (part == 6) {
			this.decreaseMillisecond();
		}
	}

	private void decreaseMonth() {
		--this.month;
		if (this.month <= 0) {
			this.month = 12;
			--this.year;
		}
	}

	private void decreaseDay() {
		--this.day;
		if (this.day <= 0) {
			this.decreaseMonth();
			this.day = this.month == 2 && this.year % 4 == 0 ? 29
					: (this.month == 2 ? 28
							: (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11 ? 30 : 31));
		}
	}

	private void decreaseHour() {
		--this.hour;
		if (this.hour <= -1) {
			this.hour = 23;
			this.decreaseDay();
		}
	}

	private void decreaseMinute() {
		--this.minute;
		if (this.minute <= -1) {
			this.minute = 59;
			this.decreaseHour();
		}
	}

	private void decreaseSecond() {
		--this.second;
		if (this.second <= -1) {
			this.second = 59;
			this.decreaseMinute();
		}
	}

	private void decreaseMillisecond() {
		--this.millisecond;
		if (this.millisecond <= -1) {
			this.millisecond = 999;
			this.decreaseSecond();
		}
	}

	/**
	 * Set one of the value of this {@link Time} to the given one
	 * @param part - Searched value of this {@link Time}
	 * @param value - Value to put
	 */
	public void set(int part, int value) {
		if (part == 0) {
			this.setYear(value);
		} else if (part == 1) {
			this.setMonth(value);
		} else if (part == 2) {
			this.setDay(value);
		} else if (part == 3) {
			this.setHour(value);
		} else if (part == 4) {
			this.setMinute(value);
		} else if (part == 5) {
			this.setSecond(value);
		} else if (part == 6) {
			this.setMillisecond(value);
		}
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month % 13;
	}

	public void setDay(int day) {
		this.day = this.month == 2 && this.year % 4 == 0 ? day % 30
				: (this.month == 2 ? day % 29
						: (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11 ? day % 31
								: day % 32));
	}

	public void setHour(int hour) {
		this.hour = hour % 24;
	}

	public void setMinute(int minute) {
		this.minute = minute % 60;
	}

	public void setSecond(int second) {
		this.second = second % 60;
	}

	public void setMillisecond(int millisecond) {
		this.millisecond = millisecond % 1000;
	}

	/**
	 * Initialize this {@link Time} with a string in th format "yyyyXmmXdd" Where X is a character
	 * @param date - String in the format "yyyyXmmXdd"
	 */
	public void setDate(String date) {
		if (date == null) {
			this.setDate(1970, 1, 1, 0, 0, 0, 0);
			return;
		}
		String tmp = date.substring(0, 4);
		int year = Integer.parseInt(tmp);
		tmp = date.substring(5, 7);
		int month = Integer.parseInt(tmp);
		tmp = date.substring(8, 10);
		int day = Integer.parseInt(tmp);
		this.setDate(year, month, day, 0, 0, 0, 0);
	}

	/**
	 * Initialize this {@link Time} with a other {@link Time}
	 * @param date - Time to copy
	 */
	public void setDate(Time date) {
		this.setYear(date.get(0));
		this.setMonth(date.get(1));
		this.setDay(date.get(2));
		this.setHour(date.get(3));
		this.setMinute(date.get(4));
		this.setSecond(date.get(5));
		this.setMillisecond(date.get(6));
	}

	public void setDate(int year, int month, int day, int hour, int minute, int second, int millisecond) {
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
		this.setMillisecond(millisecond);
	}

	/**
	 * Return a {@link Time} equivalent of the difference between the given {@link Time}
	 * @param time1 - {@link Time} to compare
	 * @param time2 - {@link Time} to compare
	 * @return A {@link Time} equivalent of the difference between the given {@link Time}
	 */
	public static Time diff(Time time1, Time time2) {
		Time diff = new Time(0, 0, 0, 0, 0, 0, 0);
		Time toDiff = new Time(0, 0, 0, 0, 0, 0, 0);
		if (time1.isAfter(time2)) {
			diff.setDate(time1);
			toDiff.setDate(time2);
		} else if (time1.isBefore(time2)) {
			diff.setDate(time2);
			toDiff.setDate(time1);
		}
		int i = 6;
		while (i >= 0) {
			if (diff.get(i) != toDiff.get(i)) {
				int n = 0;
				while (n < toDiff.get(i)) {
					diff.decrease(i);
					++n;
				}
			} else {
				diff.set(i, 0);
			}
			--i;
		}
		return diff;
	}
}