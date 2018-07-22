import  React from 'react';
import {View, StyleSheet, Button, Image} from "react-native";
import CustomCameraInterface from '../plugin/RNAndroidCamera';

export  class CameraInfoScreen extends React.Component{
    static navigationOptions = {
        title: 'CameraInfoScreen',
    };
    constructor(props) {
        super(props);
        this.state = {
            pickerImageUri:""
        }
        //this.dealPickImage = this.dealPickImage.bind(this);
    }

    render() {
        return(
            <View style={styles.container}
            >
                <Button style={styles.takeBtn}
                        title="This is Camera page"
                        onPress={()=>this.dealPickImage()}
                />
                <Image
                    style={{width: 196, height: 100}}
                    source={{uri:this.state.pickerImageUri}}
                />
            </View>
        );
    };
    dealPickImage(){
        CustomCameraInterface.pickImage((uri)=>{
            this.setState({
                pickerImageUri:uri
            });
            // this.setState({pickerImageUri: uri},
            //     ()=>{
            //         console.log(this.state.pickerImageUri);
            //     })
        });
    }
}

const styles = StyleSheet.create({
    container:{
        flex:1,
        // justifyContent: 'center',
        alignItems:'center',
    },
    takeBtn:{
        backgroundColor:"#FF0000",
        justifyContent:'center',
        marginTop:5
    },
    imageShow:{
        width:50,
        height:60,
    }
});