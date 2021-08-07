package com.example.asm_huydqph14281_mob202_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.asm_huydqph14281_mob202_2.DAO.PhanLoaiDAO;
import com.example.asm_huydqph14281_mob202_2.model.PhanLoai;

import java.util.ArrayList;

//Test1

public class MainActivity extends AppCompatActivity {
PhanLoaiDAO phanLoaiDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    phanLoaiDAO = new PhanLoaiDAO(MainActivity.this);
//        ArrayList<PhanLoai> list = phanLoaiDAO.getALL();
//        Log.i("data",list.get(0).getTenLoai());

        //inset
//        PhanLoai pl = new PhanLoai("Tien thue nha","Chi");
//        if (phanLoaiDAO.insert(pl)){
//            Toast.makeText(MainActivity.this, "Thanh Cong", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(MainActivity.this, "That Bai", Toast.LENGTH_SHORT).show();
//        }

    }
}
