package mindtree.com.stackoverflow.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import mindtree.com.stackoverflow.data.UserDetailContract.UserDetailEntity;
/**
 * Created by M1030452 on 3/28/2018.
 */

public class UserDetailDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "user_detail.db";
    private static final int VERSION_NUMBER = 1;

    public UserDetailDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_PRODUCTS = "CREATE TABLE " + UserDetailEntity.TABLE_NAME + "" + "("
                + UserDetailEntity._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + UserDetailEntity.COLUMN_USER_NAME + " TEXT NOT NULL, "
                + UserDetailEntity.COLUMN_USER_REPUTATION + " TEXT, "
                + UserDetailEntity.COLUMN_USER_IMAGE + " INTEGER"+
                ");";
        sqLiteDatabase.execSQL(CREATE_TABLE_PRODUCTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserDetailEntity.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
