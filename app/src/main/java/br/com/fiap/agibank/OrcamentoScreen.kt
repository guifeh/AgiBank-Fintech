package br.com.fiap.agibank

import androidx.compose.foundation.background
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
fun OrcamentoScreen(navController: NavHostController) {
    var receitaMensal by remember { mutableStateOf("") }
    var alimentacao by remember { mutableStateOf("") }
    var lazer by remember { mutableStateOf("") }
    var transporte by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp)
    ) {
        // Cabeçalho
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Orçamento Pessoal",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0267FF)
            )
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

        Text(
            "Gerencie sua receita e suas despesas de forma eficiente!",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Formulário dentro de um Card para melhor estética
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                CustomOutlinedTextField(value = receitaMensal, onValueChange = { receitaMensal = it }, label = "Receita Mensal")
                CustomOutlinedTextField(value = alimentacao, onValueChange = { alimentacao = it }, label = "Alimentação")
                CustomOutlinedTextField(value = lazer, onValueChange = { lazer = it }, label = "Lazer")
                CustomOutlinedTextField(value = transporte, onValueChange = { transporte = it }, label = "Transporte")
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
            Text("Calcular Despesas", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botões de navegação
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            OutlinedButton(
                onClick = { navController.navigate("gestao") },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF0267FF))
            ) {
                Text("Gestão de Dívidas")
            }
            OutlinedButton(
                onClick = { navController.navigate("metas") },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF0267FF))
            ) {
                Text("Metas Financeiras")
            }
        }
    }
}

// Composable reutilizável para os campos de entrada
@Composable
fun CustomOutlinedTextField(value: String, onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp)
    )
}
