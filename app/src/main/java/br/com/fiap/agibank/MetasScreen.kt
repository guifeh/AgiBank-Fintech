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
fun MetasScreen(navController: NavHostController) {
    var progressoMeta by remember { mutableStateOf(0.4f) } // Progresso fictício

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Barra superior com título e botão de perfil
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Metas Financeiras", fontSize = 24.sp, color = Color(0xFF0267FF))
            IconButton(onClick = { navController.navigate("perfil") }) {
                Icon(
                    painter = painterResource(id = R.drawable.profile_icon),
                    contentDescription = "Perfil",
                    modifier = Modifier.size(32.dp).clip(CircleShape)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Acompanhe suas metas financeiras", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(16.dp))

        // Barra de progresso da meta
        Text("Economizar R$ 10.000 para Emergências")
        LinearProgressIndicator(
            progress = progressoMeta,
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp),
            color = Color(0xFF0267FF)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("40% Concluído", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(8.dp))
        // Barra de progresso da meta
        Text("Entrada em um carro R$ 20.000")
        LinearProgressIndicator(
            progress = progressoMeta,
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp),
            color = Color(0xFF0267FF)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("30% Concluído", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        // Botão de adicionar meta
        Button(
            onClick = { /* Processar os valores inseridos */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0267FF))
        ) {
            Text("Adicionar meta", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão de navegação de volta ao orçamento
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