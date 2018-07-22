'use strict';
/**
 * This exposes the native CallBack module as a JS module. This has a function 'tackPicture'
 * which takes the following parameters:
 *
 * 1. errorCallback: try to check weather obtain CAMERA permission,if not,invoke errorCallback,otherwise invoke success
 */
import { NativeModules } from 'react-native';

export default NativeModules.RNAndroidCallbackInterface;
