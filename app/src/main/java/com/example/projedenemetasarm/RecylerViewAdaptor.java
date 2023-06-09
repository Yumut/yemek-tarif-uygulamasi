package com.example.projedenemetasarm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecylerViewAdaptor extends RecyclerView.Adapter<RecylerViewAdaptor.Myholder>{

    private ArrayList<YemekListesi> yemeklerim;
    private final RexyclerViewInterface rexyclerViewInterface;
    public RecylerViewAdaptor(ArrayList<YemekListesi> listem,RexyclerViewInterface rexyclerViewInterface) {
        this.yemeklerim=listem;
        this.rexyclerViewInterface=rexyclerViewInterface;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.resyc_item,parent,false);

        return new Myholder(view,rexyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.yemekadi.setText(yemeklerim.get(position).getYemekAdi());
        holder.sunan.setText(yemeklerim.get(position).getYemekPaylasan());
        holder.resmi.setImageResource(yemeklerim.get(position).getYemekGorseli());
        holder.kisiSayisi.setText(yemeklerim.get(position).getKisiSayisi());
        holder.yemekSuresi.setText(yemeklerim.get(position).getYemekSuresi());

    }

    @Override
    public int getItemCount() {
        return yemeklerim.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{


        ImageView resmi;
        TextView yemekadi,sunan,yemekSuresi,kisiSayisi;

        public Myholder(@NonNull View itemView, RexyclerViewInterface rexyclerViewInterface) {
            super(itemView);
            resmi=itemView.findViewById(R.id.yemekResmi);
            yemekadi=itemView.findViewById(R.id.yemekAdi);
            sunan=itemView.findViewById(R.id.yemekPaylasan);
            yemekSuresi=itemView.findViewById(R.id.yemekSuresi);
            kisiSayisi=itemView.findViewById(R.id.kisiSayisi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(RecylerViewAdaptor.this.rexyclerViewInterface !=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            RecylerViewAdaptor.this.rexyclerViewInterface.itemOnclick(position);
                        }
                    }
                }
            });
        }
    }
}
