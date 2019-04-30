package com.example.talleres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class profesor extends AppCompatActivity {

    RecyclerView rcv;
    EditText edt1;
    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);
        Bundle bn =getIntent().getExtras();
        usuario = bn.getString("usuario");

        rcv = findViewById(R.id.rcv1);

        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://talleresutt.mipantano.com/listadosalumnos/"+usuario, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Type tp = new TypeToken<List<alumnosdeprofesores>>(){}.getRawType();
                List<alumnosdeprofesores> ap = new Gson().fromJson(response.toString(), tp);
                Log.d("listas", ap.toString());
                rcv.setLayoutManager(new LinearLayoutManager(profesor.this));
                rcv.setAdapter(new Adaptadoralumnos(ap,profesor.this,usuario));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleyS.getInstance(profesor.this).getRequestQueue().add(jsonArrayRequest);
    }
}
