package com.example.talleres;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adaptadoralumnos extends RecyclerView.Adapter<Adaptadoralumnos.AlumnosviewHolder> {

    private List<alumnosdeprofesores> lap;
    private Context context;
    String usuario;

    public Adaptadoralumnos(List<alumnosdeprofesores> lap, Context context, String usuario) {
        this.lap = lap;
        this.context = context;
        this.usuario = usuario;
    }

    @NonNull
    @Override
    public AlumnosviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view3, viewGroup,false);
        return new AlumnosviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptadoralumnos.AlumnosviewHolder alumnosviewHolder, final int i) {
        alumnosviewHolder.txt1.setText(lap.get(i).getMatricula());
        alumnosviewHolder.txt2.setText(lap.get(i).getNombre());
        alumnosviewHolder.txt3.setText(lap.get(i).getCuatrimestre());
        alumnosviewHolder.txt4.setText(lap.get(i).getHoras());
    }

    @Override
    public int getItemCount() {
        return lap.size();
    }

    public class AlumnosviewHolder extends RecyclerView.ViewHolder {
        TextView txt1, txt2, txt3, txt4;
        public AlumnosviewHolder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txtmatricula);
            txt2 = itemView.findViewById(R.id.txtnombre);
            txt3 = itemView.findViewById(R.id.txtcuatri);
            txt4 = itemView.findViewById(R.id.txthoras);
        }
    }
}
