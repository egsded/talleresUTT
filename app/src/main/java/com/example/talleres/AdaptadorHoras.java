package com.example.talleres;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorHoras extends RecyclerView.Adapter<AdaptadorHoras.HorasviewHolder> {
    private List<horasporalumno> lha;
    private Context context;

    public AdaptadorHoras(List<horasporalumno> lha, Context context) {
        this.lha = lha;
        this.context = context;
    }

    @NonNull
    @Override
    public HorasviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view2, viewGroup, false);
        return new HorasviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorHoras.HorasviewHolder horasviewHolder, final int i) {
        horasviewHolder.txt1.setText(lha.get(i).getTaller());
        horasviewHolder.txt2.setText(lha.get(i).getEncargado());
        horasviewHolder.txt3.setText(lha.get(i).getHoras());
    }

    @Override
    public int getItemCount() {
        return lha.size();
    }

    public class HorasviewHolder extends RecyclerView.ViewHolder {
        TextView txt1,txt2,txt3;
        public HorasviewHolder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txttaller);
            txt2 = itemView.findViewById(R.id.txtencargado);
            txt3 = itemView.findViewById(R.id.txthora);
        }
    }
}
