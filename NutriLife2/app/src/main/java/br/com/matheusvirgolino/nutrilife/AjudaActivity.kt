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


class AjudaActivity : ComponentActivity() {
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

                    AjudaButtonsScreen()
                }
            }
        }
    }
}

@Composable
fun AjudaButtonsScreen() {
    val profiles = listOf(
        Profile("Perfil", R.drawable.icon_perfil, "Resolva problemas de perfil com facilidade aqui!"),
        Profile("Perguntas frequentes (FAQ)", R.drawable.ponto_de_interrogacao, "Encontre respostas para perguntas mais comuns em nossa seção de perguntas frequentes (FAQ)."),
        Profile("Contato de suporte", R.drawable.ligacao_de_emergencia, "Estamos aqui para ajudar! Entre em contato com nossa equipe de suporte."),
        Profile("Como atualizar informações do plano alimentar", R.drawable.atualizar, "Atualize seu plano alimentar com facilidade e ajuste suas preferências conforme necessário.")
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
            text = "Ajuda ao Usuário",
            style = TextStyle(
                fontSize = 25.sp,
            ),
            textAlign = TextAlign.Center

        )

        profiles.forEach { profile ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp) // Ajuste a altura conforme necessário
                    .background(Color(0xFF41855C), RoundedCornerShape(16.dp))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Icon(
                        painter = painterResource(id = profile.iconRes),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = profile.name,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                        Text(
                            text = profile.description,
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}

data class Profile(val name: String, val iconRes: Int, val description: String)



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AjudalPreview() {
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
                AjudaButtonsScreen()
            }
        }


    }
}
