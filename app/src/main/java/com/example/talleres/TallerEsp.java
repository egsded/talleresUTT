package com.example.talleres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class TallerEsp extends AppCompatActivity {

    TextView txt1,txt2,txt4;
    Integer id,tipostalleres;
    String encargado, nombre, descripcion,horarios, usuario;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller_esp);

        Bundle bt =getIntent().getExtras();
        id= bt.getInt("id");
        tipostalleres =bt.getInt("tipotaller");
        encargado = bt.getString("encargado");
        nombre = bt.getString("nombre");
        descripcion = bt.getString("descripcion");
        horarios = bt.getString("horarios");
        usuario = bt.getString("usuario");

        txt1 =findViewById(R.id.txt1);
        txt1.setText(nombre);
        txt2 = findViewById(R.id.txt2);
        txt2.setText(descripcion);
        txt4 = findViewById(R.id.txt4);
        txt4.setText(horarios);
        findViewById(R.id.rl1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent A = new Intent(TallerEsp.this,main_menu.class);
                startActivity(A);
                finish();
            }
        });
        findViewById(R.id.btnreg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TallerEsp.this,"Te has registrado al taller"+nombre,Toast.LENGTH_SHORT).show();
                JSONObject jsn = new JSONObject();
                try {
                    jsn.put("usuario", usuario);
                    jsn.put("taller", id);
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://talleresutt.mipantano.com/solicitud", jsn, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                    VolleyS.getInstance(TallerEsp.this).getRequestQueue().add(jsonObjectRequest);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
