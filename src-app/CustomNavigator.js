import { createStackNavigator } from "react-navigation";
import {HomeScreen} from "./HomeScreen";
import {DetailsScreen} from "./Details";
import {SetStateProcess} from "./UIRender/setStateProcess";
import {CameraInfoScreen} from './camera/cameraInfo';

export const CustomNavigator = createStackNavigator({
        Home: HomeScreen,
        Details: DetailsScreen,
        SetStateProcess: SetStateProcess,
        Camera: CameraInfoScreen,
    },
    {
        initialRouteName: 'Home',
    }
);
