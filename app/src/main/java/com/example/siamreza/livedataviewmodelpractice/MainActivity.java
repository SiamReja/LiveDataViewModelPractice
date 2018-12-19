package com.example.siamreza.livedataviewmodelpractice;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fetchBTN = findViewById(R.id.BTNfetchID);
        final TextView number = findViewById(R.id.TVnumber);
        final MainActivityObserver observerOBJ = ViewModelProviders.of(this).get(MainActivityObserver.class);
        final LiveData<String> myRandomNumber = observerOBJ.getNumber();

        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String string) {
                number.setText(string);
                Log.i(TAG, "Data Updated");
            }
        });

        fetchBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observerOBJ.createNumber();
            }
        });

        Log.i(TAG, "Random Number Set");
    }
}
