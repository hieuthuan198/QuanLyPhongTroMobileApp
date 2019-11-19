package com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.entities.Banner;
import com.entities.Motel;


import java.util.List;

import demo.com.quanlyphongtro.R;

public class MotelListAdaper extends ArrayAdapter {

    private Context context;
    private  int layout;
    private List<Motel> motels;

    public MotelListAdaper( Context context, int resource,List<Motel> object) {
        super(context, resource,object);
        this.context=context;
        this.layout=resource;
        this.motels=object;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        //  SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        if(view==null){
            viewHolder =new ViewHolder();
            view=LayoutInflater.from(context).inflate(layout,null);
            viewHolder.textViewName=view.findViewById(R.id.textViewName);
            viewHolder.textViewPrice=view.findViewById(R.id.textViewPrice);

        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        Motel motel=motels.get(position);
        viewHolder.textViewName.setText(motel.getAddress());
        viewHolder.textViewPrice.setText(motel.getEmail());

        return view;
    }

    private static class ViewHolder{
        public static TextView textViewName;
        public static TextView textViewPrice;


    }

}
