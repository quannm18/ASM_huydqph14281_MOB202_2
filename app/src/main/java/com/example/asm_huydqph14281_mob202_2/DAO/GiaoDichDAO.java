package com.example.asm_huydqph14281_mob202_2.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm_huydqph14281_mob202_2.database.DbHelper;
import com.example.asm_huydqph14281_mob202_2.model.GiaoDich;
import com.example.asm_huydqph14281_mob202_2.model.PhanLoai;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GiaoDichDAO {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    DbHelper helper;
    public GiaoDichDAO (Context context){
        helper = new DbHelper(context);
    }
    public ArrayList<GiaoDich>  getAll(){
        ArrayList<GiaoDich> gd = new ArrayList<>();
        SQLiteDatabase database =helper.getReadableDatabase();
        String sql = "SELECT * FROM PHANLOAI";
        Cursor cs = database.rawQuery(sql,null);
        cs.moveToFirst();//lenh dua con tro ve dong dau tien.
        while (cs.isAfterLast()== false){
            int ma = cs.getInt(0);
            String tieuDe = cs.getString(1);
            Date ngay = new Date("2021-07-07");
            try {
                 ngay = sdf.parse(cs.getString(2));
            }catch (Exception e){
                ngay = new Date("2021-07-07");
            }
            double tien = cs.getDouble(3);
            String moTa = cs.getString(4);
            int maLoai = cs.getInt(5);
            GiaoDich giaoDich = new GiaoDich(ma,tieuDe,ngay,tien,moTa,maLoai);
            gd.add(giaoDich);
            cs.moveToNext();

//            GiaoDich giaoDich = new GiaoDich(ma,ten,trangThai);
//            gd.add();
            cs.moveToNext();//lenh chuyen dong tiep theo

        }
        cs.close();
        database.close();
        return gd;

    }
    public boolean insert(GiaoDich giaoDich){
        SQLiteDatabase database =helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TieuDe",giaoDich.getTieuDe());
        values.put("ngay",sdf.format(giaoDich.getNgay()));
        values.put("tien",giaoDich.getTien());
        values.put("MoTa",giaoDich.getMoTa());
        values.put("MaLoai",giaoDich.getMaLoai());

        long row = database.insert("PHANLOAI",
                null,values);

        return (row > 0);


    }
    public boolean update(GiaoDich giaoDich){
        String sql = "UPDATE GIAODICH SET TieuDE = ?, Ngay =? ,moTa =? WHERE MaLoai=?";
        SQLiteDatabase database =helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TieuDE",giaoDich.getTieuDe());
        values.put("Ngay",sdf.format(giaoDich.getNgay()));
        values.put("moTa",giaoDich.getMoTa());

        int row = database.update("GIAODICH",values,
                "WHERE MaLoai=?",new  String[]{giaoDich.getMaLoai()+""});

        return (row>0);
    }
    public boolean delete( int maLoai){
        // String sql = "DELETE FROM PHANLOAI  WHERE MaLoai=?";
        SQLiteDatabase db = helper.getWritableDatabase();
        int row = db.delete("GIAODICH","WHERE MaLoai=?",new  String[]{maLoai+""});
        return row>0;

    }
}
