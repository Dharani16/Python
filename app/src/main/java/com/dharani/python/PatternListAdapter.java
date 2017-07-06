package com.dharani.python;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.dharani.python.R.id.cardView;

/**
 * Created by LENOVO on 07/06/17.
 */

public class PatternListAdapter extends RecyclerView.Adapter<PatternListAdapter.MyViewHolder> {

    Integer[] image;
    String[] name;
    Context context;

    public PatternListAdapter(String[] programName, Integer[] programImage) {
        this.image = programImage;
        this.name = programName;
    }

    // myViewHolder class
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView txtView;
        public CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            txtView = (TextView)itemView.findViewById(R.id.textView);
            cardView = (CardView)itemView.findViewById(R.id.cardView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Toast.makeText(context, "Done "+getPosition(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
    // constructor for PatternListAdapter


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_adapter,viewGroup,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.imageView.setImageResource(Integer.parseInt(String.valueOf(image[position])));
        holder.txtView.setText(name[position]);


    }

    @Override
    public int getItemCount() {
        return name.length;
    }
}
