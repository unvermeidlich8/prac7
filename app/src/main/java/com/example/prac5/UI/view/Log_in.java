package com.example.prac5.UI.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prac5.R;

import java.util.ArrayList;
import java.util.List;


public class Log_in extends Fragment {



    public Log_in() {
        // Required empty public constructor
    }


    public static Log_in newInstance(String param1, String param2) {
        Log_in fragment = new Log_in();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 200; i++){
            itemList.add(new Item(R.drawable.test,"Test"+i));
        }
        ListView LV = view.findViewById(R.id.itemsList);
        CustomAdapter adapter = new CustomAdapter(getContext(),R.layout.custom,itemList);
        LV.setAdapter(adapter);

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),((TextView) view.findViewById(R.id.CustomTextView)).getText(),
                        Toast.LENGTH_SHORT).show();
                Log.d("ListView", (String) ((TextView) view.findViewById(R.id.CustomTextView)).getText());
            }
        });
        return view;
    }

}
