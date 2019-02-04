package tech.raqib.cardiobook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class RecordList extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    private ListView oldRecordList;
    private ArrayList<String> recordList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);

        oldRecordList = findViewById(R.id.oldRecordList);
        Button addRecordButton = findViewById(R.id.add_record);
        Button editRecordButton = findViewById(R.id.edit_record);
        Button deleteRecordButton = findViewById(R.id.delete_record);

        loadFromFile();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, recordList);
//        oldRecordList.setAdapter(adapter);

//        String stringForRecord = getIntent().getStringExtra(MainActivity.RECORD_STRING);
//
//        Log.i("Check ", stringForRecord);
//        recordList.add(stringForRecord);
//        adapter.notifyDataSetChanged();
//        saveInFile();

        Intent newRecord = getIntent();
        String stringForRecord = newRecord.getStringExtra(MainActivity.RECORD_STRING);


//        Bundle newRecord = getIntent().getExtras();
//        //String stringForRecord = newRecordIntent.getStringExtra(MainActivity.RECORD_STRING);
//        if (newRecord != null) {
//            String date = newRecord.getString("mDate");
//            String time = newRecord.getString("mTime");
//            String systolicPressure = newRecord.getString("mSp");
//            String diastolicPressure = newRecord.getString("mDp");
//            String heartRate = newRecord.getString("mHR");
//            String comment = newRecord.getString("mComment");
//
//            Log.i("Check passed data ", date);
//            Log.i("Check passed data ", time);
//            Log.i("Check passed data ", systolicPressure);
//            Log.i("Check passed data ", diastolicPressure);
//            Log.i("Check passed data ", heartRate);
//            Log.i("Check passed data ", comment);
//
////            recordList.add(stringForRecord);
////            adapter.notifyDataSetChanged();
////            saveInFile();
//        }





//        adapter.notifyDataSetChanged();
//        saveInFile();


        addRecordButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecordList.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        loadFromFile();
//        adapter = new ArrayAdapter<>(this, R.layout.list_item, recordList);
//        oldRecordList.setAdapter(adapter);
//    }

    private void loadFromFile() {

        try {
            FileReader in = new FileReader(new File(getFilesDir(), FILENAME));
            Gson gson = new Gson();

            /*
            https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            on Feb 03, 2019
             */
            Type type = new TypeToken<ArrayList<String>>() {
            }.getType();
            recordList = gson.fromJson(in, type);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void saveInFile() {

        try {
            FileWriter out = new FileWriter(new File(getFilesDir(), FILENAME));
            Gson gson = new Gson();
            gson.toJson(recordList, out);
            out.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
