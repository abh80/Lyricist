import React from 'react';
import {View, Text, StyleSheet} from 'react-native';

export default function Home() {
  return (
    <View>
      <Text style={styles.section_header}>Trending</Text>
      <View style={styles.section_hr} />
    </View>
  );
}

const styles = StyleSheet.create({
  section_header: {
    fontSize: 24,
  },
  section_hr: {
    width: '100%',
    height: 1,
    marginTop: 1,
    backgroundColor: '#ffffff',
  },
});
