package com.unpas.tif.prakmobile.fauzann.setoransampah.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.benasher44.uuid.uuid4
import com.unpas.tif.prakmobile.fauzann.setoransampah.ui.theme.Purple700
import com.unpas.tif.prakmobile.fauzann.setoransampah.ui.theme.Teal200
import kotlinx.coroutines.launch

@Composable
fun FormPencatatanSampah() {

    val viewModel = hiltViewModel<PengelolaanSampahViewModel>()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val tanggal = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val berat = remember { mutableStateOf(TextFieldValue("")) }

    val isLoading = remember { mutableStateOf(false) }
    val buttonLabel = if (isLoading.value) "Mohon tunggu..." else
        "Simpan"

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
            placeholder = { Text(text = "nama") }
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
            placeholder = { Text(text = "Kg") }
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
                    val id = uuid4().toString()
                    if (tanggal.value.text.isNotEmpty() && nama.value.text.isNotEmpty() && berat.value.text.isNotEmpty()) {
                        scope.launch {
                            viewModel.insert(tanggal.value.text, nama.value.text,
                                berat.value.text)
                            Toast.makeText(context,
                                "Data berhasil disimpan",
                                Toast.LENGTH_SHORT
                            ).show()

                            tanggal.value = TextFieldValue("")
                            nama.value = TextFieldValue("")
                            berat.value = TextFieldValue("")
                        }
                    } else {
                        Toast.makeText(context,
                            "Data tidak boleh kosong",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                colors = loginButtonColors
            ) {
                Text(
                    text = buttonLabel,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }

            Button(modifier = Modifier.weight(5f), onClick = {
                tanggal.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                berat.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }

    viewModel.isLoading.observe(LocalLifecycleOwner.current) {
        isLoading.value = it
    }
}