package com.manindertaggar.toddssyndrome.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.storage.Pref;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etName)
    EditText etName;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbinder.unbind();
    }

    @OnClick(R.id.tvStart)
    public void onStartPressed() {
        String name = etName.getText().toString();
        if (name == null || name.isEmpty()) {
            etName.setError("Please your name");
            return;
        }

        Pref.getInstance().setName(name);
        Pref.getInstance().setIsLoggedIn(true);

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
