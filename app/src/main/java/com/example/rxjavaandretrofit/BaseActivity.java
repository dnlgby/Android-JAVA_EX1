package com.example.rxjavaandretrofit;

import android.widget.Toast;

import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity extends DaggerAppCompatActivity {

    public void showLongToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    public void showShortToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(int strId) {
        showLongToast(getString(strId));
    }

    public void showShortToast(int strId) {
        showShortToast(getString(strId));
    }
}
