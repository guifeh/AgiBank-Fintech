package br.com.fiap.agibank

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun GestaoScreen(navController: NavHostController) {
    val dividas = listOf(
        "Cartão de Crédito" to 1200f,
        "Empréstimo Pessoal" to 5000f,
        "Financiamento Carro" to 20000f
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Gestão de Dívidas", fontSize = 24.sp, color = Color(0xFF0267FF))
            IconButton(
                onClick = { navController.navigate("perfil") },
                modifier = Modifier
                    .clip(CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.profile_icon),
                    contentDescription = "Perfil",
                )
            }
        }

        Text("Acompanhe suas dívidas e seus pagamentos", fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))

        dividas.forEach { (nome, valor) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(nome, fontSize = 18.sp, color = Color.Black)
                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator(progress = valor / 20000f, modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Restante: R$ ${valor}", fontSize = 14.sp, color = Color.Gray)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Processar os valores inseridos */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0267FF))
        ) {
            Text("Adicionar dívida", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("orcamento") },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0267FF))
        ) {
            Text("Voltar para orçamento", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}
