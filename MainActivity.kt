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
    lifecycleScope.lauch {
      viewModel.uiStateUser.collectLatest{ stateUser -> 
        whe(stateUser) {
          is UIStateUser.Loading -> {
            binding.tvNome.text = "carregando..."
            binding.tvIdade.text = ""
          }
          is UIStateUser.Sucess ->{
            binding.tvNome.text = 
            getString(R.string.lbl_nome,stateUser.nome)
            getString(R.string.lbl_idade,stateUser.idade)
          }
          is UIStateUser.Error -> {
            binding.tvNome.text = "Erro ${stateUser.msg}"
            binding.tvIdade.text = ""
          }
    }
    viewModel.carregarUsuario()
    
  }
}
