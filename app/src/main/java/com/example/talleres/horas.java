package com.example.talleres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

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

public class horas extends AppCompatActivity {

    /*TextView txt1,txt2,txt3;*/
    String usuario;
    RecyclerView otrorcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horas);
        Bundle bn = getIntent().getExtras();
        usuario = bn.getString("usuario");
        otrorcv = findViewById(R.id.rcv1);
        /*txt1 = findViewById(R.id.txttaller1);
        txt2 = findViewById(R.id.txtencargado1);
        txt3 = findViewById(R.id.txthora1);*/

        /*final JSONObject jsn = new JSONObject();
        try {
            jsn.put("usuario",usuario);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                    "http://talleresutt.mipantano.com/solicitudusuario", jsn, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        txt1.setText(response.getString("taller"));
                        txt2.setText(response.getString("encargado"));
                        txt3.setText(response.getString("horas"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }); VolleyS.getInstance(getApplicationContext()).getRequestQueue().add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://talleresutt.mipantano.com/horasusuario/"+usuario, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Type tp = new TypeToken<List<horasporalumno>>(){}.getType();
                List<horasporalumno> lh = new Gson().fromJson(response.toString(),tp);
                otrorcv.setLayoutManager(new LinearLayoutManager(horas.this));
                otrorcv.setAdapter(new AdaptadorHoras(lh,horas.this));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleyS.getInstance(getApplicationContext()).getRequestQueue().add(jsonArrayRequest);
    }
}
