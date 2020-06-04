package com.byted.camp.todolist.db;
import android.provider.BaseColumns;
/**
 * Created on 2019/1/22.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public final class TodoContract {

    // TODO 定义表结构和 SQL 语句常量
    public static final String SQL_ADD_PRIORITY_COLUMN = "ALTER TABLE " + TodoNote.NAME +
            " ADD " + TodoNote.PRIORITY +  "INTEGER";

    public static final String SQL_CREATE_NOTES = "CREATE TABLE " + TodoNote.NAME +
            "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + TodoNote.DATE + " INTEGER, " +
            TodoNote.STATE + " INTEGER, " + TodoNote.CONTENT + " TEXT, " +
            TodoNote.PRIORITY + " INTEGER)";

    public static class TodoNote implements BaseColumns {
        public static final String CONTENT = "content";

        public static final String DATE = "date";

        public static final String PRIORITY = "priority";

        public static final String STATE = "state";

        public static final String NAME = "note";
    }

}
