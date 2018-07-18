import {Button, Text, TextInput, View,Dimensions,StyleSheet} from "react-native";
import React from "react";



const widthOfMargin = Dimensions.get('window').width*0.05

export class SetStateProcess extends React.Component{
    static navigationOptions = {
        title: 'SetStateProcess',
    };
    constructor(props){
        super(props);
        this.state={
            inputedNum:'',
            inputedPW:''
        };
        this.updatePW = this.updatePW.bind(this);
    }
    updateNum(newText){
        this.setState((state) =>{
            return{
                inputedNum:newText,
            };
        });
    }
    updatePW(newText){
        this.setState(() =>{
           return{
               inputedPW:newText,
           };
        });
    }
    render() {
        const { navigation } = this.props;
        const itemId = navigation.getParam('itemId','NO_ID_set');
        const otherParam = navigation.getParam('otherParam','some default value set');
        const transTitle = navigation.getParam('title',"NO-title-set");
        return (
            <View style={styles.container}>
                <TextInput style={styles.textInputStyle}
                           placeholder={'Pls input Phone number:'}
                           onChangeText={(newText) => this.updateNum(newText)}
                />
                <Text style={styles.textPromptStyle}>
                    Pls input Number
                </Text>
                <TextInput style={styles.textInputStyle}
                           paceholder={'Pls input password'}
                           secureTextEntry={true}
                           onChangeText={this.updatePW}
                />
                <Text style={styles.bigTextPrompt} >
                    Confirm
                </Text>
                <Text>
                    {this.state.inputedPW}
                </Text>
                <Text>
                    {this.state.inputedNum}
                </Text>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container:{
        flex:1,
        backgroundColor:"#FFFFFF"
    },
    textInputStyle:{
        margin:widthOfMargin,
        backgroundColor:'gray',
        fontSize:20,
    },
    textPromptStyle:{
        margin:widthOfMargin,
        fontSize:20,
    },
    bigTextPrompt:{
        margin:widthOfMargin,
        backgroundColor:'gray',
        color:'white',
        textAlign:'center',
        fontSize:30
    },
});
