import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.seutema.ui.theme.SeuTemaTheme


sealed class UIStateUser{
  object Loading : UIStateUser(){
    data class Sucess(val user : User) : UIStateUser()
    data class Erro(val mensagem: String) UIStateUser()
}
