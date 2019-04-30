package com.example.talleres;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class iniciosesion extends AppCompatActivity {

    EditText usuario, contra;
    String pass;
    Boolean resp =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciosesion);
        usuario = findViewById(R.id.edtusuario);
        contra = findViewById(R.id.edtcontrasena);
        findViewById(R.id.txtreg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://talleresutt.mipantano.com/registraralumno");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }
    public void onClick1(View v){
        pass=contra.getText().toString();
        sendRespond();
    }
    public void sendRespond(){
        final JSONObject jsn = new JSONObject();
        try {
            jsn.put("usuario", usuario.getText().toString());
            jsn.put("contraseña",contra.getText().toString());
            JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, "http://talleresutt.mipantano.com/7u7", jsn,
                    new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    String nom;
                    String tip;
                    try {
                        nom=response.getString("usuario");
                        Log.d("carajo", nom);
                        tip = response.getString("tipo");
                        switch (contra.getText().toString()){
                            case "123":switch (tip){
                                case "Alumno": Intent A = new Intent(iniciosesion.this,main_menu.class);
                                A.putExtra("usuario", usuario.getText().toString());
                                startActivity(A); break;
                                default: Toast.makeText(iniciosesion.this, "usuario incorrecto", Toast.LENGTH_SHORT).show(); break;
                            }
                                break;
                            default: Toast.makeText(iniciosesion.this,"Contraseña o usuario incorrecto",Toast.LENGTH_SHORT).show();
                            break;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(iniciosesion.this,error.toString(),Toast.LENGTH_SHORT).show();
                }
            });
            VolleyS.getInstance(iniciosesion.this).getRequestQueue().add(jsonObjectRequest);
        }catch (JSONException e){
            e.printStackTrace();
        }
  /*      JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.GET, "http://talleresutt.mipantano.com/johnnylandobtenerusuario", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("usuario")=="nada"){
                        usuario.setText("");
                        contra.setText("");
                        Toast.makeText(iniciosesion.this, "usuario o contraseña incorrecta",Toast.LENGTH_SHORT).show();
                    }else{
                        Intent A = new Intent(iniciosesion.this, main_menu.class);
                        A.putExtra("usuario",usuario.getText().toString());
                        startActivity(A);
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
        VolleyS.getInstance(iniciosesion.this).getRequestQueue().add(jsonObjectRequest1);*/
    }
}
