import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.seutema.ui.theme.SeuTemaTheme

class MainAcitivity: AppcompatAtivity(){
  private lateint var binding : ActivityMainBindig;
  private viewModel: MainViewModel by viewModel();
  override fun onCreated (savadInstanceState: bundle?){
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel.usuario.observe(this){
      usuario?.let{
        binding.tvNome.text = "nome ${it.nome}"
        binding.tvIdade.text = "idade ${it.idade}"
      }
    }
    viewModel.carregarUsuario()
    
  }
}
