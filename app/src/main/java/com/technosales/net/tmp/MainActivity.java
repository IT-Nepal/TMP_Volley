 package com.technosales.net.tmp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExampleAdapter exampleAdapter;
    private ArrayList<ExampleItem> exampleItemArrayList;
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         recyclerView = findViewById(R.id.rv);
         recyclerView.setHasFixedSize(true);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));

         exampleItemArrayList = new ArrayList<>();
         requestQueue = Volley.newRequestQueue(this);

         parseJSON();
    }

    private void parseJSON(){
           String url = "http://www.mocky.io/v2/5c20aa972e000081001e0b85";

           JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>(){
               public void onResponse(JSONObject response){
                   try {
                       JSONArray jsonArray = response.getJSONArray("data");
                       for(int i=0; i<jsonArray.length(); i++){
                           JSONObject jsonObject = jsonArray.getJSONObject(i);

                           int id = jsonObject.getInt("id");
                           String name = jsonObject.getString("name");
                           String image = jsonObject.getString("image");

                           exampleItemArrayList.add(new ExampleItem(image, name, id));

                       }

                       exampleAdapter = new ExampleAdapter(MainActivity.this,exampleItemArrayList);
                       recyclerView.setAdapter(exampleAdapter);
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
               }
           }, new Response.ErrorListener(){
               public void onErrorResponse(VolleyError error){
                error.printStackTrace();
               }
           });

           requestQueue.add(jsonObjectRequest);

    }
}
