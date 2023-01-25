package com.fuka.livedata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.fuka.livedata.ui.theme.LiveDataTheme

class MainActivity : ComponentActivity() {
    private val model: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val deviceList = remember {
                mutableStateListOf<String>()
            }

            val names = remember {
                //model.currentNames.observeAsState()
            }

            LiveDataTheme {
                // A surface container using the 'background' color from the theme
                Column {

                    Button(onClick = { model.print() }) {
                        Text(text = "print currentName")
                    }

                    Divider()

                    Button(onClick = { deviceList.add("fuka") }) {
                        Text(text = "add")
                    }

                    Divider()
                    Text(text = deviceList.size.toString())
                    Divider()

                    LazyColumn {
                        items(deviceList) { item ->
                            Text(text = item)
                        }
                    }

                    Divider()


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LiveDataTheme {
        Greeting("Android")
    }
}