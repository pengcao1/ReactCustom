import { createStackNavigator } from "react-navigation";
import {HomeScreen} from "./HomeScreen";
import {DetailsScreen} from "./Details";

export const CustomNavigator = createStackNavigator(
    {
        Home: HomeScreen,
        Details: DetailsScreen,
    },
    {
        initialRouteName: 'Home',
    }
);
