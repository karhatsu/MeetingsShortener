package com.karhatsu.meetingsshortener;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CounterActivity extends Activity {

	public static final String EXTRA_PERSON_COUNT = "com.karhatsu.meetingsshortener.CounterActivity.personCount";
	public static final String EXTRA_HOUR_COST = "com.karhatsu.meetingsshortener.CounterActivity.hourCost";
	public static final String EXTRA_START_TIME = "com.karhatsu.meetingsshortener.CounterActivity.startTime";
	public static final String EXTRA_CURRENCY = "com.karhatsu.meetingsshortener.CounterActivity.currency";

	private TimerTask timerTask;
	private Timer timer = new Timer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);
		setupCounter();
	}

	private void setupCounter() {
		timerTask = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						updateCounterValue();
					}
				});
			}
		};
		timer.schedule(timerTask, 1000, 1000);
	}

	private void updateCounterValue() {
		TextView counter = (TextView) findViewById(R.id.counter);
		counter.setText(formatMoney(getMoneySpent()) + " " + getCurrency());
	}

	private String formatMoney(double moneySpent) {
		NumberFormat numberInstance = NumberFormat.getNumberInstance();
		numberInstance.setMaximumFractionDigits(2);
		numberInstance.setMinimumFractionDigits(2);
		return numberInstance.format(moneySpent);
	}

	private double getMoneySpent() {
		return Calculator.getMoneySpent(getPersonCount(), getAvgHourCost(),
				getStartTime());
	}

	private int getPersonCount() {
		return getIntent().getIntExtra(EXTRA_PERSON_COUNT, 0);
	}

	private int getAvgHourCost() {
		return getIntent().getIntExtra(EXTRA_HOUR_COST, 0);
	}

	private Date getStartTime() {
		return (Date) getIntent().getSerializableExtra(EXTRA_START_TIME);
	}

	private String getCurrency() {
		return getIntent().getStringExtra(EXTRA_CURRENCY);
	}
}
