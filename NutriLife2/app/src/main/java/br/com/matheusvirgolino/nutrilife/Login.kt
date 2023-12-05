@file:OptIn(ExperimentalMaterial3Api::class)

package br.com.matheusvirgolino.nutrilife

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.matheusvirgolino.nutrilife.model.User
import br.com.matheusvirgolino.nutrilife.ui.theme.NutriLifeTheme




class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriLifeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF41855C) // Defina a cor desejada aqui
                ) {
                    NutriLife(onEnterClick = {
                        Log.i("ManiActivy", "onCreate:$it")
                    })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NutriLife(onEnterClick: (User) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "NutriLife",
            style = TextStyle(
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ),
            modifier = Modifier.padding(bottom = 40.dp)
        )

        var email by remember { mutableStateOf("") }
        var senha by remember { mutableStateOf("") }

        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Usuario"
                )
            }
        )
        TextField(
            value = senha,
            onValueChange = { senha = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            label = {
                Text(text = "Senha")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Password,
                    contentDescription = "Senha"
                )
            }
        )
        Button(
            onClick = {
               // val user = User(email, senha)
                //onEnterClick(user)
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            Text(text = "Entrar")
        }
        TextButton(
            onClick = {

            },
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()

            ) {
            Text(
                text = "Cadastrar-se",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.White
                )
            )



        }
    }
}

@Preview
@Composable
fun NutriLifePreview() {
    NutriLifeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF41855C) // Defina a cor desejada aqui
        ) {
            NutriLife(onEnterClick = {})
        }
    }
}
