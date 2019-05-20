package com.example.a721intents_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adress = findViewById(R.id.adress);
    }

    public void searchAdress(View view) {
        Intent searchIntent = new Intent(Intent.ACTION_VIEW);

        if (Character.isLetter(adress.getText().charAt(0))) {
            Uri uri = Uri.parse("geo:?q=" + adress.getText().toString());
            searchIntent.setData(uri);
        } else {
            Uri uri = Uri.parse("geo:" + adress.getText().toString());
            searchIntent.setData(uri);
        }
        startActivity(searchIntent);
    }
}
