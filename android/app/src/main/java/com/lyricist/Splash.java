package com.lyricist;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;


public class Splash extends AppCompatActivity {
    private static AppCompatActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity = this;
        this.launchMainActivity();
    }

    private void checkForUpdate() {
        String releaseURL = "https://api.github.com/repos/abh80/lyricist/releases";
    }

    public static boolean end() {
        if (activity != null) {
            activity.finish();
            return true;
        } else
            return false;
    }

    private void launchMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        activity.startActivity(intent);
    }

}
