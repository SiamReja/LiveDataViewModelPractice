package com.example.siamreza.livedataviewmodelpractice;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class MainActivityObserver extends ViewModel {

    private String TAG = this.getClass().getSimpleName();
    private MutableLiveData<String> randomNumber;

    public MutableLiveData<String> getNumber() {
        Log.i(TAG, "Get number");
        if (randomNumber == null) {
            randomNumber = new MutableLiveData<>();
            createNumber();
        }
        return randomNumber;
    }

    public void createNumber() {
        Log.i(TAG, "Create new number");
        Random random = new Random();
        randomNumber.setValue("Number: " + (random.nextInt(10 - 1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }
}
