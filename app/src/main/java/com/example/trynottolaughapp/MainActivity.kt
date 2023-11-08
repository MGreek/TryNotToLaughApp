package com.example.trynottolaughapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.trynottolaughapp.ui.theme.TryNotToLaughAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var filePickerLauncher: ActivityResultLauncher<String>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryNotToLaughAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        setContentView(R.layout.layout);
        filePickerLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
            if (it != null) {
                Log.d("Activity", "It worked");
            }
            else {
                Log.d("Activity", "It worked again")
            }
        }
    }

    fun onChooseVideo(view: View) {
        filePickerLauncher.launch("*/*")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TryNotToLaughAppTheme {
        Greeting("Android")
    }
}