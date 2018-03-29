package mindtree.com.stackoverflow.data;

import android.provider.BaseColumns;

/**
 * Created by M1030452 on 3/28/2018.
 */

public class UserDetailContract {
    public static final class UserDetailEntity implements BaseColumns {
        public static final String TABLE_NAME="user";
        public static final String _ID= BaseColumns._ID;
        public static final String COLUMN_USER_NAME="name";
        public static final String COLUMN_USER_REPUTATION="reputation";
        public static final String COLUMN_USER_IMAGE="url";
    }
}
