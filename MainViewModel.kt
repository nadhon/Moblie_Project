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
