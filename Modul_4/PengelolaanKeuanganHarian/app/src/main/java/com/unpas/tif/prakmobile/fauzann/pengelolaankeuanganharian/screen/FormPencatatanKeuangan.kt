package com.unpas.tif.prakmobile.fauzann.pengelolaankeuanganharian.screen

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unpas.tif.prakmobile.fauzann.pengelolaankeuanganharian.model.KeuanganHarian
import com.unpas.tif.prakmobile.fauzann.pengelolaankeuanganharian.ui.theme.Purple700
import com.unpas.tif.prakmobile.fauzann.pengelolaankeuanganharian.ui.theme.Teal200

@Composable
fun FormPencatatanKeuangan(onSimpan: (KeuanganHarian) -> Unit) {
    val context = LocalContext.current
    val tanggal = remember { mutableStateOf(TextFieldValue("")) }
    val keterangan = remember { mutableStateOf(TextFieldValue("")) }
    val pemasukan = remember { mutableStateOf(TextFieldValue("")) }
    val pengeluaran = remember { mutableStateOf(TextFieldValue("")) }

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
            label = { Text(text = "Keterangan") },
            value = keterangan.value,
            onValueChange = {
                keterangan.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization =
                KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text
            ),
            placeholder = { Text(text = "keterangan") }
        )

        OutlinedTextField(
            label = { Text(text = "Pemasukan") },
            value = pemasukan.value,
            onValueChange = {
                pemasukan.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = { Text(text = "Rp.") }
        )

        OutlinedTextField(
            label = { Text(text = "Pengeluaran") },
            value = pengeluaran.value,
            onValueChange = {
                pengeluaran.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = { Text(text = "Rp.") }
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
                    if (tanggal.value.text.isNotEmpty() && keterangan.value.text.isNotEmpty() && pemasukan.value.text.isNotEmpty() || pengeluaran.value.text.isNotEmpty()) {
                        val keuanganHarian = KeuanganHarian(
                            tanggal = tanggal.value.text,
                            keterangan = keterangan.value.text,
                            pemasukan = pemasukan.value.text,
                            pengeluaran = pengeluaran.value.text
                        )

                        onSimpan(keuanganHarian)

                        tanggal.value = TextFieldValue("")
                        keterangan.value = TextFieldValue("")
                        pemasukan.value = TextFieldValue("")
                        pengeluaran.value = TextFieldValue("")
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