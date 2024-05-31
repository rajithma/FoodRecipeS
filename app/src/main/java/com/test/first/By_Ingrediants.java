package com.test.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class By_Ingrediants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_ingrediants);
    }
    public void bk_home(View view) {
        Intent intent = new Intent(this,Home_Page.class);
        startActivity(intent);
        finish();
    }
    public void bk_logout(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}