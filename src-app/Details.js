import React from 'react';
import { View, Text, Button} from 'react-native';


export  class DetailsScreen extends React.Component {
    static navigationOptions = {
        title: 'DetailsScreen',
    };
    render() {
        const { navigation } = this.props;
        const itemId = navigation.getParam('itemId','NO_ID');
        const otherParam = navigation.getParam('otherParam','some default value');
        const transTitle = navigation.getParam('title',"NO-title");
        return (
            <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
                <Text>Details Screen</Text>
                <Text>itemId: {JSON.stringify(itemId)}</Text>
                <Text>otherParam: {JSON.stringify(otherParam)}</Text>
                <Text>otherParam: {JSON.stringify(transTitle)}</Text>
                <Button
                    title="Go to Home"
                    onPress={() => this.props.navigation.navigate('Home')}
                />
                <Button
                    title="Go back"
                    onPress={() => this.props.navigation.goBack()}
                />
                <Button
                    title="Go to Details... again"
                    onPress={() => this.props.navigation.push('Details',{
                        itemId:Math.floor(Math.random()*100)
                    })}
                />
            </View>
        );
    }
}
