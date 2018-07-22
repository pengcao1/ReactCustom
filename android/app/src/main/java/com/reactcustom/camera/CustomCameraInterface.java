package com.reactcustom.camera;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.io.File;
import java.util.Calendar;

public class CustomCameraInterface extends ReactContextBaseJavaModule {
    private static final String TAG = CustomCameraInterface.class.getSimpleName();

    private static final String IMAGE_PAHE = Environment.getExternalStorageDirectory().getAbsolutePath() + "/cp";
    private static final String IMAGE_PREX = "cp";
    private Promise mPromise = null;
    private Callback mCallback = null;

    private static final int REQUEST_CODE_CAMERA = 0;
    private static final int REQUEST_CODE_GALLERY = 1;
    private static final int REQUEST_CODE_CROP = 2;

    private static final String ERROR_ACTIVITY_DOES_NOT_EXITS = "Activity Does not exits";
    private static final String ERROR_FAILED_TO_PICKER = "FAILED to picker";
    private static final String ERROR_PICKER_CANCELLED = "cancelled to picker";
    private static final String ERROR_PICKER_NOT_FOUND = "not found image";
    //private Promise m

    String[] PERMISSION = {
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    public CustomCameraInterface(ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext.addActivityEventListener(mActivityEventListener);
    }

    @Override
    public String getName() {
        return CustomCameraInterface.class.getSimpleName();
    }

    @ReactMethod
    public void callCamera() {
        Log.d(TAG, "callCamera1111");
        Toast.makeText(getReactApplicationContext(), "CallCamera", Toast.LENGTH_SHORT).show();
    }

    @ReactMethod
    public void callCameraWithPromise(Promise promise) {
        Log.d(TAG, "callCameraWithPromise");
        Toast.makeText(getReactApplicationContext(), "CallCamera111", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String mCurrentImagePat = IMAGE_PAHE + IMAGE_PREX + getCurrentImageName() + ".png";
        Uri uri = Uri.fromFile(new File(mCurrentImagePat));
        if (!isPatchExits()) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            Activity activity = getCurrentActivity();
            if (Build.VERSION.SDK_INT > 23) {
                activity.requestPermissions(PERMISSION, 1);
            }
            if (null != activity) {
                mPromise = promise;
                activity.startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        }
    }

    private boolean isPatchExits() {
        File file = new File(IMAGE_PAHE);
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.d(TAG, "file.exists=" + file.exists() + ",path=" + IMAGE_PAHE);
        return file.exists();
    }

    private String getCurrentImageName() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR) + "_"
                + c.get(Calendar.MONTH) + "_"
                + c.get(Calendar.DAY_OF_MONTH) + "_"
                + c.get(Calendar.HOUR_OF_DAY) + "_"
                + c.get(Calendar.MINUTE) + "_"
                + c.get(Calendar.SECOND);
    }

    @ReactMethod
    public void pickImage(Callback callback/*,final Promise promise*/) {
        mCallback = callback;
        Activity currentActivity = getCurrentActivity();
        if (null == currentActivity) {
            //promise.reject(ERROR_ACTIVITY_DOES_NOT_EXITS, "equals null");
            return;
        }
        //Store the Promise to resolve/reject when picker returns data
        //mPromise = promise;
        try {
            final Intent galleryIntent = new Intent(Intent.ACTION_PICK);
            galleryIntent.setType("image/*");
            final Intent chooserIntent = Intent.createChooser(galleryIntent, "picker a image");
            currentActivity.startActivityForResult(chooserIntent, REQUEST_CODE_GALLERY);
        } catch (Exception e) {
            //mPromise.reject(ERROR_FAILED_TO_PICKER, e);
            mPromise = null;
        }
    }

    private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {
        @Override
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
            Log.d(TAG,"requestCode="+requestCode+","+data.getData());
            if (REQUEST_CODE_GALLERY == requestCode) {
                if (null != mCallback) {
                    if (Activity.RESULT_CANCELED == resultCode) {
                        //mPromise.reject(ERROR_PICKER_CANCELLED, "Image picker cancelled");
                    } else if (Activity.RESULT_OK == resultCode) {
                        Uri uri = data.getData();
                        if (null == uri) {
                            //mPromise.reject(ERROR_PICKER_NOT_FOUND, "No image here");
                        } else {
                            //mPromise.resolve(uri.toString());
                            mCallback.invoke(uri.toString());
                        }
                    }
                    //mPromise = null;
                }
            }
        }
    };
}

