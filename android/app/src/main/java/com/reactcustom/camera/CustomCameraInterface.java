package com.reactcustom.camera;


import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CustomCameraInterface extends ReactContextBaseJavaModule {
    private static final String TAG = CustomCameraInterface.class.getSimpleName();
    public CustomCameraInterface(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return CustomCameraInterface.class.getSimpleName();
    }
    @ReactMethod
    public void callCamera(){
        Log.d(TAG,"callCamera");
        Toast.makeText(getReactApplicationContext(),"CallCamera",Toast.LENGTH_SHORT).show();
    }
}
