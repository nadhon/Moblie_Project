package com.example.myapplication
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TasksViewModel : ViewModel(){
    private val _uiState = MutableStateFlow<UiStates<List<String>>>(UiState.Loading)

    val uiState = _uiState.asStateFlow()
    init {
        fetchTasks()
    }

    fun refreshTasks() {
        fetchTasks()
    }
    private fun fetchTasks() {
        viewModelScope.launch{
            _uiState.value = UiState.Loading
            try{
                delay(2000)
                if (System.currentTimeMillis() % 2 == 0L) {
                    throw Exception("Falha ao conectar com o servidor.")
                }
                val tasks = listOf("Compra pão","Estudar MVVM","Passear com o cachorro")
                _uiState.value = UiState.Sucess(tasks)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Erro desconhecido")
            }
        }
    }
}