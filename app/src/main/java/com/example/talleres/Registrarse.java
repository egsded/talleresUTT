package com.example.talleres;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Registrarse extends AppCompatActivity {

    Spinner spn2, spn1;
    Integer elid1, elid2;
    List<Cuatrimestres> lc;
    List<Carreras> lca;
    ArrayList<String> cuatri,carre;
    Cuatrimestres cuatrimestres;
    Carreras carreras;
    EditText edtnombre, edtmatricula, edtseccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        spn1 = findViewById(R.id.spncarrera);
        spn2 = findViewById(R.id.spncuatrimestre);
        cuatri = new ArrayList<>();
        carre = new ArrayList<>();
        edtnombre = findViewById(R.id.edtnombre);
        edtmatricula = findViewById(R.id.edtmatricula);
        edtseccion = findViewById(R.id.edtseccion);

        final JsonArrayRequest jsonArrayRequest1= new JsonArrayRequest(Request.Method.GET, "http://talleresutt.mipantano.com/johnnylandcarrera", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Type tp= new TypeToken<List<Carreras>>(){}.getType();
                lca = new Gson().fromJson(response.toString(),tp);
                for (int i=0; i<lca.toArray().length; i++){
                    carreras = lca.get(i);
                    carre.add(carreras.getNombre());
                }
                spn1.setAdapter(new ArrayAdapter<String>(Registrarse.this,android.R.layout.simple_spinner_item, carre));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleyS.getInstance(getApplicationContext()).getRequestQueue().add(jsonArrayRequest1);
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String carrera = spn1.getItemAtPosition(spn1.getSelectedItemPosition()).toString();
                for(int i=0; i<lca.toArray().length;i++){
                    carreras = lca.get(i);
                    if(carrera== carreras.nombre){
                        elid1=carreras.id_carrera;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, "http://talleresutt.mipantano.com/johnnylandcuatri", null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Type tp = new TypeToken<List<Cuatrimestres>>(){}.getType();
                lc = new Gson().fromJson(response.toString(), tp);
                for (int i=0; i<lc.toArray().length; i++){
                    cuatrimestres = lc.get(i);
                    cuatri.add(cuatrimestres.getCuatrimestre());
                }
                spn2.setAdapter(new ArrayAdapter<String>(Registrarse.this, android.R.layout.simple_spinner_item, cuatri));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleyS.getInstance(getApplicationContext()).getRequestQueue().add(jsonArrayRequest);
        spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cuatriado = spn2.getItemAtPosition(spn2.getSelectedItemPosition()).toString();
                for (int i=0; i<lc.toArray().length;i++){
                    cuatrimestres = lc.get(i);
                    if (cuatriado==cuatrimestres.cuatrimestre){
                        elid2=cuatrimestres.id_cuatrimestre;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void onClick(View v){
        if (edtmatricula.getText().toString().trim().equalsIgnoreCase("") || edtseccion.getText().toString().trim().equalsIgnoreCase("") || edtnombre.getText().toString().trim().equalsIgnoreCase("")){
            Toast.makeText(Registrarse.this, "Tienes que completar todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            enviardatos();
            elecciones("Sus datos han sido guardados correctamente. Asistir a oficinas para su modificación");
        }
        edtseccion.setText("");
        edtnombre.setText("");
        edtmatricula.setText("");
    }
    public void elecciones(String cadena){
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
        alertbox.setMessage(cadena);
        alertbox.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Registrarse.this, "Se guardaron los datos",Toast.LENGTH_SHORT).show();
            }
        });
        alertbox.show();
    }
    public void enviardatos(){
        String nom,mat,sec;
        nom = edtnombre.getText().toString();
        mat = edtmatricula.getText().toString();
        sec = edtseccion.getText().toString();
    }

}
