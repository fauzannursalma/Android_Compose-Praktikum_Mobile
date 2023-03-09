package com.unpas.tif.prakmobile.fauzann.setoransampah.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unpas.tif.prakmobile.fauzann.setoransampah.model.SetoranSampah
import com.unpas.tif.prakmobile.fauzann.setoransampah.ui.theme.Purple700
import com.unpas.tif.prakmobile.fauzann.setoransampah.ui.theme.Teal200


@Composable
fun FormPencatatanSampah(onSimpan: (SetoranSampah) -> Unit) {
    val tanggal = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val berat = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {

        OutlinedTextField(
            label = { Text(text = "Tanggal") },
            value = tanggal.value,
            onValueChange = {
                tanggal.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "yyyy-mm-dd") }
        )

        OutlinedTextField(
            label = { Text(text = "Nama") },
            value = nama.value,
            onValueChange = {
                nama.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization =
                KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text
            ),
            placeholder = { Text(text = "XXXXX") }
        )

        OutlinedTextField(
            label = { Text(text = "Berat") },
            value = berat.value,
            onValueChange = {
                berat.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = { Text(text = "XXXXX") }
        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )

        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )

        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Button(
                modifier = Modifier
                    .weight(5f),
                onClick = {
                    val item = SetoranSampah(tanggal.value.text, nama.value.text,
                        berat.value.text)
                    onSimpan(item)
                    tanggal.value = TextFieldValue("")
                    nama.value = TextFieldValue("")
                    berat.value = TextFieldValue("")
                },
                colors = loginButtonColors
            ) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }

        }

    }
}
