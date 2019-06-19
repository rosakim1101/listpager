package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    ArrayList<Data> items = new ArrayList<>();
    ListAdapter mAdapter;
    ListView listView;
    View v;

    public Fragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = LayoutInflater.from(getContext()).inflate(R.layout.fragment1,null);
        listView = v.findViewById(R.id.listview);
        mAdapter = new ListAdapter(items);
        listView.setAdapter(mAdapter);

        for(int i = 1; i <= 12; i++){
            items.add(new Data("a"+i,"b"+i));
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(v.getContext(), Detail_Activity.class);

                intent.putExtra("title",items.get(position).getTitle());
                intent.putExtra("content",items.get(position).getTitle());

                startActivity(intent);
            }
        });

        mAdapter.notifyDataSetChanged();

        return v;
    }
}
