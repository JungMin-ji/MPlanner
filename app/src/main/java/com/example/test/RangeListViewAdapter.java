package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class RangeListViewAdapter extends BaseAdapter {
    private EditText editSubject, editRange;
    private ArrayList<ListViewItem2> listViewItemList = new ArrayList<ListViewItem2>();

    public RangeListViewAdapter(){

    }
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_testrange, parent,false);
        }

        editSubject = (EditText)convertView.findViewById(R.id.editSubjectName);
        editRange = (EditText)convertView.findViewById(R.id.editRange);

        ListViewItem2 listViewItem2 = listViewItemList.get(position);
        editSubject.setText(listViewItem2.getTitle());
        editRange.setText(listViewItem2.getContent());

        return convertView;

    }

    public void addItem(String title, String content){
        ListViewItem2 item = new ListViewItem2();

        item.setTitle(title);
        item.setContent(content);

        listViewItemList.add(item);
    }
}

class ListViewItem2{
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
