/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';
import { createStackNavigator } from 'react-navigation';
import {DetailsScreen} from "./Details";
import {HomeScreen} from "./HomeScreen"
import {CustomNavigator} from "./CustomNavigator";

export default class  App extends React.Component{
    static navigationOptions = {
        title: 'HomeScreen',
    };
    render(){
        return(
            <CustomNavigator/>
        );
    }
}
