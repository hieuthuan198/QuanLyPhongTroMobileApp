package demo.com.quanlyphongtro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.entities.Account;
import com.entities.Motel;
import com.service.ApiClient;
import com.service.MotelService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EditMotelActivity extends AppCompatActivity {

    private EditText editTextName,editTextPrice,editTextAdress,editTextPhone,editTextImage1,editTextImage2,editTextImage3,editTextImage4,editTextEmail,editTextDesctription,editTextType;
    private Button buttonSave;
    private Motel motel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_motel);
        initView();
        loadData();
    }
    private void initView(){
        editTextName = findViewById(R.id.editTextName);
        editTextPrice = findViewById(R.id.editTextPrice);
        editTextAdress=findViewById(R.id.editTextAdress);
        editTextPhone=findViewById(R.id.editTextPhone);
        editTextImage1=findViewById(R.id.editTextImage1);
        editTextImage2=findViewById(R.id.editTextImage2);
        editTextImage3=findViewById(R.id.editTextImage3);
        editTextImage4=findViewById(R.id.editTextImage4);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextDesctription=findViewById(R.id.editTextDescripton);
      //  editTextType=findViewById(R.id.editTextType);
        buttonSave = findViewById(R.id.buttonEdit);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSave_onClick(v);
            }
        });
    }

    private void loadData(){
        Intent intent = getIntent();
        motel = (Motel) intent.getSerializableExtra("motel");
        editTextName.setText(String.valueOf(motel.getName()));
        editTextPrice.setText(String.valueOf(motel.getPrice()));
        editTextAdress.setText(String.valueOf(motel.getAddress()));
        editTextPhone.setText(motel.getPhoneNumber());
        editTextImage1.setText(String.valueOf(motel.getImage1()));
        editTextImage2.setText(String.valueOf(motel.getImage2()));
        editTextImage3.setText(String.valueOf(motel.getImage3()));
        editTextImage4.setText(String.valueOf(motel.getImage4()));
        editTextEmail.setText(String.valueOf(motel.getEmail()));
        editTextDesctription.setText(String.valueOf(motel.getDescribe()));
       // editTextType.setText(String.valueOf(motel.getType()));
    }
    private void buttonSave_onClick(View v) {
        MotelService motelService = ApiClient.getClient().create(MotelService.class);
        Account account=new Account();
        account.setId(1);

        motel.setName(editTextName.getText().toString());
        motel.setPrice(Double.parseDouble(editTextPrice.getText().toString()) );
        motel.setAddress(editTextAdress.getText().toString());
        motel.setPhoneNumber(editTextPhone.getText().toString());
        motel.setEmail(editTextEmail.getText().toString());
        motel.setDescribe(editTextDesctription.getText().toString());
        motel.setImage1(editTextImage1.getText().toString());
        motel.setImage1(editTextImage2.getText().toString());
        motel.setImage1(editTextImage3.getText().toString());
        motel.setImage1(editTextImage4.getText().toString());
        motel.setType("244");
        motel.setStatus(true);
motel.setAccount(account);
        motelService.update(motel).enqueue(new Callback<Motel>() {
            @Override
            public void onResponse(Call<Motel> call, Response<Motel> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(EditMotelActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Motel> call, Throwable t) {

                Toast.makeText(getApplicationContext(), R.string.fail + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        try {

        } catch (Exception e){
            Toast.makeText(getApplicationContext(), R.string.fail + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
