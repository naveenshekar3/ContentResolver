package com.example.root.contentresolver;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void read(View view)
    {
        ContentResolver contentResolver=getContentResolver();
        //Uri uri= ContactsContract.Contacts.CONTENT_URI; //path for phone contacts, to know the path we need to refer documentation
        Uri uri=Uri.parse("content://com.example.root.contentproviderdatabase");



        //Cursor cursor=contentResolver.query(uri,null,null,null,null);

        Cursor cursor=contentResolver.query(uri,null,null,null,null);

        int name_column=cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);

        while (cursor.moveToNext())
        {
            Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();
        }
    }
}
