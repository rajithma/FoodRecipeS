package com.test.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Recipes_Results extends AppCompatActivity {

    String recipe1;
    private ImageView imageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_results);

        ImageView image1 = findViewById(R.id.image1);
        ImageView image2 = findViewById(R.id.image2);
        ImageView image3 = findViewById(R.id.image3);
        ImageView image4 = findViewById(R.id.image4);
        ImageView image5 = findViewById(R.id.image5);
        ImageView image6 = findViewById(R.id.image6);
        ImageView image7 = findViewById(R.id.image7);
        ImageView image8 = findViewById(R.id.image8);

        TextView text1 = findViewById(R.id.text01);
        TextView text2 = findViewById(R.id.text02);
        TextView text3 = findViewById(R.id.text08);
        TextView text4 = findViewById(R.id.text07);
        TextView text5 = findViewById(R.id.text06);
        TextView text6 = findViewById(R.id.text05);
        TextView text7 = findViewById(R.id.text04);
        TextView text8 = findViewById(R.id.text03);

        ImageView Array[] = {image1,image2,image3,image4,image5,image6,image7,image8};
        TextView Array2[] = {text1,text2,text3,text4,text5,text6,text7,text8};

        Intent intent = getIntent();
        recipe1 = intent.getStringExtra("Recipe");

        String url = "https://api.spoonacular.com/recipes/complexSearch?apiKey=c926c9cf64e84a22a04198fb6c3d0ec3&query="+recipe1+"&number=8";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonresponse = new JSONObject(response);
                    JSONArray jsonArray = jsonresponse.getJSONArray("results");

                    for (int i=0;i<8;i++) {
                    JSONObject jsonObjectfood= jsonArray.getJSONObject(i);

                    String recipe_name = jsonObjectfood.getString("title");

                    String imageurl = jsonObjectfood.getString("image");
                    Picasso.get().load(imageurl).into(Array[i]);

                    System.out.println(recipe_name);

                    Array2[i].setText(recipe_name);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString().trim(),Toast.LENGTH_SHORT).show();
            }


        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

    }



}