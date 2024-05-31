package com.test.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Home_Page extends AppCompatActivity {

    private EditText Recipe;
    private String recipe1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        recipe1 = "";
        Recipe = findViewById(R.id.recipe);

    }

    public void By_Ingrediants(View view) {
        Intent intent = new Intent(this, By_Ingrediants.class);
        startActivity(intent);

    }

    public void bk_login(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void Search_Res(View view) {
        recipe1 = Recipe.getText().toString().trim();

        Intent intent = new Intent(Home_Page.this, Recipes_Results.class);
        intent.putExtra("Recipe",recipe1);
        startActivity(intent);


    }
}