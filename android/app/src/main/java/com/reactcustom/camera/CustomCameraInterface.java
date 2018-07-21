package com.reactcustom.camera;


import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CustomCameraInterface extends ReactContextBaseJavaModule {
    private static final String TAG = CustomCameraInterface.class.getSimpleName();

    private static final String IMAGE_PAHE = Environment.getExternalStorageDirectory().getAbsolutePath()+"/cp";
    private static final String IMAGE_PREX = "cp";

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
