package com.byted.camp.todolist;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.RadioGroup;

import com.byted.camp.todolist.beans.Priority;
import com.byted.camp.todolist.beans.State;
import com.byted.camp.todolist.db.TodoContract;
import com.byted.camp.todolist.db.TodoDbHelper;

public class NoteActivity extends AppCompatActivity {

    private EditText editText;
    private Button addBtn;
    private SQLiteDatabase db;
    private TodoDbHelper dbHelper;
    private RadioGroup radioGroup;
    private RadioButton radioLow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        setTitle(R.string.take_a_note);

        editText = findViewById(R.id.edit_text);
        editText.setFocusable(true);
        editText.requestFocus();

        dbHelper = new TodoDbHelper(this);
        db = dbHelper.getWritableDatabase();

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.showSoftInput(editText, 0);
        }

        addBtn = findViewById(R.id.btn_add);
        radioGroup = findViewById(R.id.radio_group);
        radioLow = findViewById(R.id.radio_low);
        radioLow.setChecked(true);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence content = editText.getText();
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(NoteActivity.this,
                            "No content to add", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean succeed = saveNote2Database(content.toString().trim(), getPriority());
                if (succeed) {
                    Toast.makeText(NoteActivity.this,
                            "Note added", Toast.LENGTH_SHORT).show();
                    setResult(Activity.RESULT_OK);
                } else {
                    Toast.makeText(NoteActivity.this,
                            "Error", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private Priority getPriority(){
        int priority = this.radioGroup.getCheckedRadioButtonId();
        if(priority == R.id.radio_high){
            return Priority.HIGH;
        }else if(priority == R.id.radio_mid){
            return Priority.MEDIUM;
        }else{
            return Priority.LOW;
        }
    }

    private boolean saveNote2Database(String content, Priority priority) {
        // TODO 插入一条新数据，返回是否插入成功
        if(db != null && !TextUtils.isEmpty(content)){
            ContentValues contentValues = new ContentValues();
            contentValues.put(TodoContract.TodoNote.DATE, System.currentTimeMillis());
            contentValues.put(TodoContract.TodoNote.STATE, State.TODO.intValue);
            contentValues.put(TodoContract.TodoNote.CONTENT, content);
            contentValues.put(TodoContract.TodoNote.PRIORITY, priority.intValue);
            return db.insert("note", null, contentValues) != -1L;
        }
        return false;
    }
}
