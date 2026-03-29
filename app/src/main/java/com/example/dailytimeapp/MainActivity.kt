package com.example.dailytimeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailytimeapp.ui.theme.DailyTimeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyTimeAppTheme {
               var text by remember{mutableStateOf("") }
                var results by remember{mutableStateOf("") }
                Column() {
                    Text("DailyTime App")
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = {Text("Enter the time of day")}
                    )
                        Row() {
                            Button(
                                onClick = {
                                    results = when(text){
                                        "Morning"-> "Send a GoodMorning text"
                                        "Mid-morning"-> "Send a text to a friend"
                                        "Afternoon"-> "Send stickers to a sibling"
                                        "Mid-afternoon"-> "Make yourself some snack"
                                        "dinner"-> "Reach out to a friend and catch up"
                                        "Night"-> "Send a GoodNight message to family"
                                        else -> "invalid input"
                                    }
                                }
                            ){
                                Text("Suggest")
                            }
                            Button(
                                onClick = {
                                    text = ""
                                    results = ""
                                }
                            ){
                                Text("Reset")
                            }
                        }
                    Text (results)
                }
            }
        }
    }
}
