package com.rohini.homepage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rohini.homepage.R;
import com.rohini.homepage.bean.Bookbean;
import com.squareup.picasso.Picasso;

import java.util.List;


public class GridViewAdapter extends BaseAdapter {

    private List<Bookbean> spacecrafts;
    private Context context;

    public GridViewAdapter(Context context,List<Bookbean> spacecrafts){
        this.context = context;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int pos) {
        return spacecrafts.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
        }

        TextView nameTxt = view.findViewById(R.id.tvName);
        TextView tvId = view.findViewById(R.id.tvID);
        ImageView spacecraftImageView = view.findViewById(R.id.image_view);

        final Bookbean thisSpacecraft= spacecrafts.get(position);

        nameTxt.setText(thisSpacecraft.getAuthor());
        tvId.setText(thisSpacecraft.getId());

        if(thisSpacecraft.getAuthor_url() != null && thisSpacecraft.getAuthor_url().length()>0)
        {
            Picasso.get().load(thisSpacecraft.getAuthor_url()).placeholder(R.drawable.user).into(spacecraftImageView);
        }else {
            Toast.makeText(context, "Empty Image URL", Toast.LENGTH_LONG).show();
            Picasso.get().load(R.drawable.ic_launcher_background).into(spacecraftImageView);
        }


        return view;
    }
}




