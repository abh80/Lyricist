import React from 'react';
import {NativeModules} from 'react-native';

import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import Home from './screens/Home';
import {DefaultTheme, NavigationContainer} from '@react-navigation/native';

export default function App() {
  const bottomTabNavigator = createBottomTabNavigator();
  React.useEffect(() => {
    NativeModules.SplashScreen.hide();
  }, []);
  return (
    <NavigationContainer
      theme={{
        ...DefaultTheme,
        colors: {
          background: '#202020',
        },
      }}>
      <bottomTabNavigator.Navigator
        initialRouteName="Home"
        screenOptions={{
          labelStyle: {fontSize: 18},
        }}>
        <bottomTabNavigator.Screen name="Home" component={Home} />
        <bottomTabNavigator.Screen name="ome" component={Home} />
      </bottomTabNavigator.Navigator>
    </NavigationContainer>
  );
}
