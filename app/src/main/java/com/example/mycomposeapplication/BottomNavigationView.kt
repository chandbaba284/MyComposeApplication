package com.example.mycomposeapplication


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Preview
@Composable
fun BottomNavigationTab(navController : NavHostController) {

    var selectedTab by remember { mutableStateOf(0) }

   /* HomeNavController()*/

    MaterialTheme {
        when (selectedTab) {
            0 -> {
                navController.navigate("HomeScreen")
            }

            1 -> {
                navController.navigate("callScreen")

            }

            2 -> {
                navController.navigate("MusicScreen")
            }

            3 -> {
                navController.navigate("DriveScreen")
            }
        }
        Column(verticalArrangement = Arrangement.Bottom) {
            BottomNavigation(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.White
            ) {
                BottomNavigationItem(selected = selectedTab == 0,
                    onClick = {
                        selectedTab = 0
                    }, icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_home_24),
                            contentDescription = "tab1"
                        )

                    }, selectedContentColor = Color.Magenta, unselectedContentColor = Color.Blue


                )
                BottomNavigationItem(selected = selectedTab == 1,
                    onClick = {
                        selectedTab = 1
                    }, icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_call_24),
                            contentDescription = "tab1"
                        )

                    }, selectedContentColor = Color.Magenta, unselectedContentColor = Color.Blue
                )
                BottomNavigationItem(selected = selectedTab == 2,
                    onClick = {
                        selectedTab = 2
                    }, icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_album_24),
                            contentDescription = "tab1"
                        )

                    }, selectedContentColor = Color.Magenta, unselectedContentColor = Color.Blue
                )

                BottomNavigationItem(selected = selectedTab == 3,
                    onClick = {
                        selectedTab = 3
                    }, icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_to_drive_24),
                            contentDescription = "tab1"
                        )

                    }, selectedContentColor = Color.Magenta, unselectedContentColor = Color.Blue
                )
            }
        }

    }
}