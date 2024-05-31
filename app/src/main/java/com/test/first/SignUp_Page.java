package com.test.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignUp_Page extends AppCompatActivity {
    private EditText Fullname,Username,Email,Password;
    private Button signupbtn;
    private TextView tvstatus;

    private String URL ="http://10.0.2.2/androidapp/signup.php";
    private String fullname,username,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        signupbtn = (Button) findViewById(R.id.signup);

        Fullname = findViewById(R.id.fullname);
        Username = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);


        fullname = username = email = password  = "";

    }
    public void save(View view) {

        fullname = Fullname.getText().toString().trim();
        username = Username.getText().toString().trim();
        email = Email.getText().toString().trim();
        password = Password.getText().toString().trim();


        if(!fullname.equals("")&&!username.equals("")&&!email.equals("")&&!password.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    if (response.contains("success")) {
                        Toast.makeText(getApplicationContext(),"success", Toast.LENGTH_SHORT).show();
                        signupbtn.setClickable(false);
                    } else if (response.contains("failure")) {
                        tvstatus.setText("something went wrong");
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("fullname",fullname);
                    data.put("username",username);
                    data.put("password",password);
                    data.put("email",email);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }
    }
    public void login(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}