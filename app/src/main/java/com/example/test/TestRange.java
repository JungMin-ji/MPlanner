package com.example.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class TestRange extends AppCompatActivity {

    ListView listView;
    RangeListViewAdapter adapter;
    ImageButton btnAddRange;
    EditText editSubject, editRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_range);

        listView = (ListView)findViewById(R.id.ListViewRange);
        btnAddRange = (ImageButton)findViewById(R.id.btnAddRange);
        editSubject = (EditText)findViewById(R.id.editSubjectName);
        editRange = (EditText)findViewById(R.id.editRange);

        adapter = new RangeListViewAdapter();
        listView.setAdapter(adapter);

        //btnAddRange.setOnClickListener(this);
    }


//    @Override
//    public void onClick(View view) {
//        adapter.addItem(editSubject.getText().toString(), editRange.getText().toString());
//        adapter.notifyDataSetChanged();
//    }


}