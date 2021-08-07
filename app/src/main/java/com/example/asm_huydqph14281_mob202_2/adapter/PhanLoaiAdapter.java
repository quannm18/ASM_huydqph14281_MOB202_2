package com.example.asm_huydqph14281_mob202_2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_huydqph14281_mob202_2.R;
import com.example.asm_huydqph14281_mob202_2.model.PhanLoai;

import java.util.ArrayList;

public class PhanLoaiAdapter extends RecyclerView.Adapter<PhanLoaiAdapter.PhanLoaiViewHolder> {
    Context context;
    ArrayList<PhanLoai> list;
    public  PhanLoaiAdapter(Context context, ArrayList<PhanLoai> list){
        this.context = context;
        this.list = list;


    }
    @NonNull
    @Override
    public PhanLoaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.phanloai_view_item,parent,false);
        PhanLoaiViewHolder viewHolder = new PhanLoaiViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhanLoaiAdapter.PhanLoaiViewHolder holder, int position) {
        PhanLoai phanLoai = list.get(position);//lay ra 1 phan tu trong list dua vao position
        holder.tvTenLoai.setText(phanLoai.getTenLoai());
        holder.tvTrangThai.setText(phanLoai.getTrangThai());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class PhanLoaiViewHolder extends RecyclerView.ViewHolder{

        private CardView carviewPhanloai;
        private TextView tvTenLoai;
        private TextView tvTrangThai;
        private ImageView imgedit;
        private ImageView imgdelete;
        public PhanLoaiViewHolder(  View view) {
            super(view);
            carviewPhanloai = (CardView) view.findViewById(R.id.carview_phanloai);
            tvTenLoai = (TextView) view.findViewById(R.id.tvTenLoai);
            tvTrangThai = (TextView) view.findViewById(R.id.tvTrangThai);
            imgedit = (ImageView) view.findViewById(R.id.imgedit);
            imgdelete = (ImageView) view.findViewById(R.id.imgdelete);



        }
    }
}
