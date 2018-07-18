/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import { createStackNavigator } from 'react-navigation';

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
                    title="Go to Details"
                    onPress={() => this.props.navigation.navigate('Details',{
                        itemId: 86,
                        otherParam: 'anything you want here',
                    })}
                />
            </View>
        );
    }
}
