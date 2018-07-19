import React, {Component} from 'react';
import { BackHandler,Platform } from 'react-native';
import {LoginLeaf} from "./LoginLeaf";

export default class NaviModule extends Component{
    constructor(props){
        super(props);
        this.state = {
            currentScreen:'Login',
            phoneNumber:'',
            userPW:''
        };
        this.handleBackSignal = this.handleBackSignal.bind(this);
        this.onLoginPressed =  this.onLoginPressed.bind(this);
    }
    onLoginPressed(aNumber,aPW){
        this.setState({
            currentScreen:'Waiting',
            phoneNumber:aNumber,
            userPW:aPW
        });
    }
    render(){
        if (this.state.currentScreen === 'Login')
            return <LoginLeaf onLoginPressed={this.onLoginPressed} />;
    }
    handleBackSignal(){
        if (this.state.currentScreen ==='Waiting'){
            this.setState({currentScreen:'Login'});
            return true;
        }
        return false;
    }
    componentDidMount(){
        if (Platform.OS === 'android'){
            BackHandler.addEventListener('hardwareBackPress',this.handleBackSignal());
        }
    }
    componentWillUnmount(){
        if (Platform.OS === "android"){
            BackHandler.removeListener('hardwareBackPress',this.handleBackSignal());
        }
    }
}