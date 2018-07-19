import React from "react";
import {Text, View} from "react-native";


export default class WaitingLeaf extends Component{

    constructor(props){
        super(props);
    }
    render(){
        return(
            <View style={styles.container} >
                <Text style={styles.textPromptStyle} >
                    Login via Phone:{this.props.phoneNumber}
                </Text>
                <Text style={styles.textPromptStyle} >
                    Login via Password:{this.props.userPW}
                </Text>
                <Text style={styles.bigTextPrompt}
                      onPress={()=>this.onGobackPressed()}  >
                    RETURN
                </Text>

            </View>
        );
    }
    onGobackPressed(){
        this.props.onGobackPressed();
    }
}

const styles = StyleSheet.create({
    container:{
        flex:1,
        justifyContent:'center',
        alignItems:'center',
        backgroundColor:'#F5FCFF',
    },
    textPromptStyle:{
        fontSize:20,
    },
    bigTextPrompt:{
        width:300,
        backgroundColor:'gray',
        color:'white',
        textAlign:'center',
        fontSize:60,
    }
});