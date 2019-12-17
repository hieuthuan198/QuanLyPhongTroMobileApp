package demo.com.quanlyphongtro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.entities.Motel;

public class MotelDetailActivity extends AppCompatActivity {

    TextView textViewName,textViewPrice,textViewAdress,textViewEmail,textViewDescripbe,textViewPhone,textViewImage1,textViewImage3,textViewImage2,textViewImage4,textViewType;
    private Motel motel;
    private Button  buttonEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motel_detail);
        initView();
        loadData();
    }
    private void initView(){
        textViewName = findViewById(R.id.textViewName);

        textViewPrice = findViewById(R.id.textViewPrice);
        textViewAdress=findViewById(R.id.textViewAdress);
        textViewDescripbe=findViewById(R.id.textViewDescription);
        textViewPhone=findViewById(R.id.textViewPhone);
        textViewEmail=findViewById(R.id.textViewEmail);
        textViewImage1=findViewById(R.id.textViewImage1);
        textViewImage2=findViewById(R.id.textViewImage2);
        textViewImage3=findViewById(R.id.textViewImage3);
        textViewImage4=findViewById(R.id.textViewImage4);
        textViewType=findViewById(R.id.textViewType);
buttonEdit=findViewById(R.id.buttonEdit);
buttonEdit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        buttonEdit_onClick(v);
    }
});

    }

    private void loadData(){
        Intent intent = getIntent();

        motel = (Motel) intent.getSerializableExtra("motel");
        textViewName.setText(String.valueOf(motel.getName()));
        textViewPrice.setText(String.valueOf(motel.getPrice()));
        textViewEmail.setText(String.valueOf(motel.getEmail()));
        textViewPhone.setText(String.valueOf(motel.getPhoneNumber()));
        textViewDescripbe.setText(String.valueOf(motel.getDescribe()));
        textViewAdress.setText(String.valueOf(motel.getAddress()));
        textViewImage1.setText(String.valueOf(motel.getImage1()));
        textViewImage2.setText(String.valueOf(motel.getImage2()));
        textViewImage3.setText(String.valueOf(motel.getImage3()));
        textViewImage4.setText(String.valueOf(motel.getImage4()));
        textViewType.setText(String.valueOf(motel.getType()));
    }
    private void buttonEdit_onClick(View v) {
        Intent intent = new Intent(MotelDetailActivity.this, EditMotelActivity.class);
        intent.putExtra("motel", motel);
        startActivity(intent);
    }
}
