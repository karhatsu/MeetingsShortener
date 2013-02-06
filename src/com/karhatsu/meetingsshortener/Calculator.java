package com.karhatsu.meetingsshortener;

import java.util.Date;
import java.util.GregorianCalendar;

public class Calculator {

	public static double getMoneySpent(int personCount, int avgHourCost,
			Date startTime) {
		double totalHourCost = personCount * avgHourCost;
		return secondsPassed(startTime) * (totalHourCost / 3600);
	}

	private static double secondsPassed(Date startTime) {
		GregorianCalendar start = new GregorianCalendar();
		start.setTime(startTime);
		GregorianCalendar now = new GregorianCalendar();
		return (now.getTimeInMillis() - start.getTimeInMillis()) / 1000;
	}

}
