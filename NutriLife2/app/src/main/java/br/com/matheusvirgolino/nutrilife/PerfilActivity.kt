package br.com.matheusvirgolino.nutrilife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class PerfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriLifeTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                ) {
                    Toolbar(title = "NutriLife")

                    PerfilButtonsScreen()
                }
            }
        }
    }
}

@Composable
fun PerfilButtonsScreen() {
    val mealOptions = listOf(
        "Minhas Metas", "Visualizar Recompensas", "Editar Perfil", "Sair"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .padding(15.dp),
            text = "Meu Perfil",
            style = TextStyle(
                fontSize = 25.sp,
            ),
            textAlign = TextAlign.Center

        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFF41855C), RoundedCornerShape(16.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.icon_perfil),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))


                Text(
                    text = "Allyson Jerônimo",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
        }


        Spacer(modifier = Modifier.height(16.dp))


        mealOptions.forEach { mealOption ->
            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(bottom = 18.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF41855C),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = mealOption,
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PerfilPreview() {
    NutriLifeTheme {

        Scaffold(
            topBar = {
                Toolbar(title = "NutriLife")

            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                PerfilButtonsScreen()
            }
        }


    }
}
