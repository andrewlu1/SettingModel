package cn.andrewlu.settingmodel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/19.
 */

class SPSqliteDatabaseHelper extends SQLiteOpenHelper {

    public SPSqliteDatabaseHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("create table if not exists %s(%s varchar(255) PRIMARY KEY UNIQUE NOT NULL, %s varchar(512),%s varchar(100))",
                Settings.TABLE, Settings.KEY, Settings.VALUE, Settings.TYPE);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
