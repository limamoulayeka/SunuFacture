package com.limamoulayeka.sunufacture;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListDataRuleActivity extends AppCompatActivity {
    private static final String TAG = "ListDataRuleActivity";

    Databasehelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_rule_layout);
        mDatabaseHelper = new Databasehelper(this);
        mListView = findViewById(R.id.listViewRule);
        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in listView.");
        Cursor data = mDatabaseHelper.getDataRule();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add("Id :"+data.getString(0)+"\n");
            listData.add("Rulename :"+data.getString(1)+"\n\n\n\n");
            }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }

    private void toastMessage(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
