package com.unpas.tif.prakmobile.fauzann.pengelolaankeuanganharian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.unpas.tif.prakmobile.fauzann.pengelolaankeuanganharian.screen.PengelolaanKeuanganHarian
import com.unpas.tif.prakmobile.fauzann.pengelolaankeuanganharian.ui.theme.PengelolaanKeuanganHarianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PengelolaanKeuanganHarianTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PengelolaanKeuanganHarian()
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
    PengelolaanKeuanganHarianTheme {
        PengelolaanKeuanganHarian()
    }
}