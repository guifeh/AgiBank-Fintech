package br.com.fiap.agibank.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.fiap.agibank.CadastroScreen
import br.com.fiap.agibank.GestaoScreen
import br.com.fiap.agibank.LoginScreen
import br.com.fiap.agibank.MetasScreen
import br.com.fiap.agibank.OrcamentoScreen
import br.com.fiap.agibank.PerfilScreen


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("cadastro") { CadastroScreen(navController) }
        composable("orcamento") { OrcamentoScreen(navController) }
        composable("gestao") { GestaoScreen(navController) }
        composable("metas") { MetasScreen(navController) }
        composable("perfil") { PerfilScreen(navController) }
    }
}