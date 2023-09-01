package cl.awakelab.superheroes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.awakelab.superheroes.model.data.Repository
import cl.awakelab.superheroes.model.data.local.list.HeroDao
import cl.awakelab.superheroes.model.data.local.list.HeroDataBase
import cl.awakelab.superheroes.model.data.remote.list.RetrofitClient
import kotlinx.coroutines.launch

class HeroViewModel(application: Application): AndroidViewModel(application) {

    private val repository: Repository
    fun herosLiveData() = repository.getHeroEntity()
    fun heroDetailLiveData(id: Long) = repository.getHeroDetailEntity(id)

    init {
        val api = RetrofitClient.retrofitInstance()
        val heroDataBase: HeroDao = HeroDataBase.getDataBase(application).getHeroDao()
        repository = Repository(api, heroDataBase)
    }

    fun getHeroViewModel() = viewModelScope.launch { repository.getHeros() }
    fun getHeroDetailsViewModel(id: Long) = viewModelScope.launch {
        repository.getHeroDetails(id)
    }

}