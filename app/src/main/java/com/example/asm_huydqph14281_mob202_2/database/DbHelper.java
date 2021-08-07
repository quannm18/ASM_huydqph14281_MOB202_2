package com.example.asm_huydqph14281_mob202_2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper  extends SQLiteOpenHelper {
    public DbHelper( Context context) {
        //db
        super(context, "ASM_MOB202", null, 1);
    }
   public static final String create_table = "CREATE TABLE PHANLOAI(MaLoai integer primary key ," +
            "TenLoai text,TrangThai text)";

    public static final String create_table2 = "CREATE TABLE GIAODICH(MaLoai integer primary key ," +
            "TieuDE text,Ngay date,tien float,MoTa text," +
            "MaLoai integer references PHANLOAI(MaLoai))";
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(create_table);

//       String sql = "INSERT INTO  PHANLOAI VALUES(1, 'Luong','Thu')";
//        db.execSQL(sql);
//
//        sql = "INSERT INTO  PHANLOAI VALUES(2, 'Thu No','Thu')";
//        db.execSQL(sql);
//
//        sql = "INSERT INTO  PHANLOAI VALUES(3, 'Khac','Thu')";
//        db.execSQL(sql);
//
//        sql = "INSERT INTO  PHANLOAI VALUES(4, 'Du lich','Chi')";
//        db.execSQL(sql);
//
//        sql = "INSERT INTO  PHANLOAI VALUES(5, 'Sinh Hoat','Chi')";
//        db.execSQL(sql);

        db.execSQL(create_table2);

//       String sql1 = "INSERT INTO  GIAODICH VALUES(1, 'Luong Thang','2021-08-7',1000,'Luong thang',1)";
//        db.execSQL(sql1);
//
//        sql1 = "INSERT INTO  GIAODICH VALUES(2, 'tien mua do','2021-08-7',2000,'mua do',5)";
//        db.execSQL(sql1);
//
//        sql1 = "INSERT INTO  GIAODICH VALUES(3, 'thu no','2021-08-7',2000,'thu no',2)";
//        db.execSQL(sql1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PHANLOAI");
        db.execSQL("DROP TABLE IF EXISTS GIAODICH");
        onCreate(db);
    }
}
