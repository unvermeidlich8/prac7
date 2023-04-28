package com.example.prac5.UI.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prac5.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item> {
    private LayoutInflater inflater;
    private int layout;
    private List<Item> items;
    public CustomAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        Item item = items.get(position);
        Log.d("getView", item.getText());

        TextView textView = view.findViewById(R.id.CustomTextView);
        textView.setText(item.getText());

        ImageView imageView = view.findViewById(R.id.customImageView);
        imageView.setImageResource(item.getImageId());

        return view;
    }
}
