package com.lyricist;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class SplashScreenReactPackage extends ReactContextBaseJavaModule {
    private String tag = SplashScreenReactPackage.this.getName();

    SplashScreenReactPackage(ReactApplicationContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getName() {
        return "SplashScreen";
    }

    @ReactMethod
    public void hide() {
        boolean ended = Splash.end();
        if (!ended) Log.d(tag, "Splash Screen Activity didn't close!");

    }
}
