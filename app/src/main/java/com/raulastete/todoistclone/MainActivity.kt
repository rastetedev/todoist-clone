package com.raulastete.todoistclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.raulastete.todoistclone.presentation.navigation.NavigationGraph
import com.raulastete.todoistclone.presentation.navigation.Route
import com.raulastete.todoistclone.presentation.theme.TodoistCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoistCloneTheme {

                val rootNavController = rememberNavController()

                NavigationGraph(
                    navController = rootNavController,
                    //TODO: Implement Logic to show Login Navigation or Main Destination
                    startDestination = Route.Main
                )
            }
        }
    }
}