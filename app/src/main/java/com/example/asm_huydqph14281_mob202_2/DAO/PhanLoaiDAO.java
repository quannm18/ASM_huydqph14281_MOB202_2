package com.example.asm_huydqph14281_mob202_2.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.asm_huydqph14281_mob202_2.database.DbHelper;
import com.example.asm_huydqph14281_mob202_2.model.PhanLoai;

import java.util.ArrayList;

public class PhanLoaiDAO {
    DbHelper helper;
    public  PhanLoaiDAO(Context context){
         helper = new DbHelper(context);
    }
    /**
     * @param :no param
     * @return:ArrayList<PhanLoai> ds
     */
    public ArrayList<PhanLoai> getALL(){
        ArrayList<PhanLoai> ds = new ArrayList<>();
        SQLiteDatabase database =helper.getReadableDatabase();
        String sql = "SELECT * FROM PHANLOAI";
        Cursor cs = database.rawQuery(sql,null);
        cs.moveToFirst();//lenh dua con tro ve dong dau tien.
        while (cs.isAfterLast()== false){
            int ma = cs.getInt(0);
            String ten = cs.getString(1);
            String trangThai = cs.getString(2);
            PhanLoai phanLoai = new PhanLoai(ma,ten,trangThai);
            ds.add(phanLoai);
            cs.moveToNext();//lenh chuyen dong tiep theo

        }
        cs.close();
        database.close();
        return ds;
    }
    public boolean insert(PhanLoai phanLoai){
        SQLiteDatabase database =helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenLoai",phanLoai.getTenLoai());
        values.put("TrangThai", phanLoai.getTrangThai());
        long row = database.insert("PHANLOAI",null,values);

        return (row > 0);


    }
    public boolean update(PhanLoai phanLoai){
        String sql = "UPDATE PHANLOAI SET TenLoai = ?, TrangThai =? WHERE MaLoai=?";
        SQLiteDatabase database =helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenLoai",phanLoai.getTenLoai());
        values.put("TrangThai", phanLoai.getTrangThai());
        int row = database.update("PHANLOAI",values,
                "WHERE MaLoai=?",new  String[]{phanLoai.getMaLoai()+""});

    return (row>0);
    }
    public boolean delete( int maLoai){
       // String sql = "DELETE FROM PHANLOAI  WHERE MaLoai=?";
        SQLiteDatabase db = helper.getWritableDatabase();
        int row = db.delete("PHANLOAI","WHERE MaLoai=?",new  String[]{maLoai+""});
        return row>0;

    }
}
