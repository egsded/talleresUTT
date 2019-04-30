package com.example.talleres;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdaptadorTalleres extends RecyclerView.Adapter<AdaptadorTalleres.TallerviewHolder> implements View.OnClickListener {

    private List<Talleres> lt;
    private Context context;
    private View.OnClickListener eventoholderclick;
    Integer po;
    String usuario;

    public AdaptadorTalleres(List<Talleres> lt, Context context, String user) {
        this.lt = lt;
        this.context = context;
        this.usuario = user;
    }

    @NonNull
    @Override
    public TallerviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view1, viewGroup,false);
        v.setOnClickListener(this);
        return new TallerviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TallerviewHolder tallerviewHolder, final int i) {
        po = i;
        final Talleres t=lt.get(i);
        String it = t.getIcono();
        tallerviewHolder.img1.setImageResource(context.getResources().getIdentifier("drawable/"+it,null,context.getPackageName()));
        tallerviewHolder.txt1.setText(lt.get(i).getNombre());
        tallerviewHolder.txt2.setText(lt.get(i).getHorarios());
        tallerviewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(v.getContext(),TallerEsp.class);
                it.putExtra("id",t.getId_taller());
                it.putExtra("tipotaller",t.getTipos_taller());
                it.putExtra("encargado",t.getEncargado());
                it.putExtra("nombre", t.getNombre());
                it.putExtra("descripcion",t.getDescripcion());
                it.putExtra("horarios",t.getHorarios());
                it.putExtra("usuario",usuario);
                context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lt.size();
    }

    @Override
    public void onClick(View v) {
        if (eventoholderclick != null){
            eventoholderclick.onClick(v);
        }
    }

    public class TallerviewHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView txt1, txt2;
        public TallerviewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img1);
            txt1 = itemView.findViewById(R.id.txt1);
            txt2 = itemView.findViewById(R.id.txt2);
        }
    }
}
