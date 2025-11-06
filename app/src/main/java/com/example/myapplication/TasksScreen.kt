package com.example.myapplication
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.unit.dp
import androidx.lifecycle.ViewModel.compose.viewModel

@Composable
fun TasksScreen(tasksViewModel: TasksViewModel = viewModel()) {
    val uiState by tasksViewModel.uiState.collectAsState()
    when (val state =uiState) {
        is UiState.Loading -> {
            LoadingComponent()
        }
        is UiState.Sucess -> {
            TasksListComponent(tasls = state.data) {
                tasksViewModel.refreshTasks()
            }
        }
        is UiState.Error -> {
            ErrorComponent(menssage = state.message) {
                tasksViewModel.refreshTasks()
            }
        }
    }
}
@Composable
fun LoadingComponent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment =Aligment.Center){
        CircularProgressIndicator()
    }
}
@Composable
fun TasksListComponent(tasks: List<String>, onRefreshClik: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Text("Minhas Tarefas", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onCLick = onRetryClick){
            Text("Tentar Novamente")
        }
    }
}