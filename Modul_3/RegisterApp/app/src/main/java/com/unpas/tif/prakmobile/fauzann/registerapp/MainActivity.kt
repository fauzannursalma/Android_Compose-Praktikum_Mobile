package com.unpas.tif.prakmobile.fauzann.registerapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unpas.tif.prakmobile.fauzann.registerapp.ui.theme.Purple700
import com.unpas.tif.prakmobile.fauzann.registerapp.ui.theme.RegisterAppTheme
import com.unpas.tif.prakmobile.fauzann.registerapp.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegisterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FormRegister()
                }
            }
        }
    }
}

@Composable
fun FormRegister() {
    val context = LocalContext.current
    val name = remember { mutableStateOf(TextFieldValue("")) }
    val telephone = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val address = remember { mutableStateOf(TextFieldValue("")) }
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Name", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = name.value, onValueChange = { name.value = it }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Telephone", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = telephone.value, onValueChange = { telephone.value = it }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Address", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = address.value, onValueChange = { address.value = it }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Email", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = email.value, onValueChange = { email.value = it }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Username", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = username.value, onValueChange = { username.value = it }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Password", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { password.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )

        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )

        Divider(
            modifier = Modifier
                .weight(1f)
                .width(0.dp)
        )

        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Button(modifier = Modifier.weight(5f), onClick = {
                if (name.value.text.isEmpty() || telephone.value.text.isEmpty() || address.value.text.isEmpty() || email.value.text.isEmpty() || username.value.text.isEmpty() || password.value.text.isEmpty()) {
                    Toast.makeText(context, "Please fill all the form", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Register Success", Toast.LENGTH_SHORT).show()
                    Toast.makeText(context, "Halo ${name.value.text}", Toast.LENGTH_SHORT).show()
                }

            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }

            Button(modifier = Modifier.weight(5f), onClick = {
                name.value = TextFieldValue("")
                telephone.value = TextFieldValue("")
                address.value = TextFieldValue("")
                email.value = TextFieldValue("")
                username.value = TextFieldValue("")
                password.value = TextFieldValue("")
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
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RegisterAppTheme {
        FormRegister()
    }
}