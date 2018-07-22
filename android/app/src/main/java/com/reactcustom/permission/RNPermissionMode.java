package com.reactcustom.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableNativeMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RNPermissionMode extends ReactContextBaseJavaModule {
    private static final String TAG = RNPermissionMode.class.getSimpleName();

    private static final String ERROR_ACTIVITY_DO_NOT_EXITS="ERROR_ACTIVITY_DO_NOT_EXITS";

    private static HashMap<Integer, Promise> requestPromises = new HashMap<>();
    private static HashMap<Integer, WritableNativeMap> requestResults = new HashMap<>();

    public RNPermissionMode(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return TAG+"Android";
    }
    @ReactMethod
    public void requestPermission(final ReadableArray permissArray, final int reqCode,
                                  final Promise promise){
        Activity currentActivity = getCurrentActivity();
        if (null == currentActivity){
            promise.reject(ERROR_ACTIVITY_DO_NOT_EXITS,"actitity does not exits");
        }

        WritableNativeMap q =new WritableNativeMap();
        List<String> permList = new ArrayList<>();
        for (int i=0;i<permissArray.size();i++){
            if (PackageManager.PERMISSION_GRANTED
                    == ContextCompat.checkSelfPermission(currentActivity,permissArray.getString(i))){
                 permList.add(permissArray.getString(i));
                q.putBoolean(permissArray.getString(i),false);
            }else {
                q.putBoolean(permissArray.getString(i),true);
            }
        }
        if ( permList.size() > 0){
            requestPromises.put(reqCode,promise);
            requestResults.put(reqCode,q);

            String [] perms = permList.toArray(new String[permList.size()]);
            ActivityCompat.requestPermissions(currentActivity,perms,reqCode);
        }
    }
}
