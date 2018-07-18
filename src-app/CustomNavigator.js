import { createStackNavigator } from "react-navigation";
import {HomeScreen} from "./HomeScreen";
import {DetailsScreen} from "./Details";
import {SetStateProcess} from "./UIRender/setStateProcess";

export const CustomNavigator = createStackNavigator({
        Home: HomeScreen,
        Details: DetailsScreen,
        SetStateProcess: SetStateProcess,
    },
    {
        initialRouteName: 'Home',
    }
);
