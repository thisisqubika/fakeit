package com.mooveit.fakeit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mooveit.library.Factory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView fullName = (TextView) findViewById(R.id.full_name);
        TextView fullMiddleName = (TextView) findViewById(R.id.full_middle_name);
        TextView firstName = (TextView) findViewById(R.id.first_name);
        TextView lastName = (TextView) findViewById(R.id.last_name);
        TextView title = (TextView) findViewById(R.id.title);
        TextView userName = (TextView) findViewById(R.id.user_name);

        fullName.setText(Factory.FakeIt.name(this).fullName());
        fullMiddleName.setText(Factory.FakeIt.name(this).fullWithMiddleName());
        firstName.setText(Factory.FakeIt.name(this).firstName());
        lastName.setText(Factory.FakeIt.name(this).lastName());
        title.setText(Factory.FakeIt.name(this).title());
        userName.setText(Factory.FakeIt.name(this).userName());
    }
}
