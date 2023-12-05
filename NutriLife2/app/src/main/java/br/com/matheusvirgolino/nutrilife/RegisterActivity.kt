@file:OptIn(ExperimentalMaterial3Api::class)

package br.com.matheusvirgolino.nutrilife

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriLifeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF41855C)
                ) {
                    Register(onRegisterClick = {
                        Log.i("RegisterActivity", "onRegister:$it")
                    })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(onRegisterClick: (User) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
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
                    fontSize = 54.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 40.dp)
            )

            var nome by remember { mutableStateOf("") }
            var sobrenome by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var senha by remember { mutableStateOf("") }

            TextField(
                value = nome,
                onValueChange = { nome = it },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                label = {
                    Text(text = "Nome")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Nome"
                    )
                }
            )
            TextField(
                value = sobrenome,
                onValueChange = { sobrenome = it },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                label = {
                    Text(text = "Sobrenome")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Sobrenome"
                    )
                }
            )
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
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email"
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
                    val user = User(nome, sobrenome, email, senha)
                    onRegisterClick(user)
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
            ) {
                Text(text = "Cadastrar-se")
            }
        }
    }
}

@Preview
@Composable
fun RegisterPreview() {
    NutriLifeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF41855C)
        ) {
            Register(onRegisterClick = {})
        }
    }
}
