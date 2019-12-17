package demo.com.quanlyphongtro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.entities.Account;
import com.service.AccountlService;
import com.service.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText ediTtextUserName,ediTtextPassword;
    private Button buttonLogin;
    private TextView textViewError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    private void initView() {
        ediTtextUserName=findViewById(R.id.editTextUsername);
        ediTtextPassword=findViewById(R.id.editTextPassword);
        textViewError=findViewById(R.id.textViewError);
        buttonLogin=findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogin_onClick(v);
            }
        });

    }
   /* public void buttonLogin_onClick(View v) {
        AccountlService accountlService=ApiClient.getClient().create(AccountlService.class);

        try {
            final String username=ediTtextUserName.getText().toString();
            final String password=ediTtextPassword.getText().toString();


        accountlService.checkaccount(username,password).enqueue(new Callback<List<Account>>() {

            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                if(response.isSuccessful()){

                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);

                    startActivity(intent);
                    // list product co duoc tu goi api
                  //  List<Account> products = response.body();
                   // listViewInvoice.setAdapter(new InvoiceListAdapter(getApplicationContext(), R.layout.invoice_custom_layout, products));
                }else {
                  System.out.print("Fail");
                }
            }

            @Override
            public void onFailure(Call<List<Account>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                textViewError.setText(String.valueOf(t.getMessage()));
            }
        });
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),getString(R.string.fail)+":"+ e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
*/
   public void buttonLogin_onClick(View v) {
       AccountlService accountlService=ApiClient.getClient().create(AccountlService.class);

       try {
           final String username=ediTtextUserName.getText().toString();
           final String password=ediTtextPassword.getText().toString();


           accountlService.login(username,password).enqueue(new Callback<Account>() {

               @Override
               public void onResponse(Call<Account> call, Response<Account> response) {
                   if(response.isSuccessful()){

                       Intent intent=new Intent(LoginActivity.this,MainActivity.class);

                       startActivity(intent);
                       // list product co duoc tu goi api
                       //  List<Account> products = response.body();
                       // listViewInvoice.setAdapter(new InvoiceListAdapter(getApplicationContext(), R.layout.invoice_custom_layout, products));
                   }
               }

               @Override
               public void onFailure(Call<Account> call, Throwable t) {

                   Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                   textViewError.setText(String.valueOf(t.getMessage()));
               }
           });
       }catch (Exception e){
           Toast.makeText(getApplicationContext(),getString(R.string.fail)+":"+ e.getMessage(),Toast.LENGTH_LONG).show();
       }
   }


}
