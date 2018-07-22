package com.reactcustom.callback;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;

public class RNAndroidCallbackInterface extends ReactContextBaseJavaModule implements TaskReponse {
    private Promise mPromise;
    public RNAndroidCallbackInterface(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return RNAndroidCallbackInterface.class.getSimpleName();
    }
    @ReactMethod
    public void tackPicture(Callback errorCallback,
                            Callback successCallback){
        if (PackageManager.PERMISSION_GRANTED == ActivityCompat.
                checkSelfPermission(getReactApplicationContext(), Manifest.permission.CAMERA)){
            successCallback.invoke(RNAndroidCallbackInterface.class.getSimpleName(),
                    "Granted permission success");
        }else{
            errorCallback.invoke("Granted permission FAILED");
        }

    }
    @ReactMethod
    public void usePromise(Promise promise){
        mPromise = promise;
        LocalCalcTask task = new LocalCalcTask(this);
        task.execute();
    }

    @Override
    public void reponse(String msg) {
        WritableMap map = Arguments.createMap();
        map.putString("result",msg);
        mPromise.resolve(map);
    }
}
