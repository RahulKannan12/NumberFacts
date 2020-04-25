package com.rk.numberfacts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewActivity2 extends Activity{
	static final String API_URL="http://numbersapi.com/";
	EditText number;
	Button search;
	TextView responseView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from new_activity.xml
		setContentView(R.layout.math_activity);
		responseView = (TextView) findViewById(R.id.responseView);
		search = (Button) findViewById(R.id.queryButton);
		number = (EditText) findViewById(R.id.number);
		//new RetrieveFeedTask().execute();
		search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RetrieveFeedTask().execute();
            }
        });
	}
	class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected void onPreExecute() {
           // progressBar.setVisibility(View.VISIBLE);
            responseView.setText("");
        }

        protected String doInBackground(Void... urls) {
            String category = "math";
            //String value= number.getText().toString();
            //int finalValue=Integer.parseInt(value);
            int val = Integer.parseInt( number.getText().toString() );
            //int no = number.getText();      
            		// Do some validation here

            try {
            	//String fin = val+category;
                URL url = new URL(API_URL+val+ "/" +category);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                }
                finally{
                    urlConnection.disconnect();
                }
            }
            catch(Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            if(response == null) {
            	
                response = "THERE WAS AN ERROR !! PLEASE CHECK YOUR INTERNET CONNECTION";
            }
            
            Log.i("INFO", response);
            responseView.setText(response);
          
        }
    }
}
