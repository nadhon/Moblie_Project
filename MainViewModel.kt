class MainViewModel : ViewModel() {
    private val usuario = MutableLiveData<User>()
    val usuario: LiveData<Usuario> get() = _usuario


    fun carregarUsuario(){
        _usuario.value = User("helio", 40)
    }
    viewModel.usuario.observe(this)
}
