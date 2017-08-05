package com.example.sagar.hallbook;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sagar on 20/7/17.
 */

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.MyViewHolder>{

    private Context mcontext;
    private List<Vendor> vList;

    public VendorAdapter(Context mcontext, List<Vendor> vList) {
        this.mcontext = mcontext;
        this.vList = vList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, area;
        ImageView thumbnail;

        public MyViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.vendorName);
            area = (TextView) v.findViewById(R.id.vendorArea);
            thumbnail = (ImageView) v.findViewById(R.id.vendorThumbnail);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_layout,parent,false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Vendor vendor = vList.get(position);
        holder.name.setText(vendor.getvendorName());
        holder.area.setText(vendor.getArea());
        holder.thumbnail.setImageResource(vendor.getThumbnail());
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,BookingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("thumbnail", vendor.getThumbnail());
                intent.putExtra("name",vendor.getvendorName());
                intent.putExtra("area",vendor.getArea());
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vList.size();
    }




}
