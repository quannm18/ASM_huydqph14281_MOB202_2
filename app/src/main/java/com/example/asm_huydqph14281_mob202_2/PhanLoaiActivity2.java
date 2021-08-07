package com.example.asm_huydqph14281_mob202_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.asm_huydqph14281_mob202_2.DAO.PhanLoaiDAO;
import com.example.asm_huydqph14281_mob202_2.adapter.PhanLoaiAdapter;
import com.example.asm_huydqph14281_mob202_2.model.PhanLoai;

import java.util.ArrayList;

public class PhanLoaiActivity2 extends AppCompatActivity {
    RecyclerView rvLoai;
    PhanLoaiDAO plDAO;
    ArrayList<PhanLoai> list = new ArrayList<>();
    PhanLoaiAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phan_loai2);
        rvLoai = findViewById(R.id.rcvPhanLoai);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PhanLoaiActivity2.this);
        rvLoai.setLayoutManager(layoutManager);

      //  plDAO = new PhanLoaiDAO(PhanLoaiActivity2.this);
        list =plDAO.getALL();

//         adapter = new PhanLoaiAdapter(PhanLoaiActivity2.this,list);
//         rvLoai.setAdapter(adapter);
        Log.e("Test1",list.get(0).toString());
    }
}
