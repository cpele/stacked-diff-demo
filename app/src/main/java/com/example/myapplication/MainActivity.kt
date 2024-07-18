package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                var currentScreen by remember {
                    mutableStateOf(com.example.myapplication.Screen.First)
                }

                when (currentScreen) {
                    com.example.myapplication.Screen.First -> Greeting(
                        name = "Android squad",
                        modifier = Modifier.padding(innerPadding),
                    ) {
                        currentScreen = it
                    }

                    com.example.myapplication.Screen.Second -> SecondScreen()
                }

            }
        }
    }
}

enum class Screen {
    First, Second
}

@Composable
fun SecondScreen() {
    Text("This is the second screen")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, goTo: (Screen) -> Unit) {
    Column {
        val context = LocalContext.current
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = {
            Toast.makeText(context, "Well done! You clicked", Toast.LENGTH_SHORT).show()
            goTo(com.example.myapplication.Screen.Second)
        }) {
            Text("Click here")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting("Android") {}
}