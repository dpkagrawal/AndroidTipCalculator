package com.codepath.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculator extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

	public void calculateTip(View v) {
		Double tipAmount;
		Double amount = 0.0;
		Double totalAmount;
		EditText et_amount = (EditText) findViewById(R.id.et_amount);
		TextView tv_tip = (TextView) findViewById(R.id.tip_amount);
		TextView tv_total = (TextView) findViewById(R.id.total_amount);

		try {
			amount = Double.parseDouble(et_amount.getText().toString());
		} catch (NumberFormatException e) {
			System.out.println("Number Format Exception:" + e);
		}
		switch (v.getId()) {
		case R.id.button10:
			tipAmount = amount * 0.1;
			break;
		case R.id.button20:
			tipAmount = amount * 0.2;
			break;
		case R.id.button30:
			tipAmount = amount * 0.3;
			break;
		default:
			tipAmount = 0.0;
		}
		totalAmount = amount + tipAmount;
		tv_tip.setText("$ " + tipAmount.toString());
		tv_total.setText("$ "+ totalAmount.toString());
	}
	
	public void clear(View v){
		EditText et_amount = (EditText) findViewById(R.id.et_amount);
		TextView tv_tip = (TextView) findViewById(R.id.tip_amount);
		TextView tv_total = (TextView) findViewById(R.id.total_amount);
		et_amount.setText("");
		tv_tip.setText("");
		tv_total.setText("");
	}
}
