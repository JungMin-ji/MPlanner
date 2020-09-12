package com.example.test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ImageButton btnAddTodo;
    TextView txtAddTodo;
    CheckBox checkBox1, checkBox2;
    ScrollView sv;
    ListView listView;
    final ArrayList<String> todoList = new ArrayList<String>();  // 최대 50개의 체크박스 추가
    ListViewAdapter myAdapter;
    BottomNavigationView navigationbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // custom actionbar
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("오늘의 할 일");

        // shared preference
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);

        btnAddTodo = findViewById(R.id.btnAddTodo);
        txtAddTodo = findViewById(R.id.txtAddTodo);
        listView = findViewById(R.id.listView);
        navigationbar = findViewById(R.id.nav_view);


        // 리스트뷰 설정
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_multichoice, todoList);
//        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//        listView.setAdapter(adapter);
        myAdapter = new ListViewAdapter();
        myAdapter.notifyDataSetChanged();
        listView.setAdapter(myAdapter);

        // add checkbox
        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
                myAdapter.notifyDataSetChanged();

            }
        });

        txtAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
                myAdapter.notifyDataSetChanged();
            }
        });

        // navigation bar 클릭 처리
        navigationbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.calendar:
                        //Intent intent = new Intent(this, );
                        break;
                    case R.id.testRange : {
                        Intent intent = new Intent(getApplicationContext(), TestRange.class);
                        startActivity(intent);
                        break;
                    }

                    case R.id.memo:
                       break;
                }
                return true;

            }
        });

    }

  void show(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.add_todo_dialog, null);
        builder.setView(view);

        final EditText editTodo = (EditText) view.findViewById(R.id.editTodo);
        final Button btnPositive = (Button) view.findViewById(R.id.btnPositive);
        final Button btnNegative = (Button) view.findViewById(R.id.btnNegative);

        final AlertDialog dialog = builder.create();

        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTodo.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "내용을 입력하세요.",Toast.LENGTH_SHORT).show();
                }
                else{
                    //odoList.add(editTodo.getText().toString());
                    myAdapter.addItem(editTodo.getText().toString());
                }
                dialog.dismiss();
            }
        });

        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
