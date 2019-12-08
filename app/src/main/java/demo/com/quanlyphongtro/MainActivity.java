package demo.com.quanlyphongtro;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.adapter.MotelListAdaper;
import com.entities.Banner;
import com.entities.Motel;
import com.entities.Motel1;
import com.service.ApiClient;
import com.service.BannerService;
import com.service.MotelService;

import java.io.InputStream;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

private ListView listViewMotel;
private Button buttonLogin;
    //private GridView gridViewMotel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }

    private void initView(){
        listViewMotel=findViewById(R.id.listViewMotel);
        buttonLogin=findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login_onClick(v);
            }
        });
    }
    private void loadData(){
        MotelService motelService=ApiClient.getClient().create(MotelService.class);
        motelService.findAllMotel1().enqueue(new Callback<List<Motel>>()
        {
            @Override
            public void onResponse(Call<List<Motel>> call, Response<List<Motel>> response) {
                if(response.isSuccessful()){
                    List<Motel> items=response.body();
                    listViewMotel.setAdapter(new MotelListAdaper(getApplicationContext(),R.layout.motel_custom_layout,items));
                }
            }

            @Override
            public void onFailure(Call<List<Motel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private class HtpRequestAsk extends AsyncTask<Void,Void,List<Motel>>{

        @Override
        protected List<Motel> doInBackground(Void... params) {

            return  null;
        }
    }
    public void Login_onClick(View v) {
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);

        startActivity(intent);
    }

}
