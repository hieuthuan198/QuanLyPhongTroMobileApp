package com.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.entities.Motel;
import com.service.ApiClient;
import com.service.MotelService;


import java.io.InputStream;
import java.util.List;



import demo.com.quanlyphongtro.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        final ViewHolder viewHolder;
        //  SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        if(view==null){
            viewHolder =new ViewHolder();
            view=LayoutInflater.from(context).inflate(layout,null);
            viewHolder.textViewName=view.findViewById(R.id.textViewName);
            viewHolder.textViewPrice=view.findViewById(R.id.textViewPrice);
            viewHolder.imageViewPhoto=view.findViewById(R.id.imageViewPhoto);


        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        final Motel motel=motels.get(position);
        viewHolder.textViewName.setText(motel.getAddress());
        viewHolder.textViewPrice.setText(motel.getEmail());

       // MotelService motelService=ApiClient.getClient().create(MotelService.class);

       /* String a=motel.getImage1();


        motelService.getImage(a).enqueue(new Callback<byte[]>() {
            @Override
            public void onResponse(Call<byte[]> call, Response<byte[]> response) {
                if(response.isSuccessful()) {

                }

            }

            @Override
            public void onFailure(Call<byte[]> call, Throwable t) {

            }
        });*/

        new ImageRequestAsk(viewHolder.imageViewPhoto).execute("http://192.168.1.104:9597/api/motel/get/"+motel.getImage1());

        return view;
    }

    private static class ViewHolder{
        public static TextView textViewName;
        public static TextView textViewPrice;
        public  static ImageView imageViewPhoto;


    }
    private class ImageRequestAsk extends AsyncTask<String,Void,Bitmap>{


        private ImageView imageViewPhoto;

        public ImageRequestAsk(ImageView imageViewPhoto) {
            this.imageViewPhoto = imageViewPhoto;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                InputStream inputStream=new java.net.URL(params[0]).openStream();
                return BitmapFactory.decodeStream(inputStream);
            }catch (Exception e){
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageViewPhoto.setImageBitmap(bitmap);
        }


    }


}
