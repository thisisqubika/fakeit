package com.mooveit.fakeit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mooveit.library.Fakeit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fakeit.init(this);

        TextView fullName = (TextView) findViewById(R.id.full_name);
        TextView fullMiddleName = (TextView) findViewById(R.id.full_middle_name);
        TextView firstName = (TextView) findViewById(R.id.first_name);
        TextView lastName = (TextView) findViewById(R.id.last_name);
        TextView title = (TextView) findViewById(R.id.title);
        TextView userName = (TextView) findViewById(R.id.user_name);

        fullName.setText(Fakeit.name().fullName());
        fullMiddleName.setText(Fakeit.name().fullWithMiddleName());
        firstName.setText(Fakeit.name().firstName());
        lastName.setText(Fakeit.name().lastName());
        title.setText(Fakeit.name().title());
        userName.setText(Fakeit.name().userName());
    }
}
