/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import { NativeModules } from 'react-native';


const instructions = Platform.select({
    ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
    android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

export class HomeScreen extends React.Component{
    static navigationOptions = {
        title: 'HomeScreen',
    };
    render(){
        return(
            <View  style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
                <Text>Welcome to React Native!</Text>
                <Text>To get started, edit App.js</Text>
                <Button
                    style={styles.button}
                    title="Details"
                    onPress={() => this.props.navigation.navigate('Details',{
                        itemId: 89,
                        otherParam: 'anything you want here',
                    })}
                />
                <Button
                    title="Go to SetStateProcess"
                    onPress={() => this.props.navigation.navigate('SetStateProcess')}
                />
                <Button
                    title="Android Toast"
                    onPress={this.dealAndroidOriginToast}
                />
            </View>
        );
    }
    dealAndroidOriginToast(){
        console.log("dealAndroidOriginToast..");
        NativeModules.ToastModuleCustom.showAndroid("From RN",NativeModules.ToastModuleCustom.SHORT);
        NativeModules.CustomCameraInterface.callCamera();
    }
}

const styles = StyleSheet.create({
    button:{
        flex:1,
        justifyContent:'center',
    }
})
