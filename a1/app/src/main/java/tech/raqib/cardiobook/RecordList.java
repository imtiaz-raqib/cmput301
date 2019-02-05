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

    private final static int REQUEST_CODE_1 = 1;
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
        addRecordButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addRecord = new Intent(RecordList.this, MainActivity.class);
                startActivityForResult(addRecord, REQUEST_CODE_1);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);

        // The returned result data is identified by requestCode.
        // The request code is specified in startActivityForResult(intent, REQUEST_CODE_1); method.
        switch (requestCode) {
            // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
            case REQUEST_CODE_1:

                if (resultCode == RESULT_OK) {
                    String stringForRecord = dataIntent.getStringExtra("RECORD_STRING");
                    recordList.add(stringForRecord);
                    Log.i("TEST........", stringForRecord);
                    adapter.notifyDataSetChanged();
                    saveInFile();
                }
                break;
        }
    }
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        loadFromFile();
		/*
		Adapter is a binder between arrays
		This will call toString which will give back the string ID
		 */
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, recordList);

        //oldRecordList.setAdapter(adapter);


    }

    private void loadFromFile() {

        try {

            FileReader in = new FileReader(new File(getFilesDir(), FILENAME));
            Gson gson = new Gson();

            /*
            https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            on Jan 16, 2019
             */
            Type type = new TypeToken<ArrayList<String>>(){}.getType();
            recordList = gson.fromJson(in, type);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * This method implements saving the new tweets by clicking on the save button and displaying
     * them as a list view.
     *
     * This method uses Google's GSON library for persistent data storage.
     *
     * @throws FileNotFoundException e
     */
    private void saveInFile() {
        try {

            /*
            Better than FileOutputStream
            Get the directory of the application and create a file there
             */
            FileWriter out = new FileWriter(new File(getFilesDir(), FILENAME));

            /*
            Converts an object to JSON format
             */
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

