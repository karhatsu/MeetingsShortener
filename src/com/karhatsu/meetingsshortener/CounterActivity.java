package com.karhatsu.meetingsshortener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CounterActivity extends Activity {

	public static final String EXTRA_PERSON_COUNT = "com.karhatsu.meetingsshortener.CounterActivity.personCount";
	public static final String EXTRA_HOUR_COST = "com.karhatsu.meetingsshortener.CounterActivity.hourCost";
	public static final String EXTRA_START_TIME = "com.karhatsu.meetingsshortener.CounterActivity.startTime";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);
		setupCounter();
	}

	private void setupCounter() {
		TextView counter = (TextView) findViewById(R.id.counter);
		counter.setText(getMoneySpent() + " EUR");
	}

	private double getMoneySpent() {
		Intent intent = getIntent();
		int personCount = intent.getIntExtra(EXTRA_PERSON_COUNT, 0);
		int avgHourCost = intent.getIntExtra(EXTRA_HOUR_COST, 0);
		return personCount * avgHourCost;
	}
}
