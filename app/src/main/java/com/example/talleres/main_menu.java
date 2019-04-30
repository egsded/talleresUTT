package com.example.talleres;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class main_menu extends AppCompatActivity implements View.OnClickListener {

    String usuario, horasvacias;
    RecyclerView rcv;
    TextView btnva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main_menu);
        Bundle bn = getIntent().getExtras();
        usuario = bn.getString("usuario");

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btnhoras).setOnClickListener(this);
        rcv = findViewById(R.id.rcv1);
        final JSONObject obj = new JSONObject();
        try {
            obj.put("usuario",usuario);
            JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, "http://talleresutt.mipantano.com/traerhoras", obj, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        horasvacias = response.getString("siono");
                        Log.d("mmda", horasvacias);
                        switch (horasvacias){
                            case "0": btnva = findViewById(R.id.rl3);
                                btnva.setTextColor(Color.RED); break;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            VolleyS.getInstance(getApplicationContext()).getRequestQueue().add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://talleresutt.mipantano.com/johnnyland", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Type tp = new TypeToken<List<Talleres>>(){}.getType();
                List<Talleres>lt = new Gson().fromJson(response.toString(),tp);
                rcv.setLayoutManager(new LinearLayoutManager(main_menu.this));
                rcv.setAdapter(new AdaptadorTalleres(lt,main_menu.this, usuario));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleyS.getInstance(getApplicationContext()).getRequestQueue().add(jsonArrayRequest);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btn2){
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://talleresutt.mipantano.com/johnnylandcult", null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Type tp = new TypeToken<List<Talleres>>(){}.getType();
                    List<Talleres> lt = new Gson().fromJson(response.toString(),tp);
                    rcv.setLayoutManager(new LinearLayoutManager(main_menu.this));
                    rcv.setAdapter(new AdaptadorTalleres(lt,main_menu.this,usuario));
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            VolleyS.getInstance(getApplicationContext()).getRequestQueue().add(jsonArrayRequest);
        }
        else if(v.getId()==R.id.btn1){
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://talleresutt.mipantano.com/johnnylanddepo", null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Type tp = new TypeToken<List<Talleres>>(){}.getType();
                    List<Talleres> lt = new Gson().fromJson(response.toString(),tp);
                    rcv.setLayoutManager(new LinearLayoutManager(main_menu.this));
                    rcv.setAdapter(new AdaptadorTalleres(lt,main_menu.this, usuario));
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            VolleyS.getInstance(getApplicationContext()).getRequestQueue().add(jsonArrayRequest);
        }
        else if(v.getId()==R.id.btn3){
            final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://talleresutt.mipantano.com/johnnyland", null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Type tp = new TypeToken<List<Talleres>>(){}.getType();
                    List<Talleres>lt = new Gson().fromJson(response.toString(),tp);
                    rcv.setLayoutManager(new LinearLayoutManager(main_menu.this));
                    rcv.setAdapter(new AdaptadorTalleres(lt,main_menu.this, usuario));
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            VolleyS.getInstance(getApplicationContext()).getRequestQueue().add(jsonArrayRequest);
        }
        else if (v.getId()==R.id.btnhoras){
            Intent A = new Intent(main_menu.this,horas.class);
            A.putExtra("usuario",usuario);
            startActivity(A);
        }
    }
}
