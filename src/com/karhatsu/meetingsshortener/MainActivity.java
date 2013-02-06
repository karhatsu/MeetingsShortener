package com.karhatsu.meetingsshortener;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void showCounter(View view) {
		Intent intent = new Intent(this, CounterActivity.class);
		intent.putExtra(CounterActivity.EXTRA_PERSON_COUNT, getPersonCount());
		intent.putExtra(CounterActivity.EXTRA_HOUR_COST, getAvgHourCost());
		intent.putExtra(CounterActivity.EXTRA_START_TIME, new Date());
		intent.putExtra(CounterActivity.EXTRA_CURRENCY, getCurrency());
		startActivity(intent);
	}

	private int getPersonCount() {
		return getIntFromField(R.id.person_count);
	}

	private int getAvgHourCost() {
		return getIntFromField(R.id.avg_hour_cost);
	}

	private int getIntFromField(int resourceId) {
		EditText avgHourCostField = (EditText) findViewById(resourceId);
		return Integer.parseInt(avgHourCostField.getText().toString());
	}

	private String getCurrency() {
		return ((EditText) findViewById(R.id.currency)).getText().toString();
	}

}
