package com.example.daggerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etUserName, etAge;
    Button btnSave, btnShow;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        // if we don't use dagger2 we have write below code for instantiate shareprefence with Mainactivity context this;
        // sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        //Injecting context with Dagger2, no need to create instance of Shareprefernces for every time;


        // DaggerMy component will generate according to Component class name
        // Supose you give name A of component class, Then generate class name should be DaggerA & it will extends A.

        MyComponent myComponent = DaggerMyComponent
                                 .builder().shareModule(new ShareModule(this))
                                 .build();

        myComponent.inject(this);

    }

    private void initViews() {
        btnShow = findViewById(R.id.btnShow);
        btnSave = findViewById(R.id.btnSave);
        etUserName = findViewById(R.id.etuserName);
        etAge = findViewById(R.id.etAge);
        btnSave.setOnClickListener(this);
        btnShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnShow:
                etUserName.setText(sharedPreferences.getString("username", "default"));
                etAge.setText(sharedPreferences.getString("age", "12345"));
                break;

            case R.id.btnSave:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", etUserName.getText().toString().trim());
                editor.putString("age", etAge.getText().toString().trim());
                editor.apply();
                break;

        }
    }
}