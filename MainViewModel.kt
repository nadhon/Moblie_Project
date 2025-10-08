import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.seutema.ui.theme.SeuTemaTheme

class MainViewModel : ViewModel() {
    private val usuario = MutableLiveData<User>()
    val usuario: LiveData<Usuario> get() = _usuario
    private val _uiaStateUser = MutableFlow<UIStateUser>(UIStateUser.Loading)
    val uiStateUser: StateFlow<UIStateUser> = _uiStateUser


    fun carregarUsuario(){
        _usuario.value = User("helio", 40)
        val usuario = User("helio",40)
        _usario.value = UIStateUser.Sucess(usuario)
    }
    viewModel.usuario.observe(this)
}
