package com.rk.numberfacts;
//rahul - changes 25 Apr


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button trivia,math,date,year;
	TextView responseView;
	static final String API_URL="http://numbersapi.com/random/";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// responseView = (TextView) findViewById(R.id.txtView);
		responseView = (TextView) findViewById(R.id.txtView);
		//Button queryButton = (Button) findViewById(R.id.queryButton);
		trivia =(Button) findViewById(R.id.trivia_button);
		math =(Button) findViewById(R.id.math_button);
		date =(Button) findViewById(R.id.date_button);
	    year =(Button) findViewById(R.id.year_button);
	    
	    trivia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent myIntent = new Intent(MainActivity.this,
						NewActivity1.class);
				startActivity(myIntent);
                //new RetrieveFeedTask().execute();
            }
        });
	    math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent myIntent = new Intent(MainActivity.this,
						NewActivity2.class);
				startActivity(myIntent);
                //new RetrieveFeedTask1().execute();
            }
        });
	    date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent myIntent = new Intent(MainActivity.this,
						NewActivity3.class);
				startActivity(myIntent);
                //new RetrieveFeedTask2().execute();
            }
        });
	    year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent myIntent = new Intent(MainActivity.this,
						NewActivity4.class);
				startActivity(myIntent);
                //new RetrieveFeedTask3().execute();
            }
        });
	    
	}
	
     
	

}
