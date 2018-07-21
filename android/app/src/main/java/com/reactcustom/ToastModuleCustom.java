package com.reactcustom;

import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class ToastModuleCustom extends ReactContextBaseJavaModule {
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public ToastModuleCustom(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ToastModuleCustom";
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String ,Object> contants = new HashMap<>();
        contants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        contants.put(DURATION_SHORT_KEY,Toast.LENGTH_SHORT);
        return  contants;
    }
    @ReactMethod
    public void showAndroid(String msg,int dur){
        Toast.makeText(getReactApplicationContext(),msg,dur).show();
    }
}
