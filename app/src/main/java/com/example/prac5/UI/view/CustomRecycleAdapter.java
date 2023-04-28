package com.example.prac5.UI.view;

import android.content.Context;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.recyclerview.widget.RecyclerView;

import com.example.prac5.R;

import java.util.List;

public class CustomRecycleAdapter extends RecyclerView.Adapter<CustomRecycleAdapter.ViewHolder>{

    private final LayoutInflater inflater; //to display
    private final List<Item> states;

    CustomRecycleAdapter(Context context, List<Item> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public CustomRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomRecycleAdapter.ViewHolder holder, int position) {
        Item state = states.get(position);
        holder.nameView.setText(state.getText());
        holder.flagView.setImageResource(state.getImageId());

        holder.nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(inflater.getContext(), (String)holder.nameView.getText(), Toast.LENGTH_SHORT).show();
                Log.d("onBindViewHolder", (String)holder.nameView.getText());
            }
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            flagView = view.findViewById(R.id.customImageView);
            nameView = view.findViewById(R.id.CustomTextView);
        }
    }
}