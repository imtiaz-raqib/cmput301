package tech.raqib.cardiobook;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements OnTimeSetListener, OnDateSetListener {


    private EditText displayDate;                    // Variable for Date Dialog
    private EditText displayTime;                    // Variable for Time Dialog
    private EditText getSystolicPressure;
    private EditText getDiastolicPressure;
    private EditText getHeartRate;
    private EditText getComment;
    private EditText getDate;
    private EditText getTime;

    public static final String RECORD_STRING = "tech.raqib.helloworld.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDate = findViewById(R.id.date_in);
        getTime = findViewById(R.id.time_in);
        getSystolicPressure = findViewById(R.id.systolic);
        getDiastolicPressure = findViewById(R.id.diastolic);
        getHeartRate = findViewById(R.id.hr);
        getComment = findViewById(R.id.comments);

        /*
        This allows for the user to click on "SHOW LIST" to go to the activity RecordList.java
        and start a new activity
         */
        Button showListButton = findViewById(R.id.show_list);
        showListButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecordList.class);
                finish();
                startActivity(intent);
            }
        });

        Button recordMeasurementButton = findViewById(R.id.add_record);
        recordMeasurementButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                String date = getDate.getText().toString();
                String time = getTime.getText().toString();
                String systolicPressure = getSystolicPressure.getText().toString();
                String diastolicPressure = getDiastolicPressure.getText().toString();
                String heartRate = getHeartRate.getText().toString();
                String comment = getComment.getText().toString();

                CreateRecordString record = new CreateRecordString();
                record.setRecordString(date, time, systolicPressure, diastolicPressure, heartRate, comment);
                String recordString = record.toString();

                Intent recordIntent = new Intent(MainActivity.this, RecordList.class);
                recordIntent.putExtra(RECORD_STRING, recordString);
                startActivity(recordIntent);
            }
        });

        /*
        Setting up a popup time dialog to Brute enforce the user to enter the time in proper
        syntax
        Citation:
        Coding in Flow @ YouTube
        https://www.youtube.com/watch?v=33BFCdL0Di0
         */
        displayDate = findViewById(R.id.date_in);
        displayDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "Date Picker");
            }
        });

        /*
        Setting up a popup time dialog to Brute enforce the user to enter the time in proper
        syntax
        Citation:
        Coding in Flow @ YouTube
        https://www.youtube.com/watch?v=QMwaNN_aM3U
         */
        displayTime = findViewById(R.id.time_in);
        displayTime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "Time Picker");
            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        month = month + 1;

        /*
        Making sure the syntax is in the form of YYYY-MM-DD
         */
        if (month < 10 && day < 10) {
            String date = year + "-0" + month + "-0" + day;
            displayDate.setText(date);
        } else if (month < 10){
            String date = year + "-0" + month + "-" + day;
            displayDate.setText(date);
        } else if (day < 10) {
            String date = year + "-" + month + "-0" + day;
            displayDate.setText(date);
        } else {
            String date = year + "-" + month + "-" + day;
            displayDate.setText(date);
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        displayTime.setText(hourOfDay + ":" + minute);
    }
}
