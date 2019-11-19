package demo.com.quanlyphongtro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

private ListView listViewMotel;
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


}