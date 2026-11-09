package planets.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import getPlatform
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import planets.data.Result
import planets.domain.domain.Planet
import planets.domain.repository.PlanetsRepository

data class PlanetsState(
    val isLoading: Boolean = false,
    val planets: List<Planet> = emptyList(),
    val planet: Planet? = null,
    val error: String? = null // Поле для хранения текста ошибки
)

class PlanetsViewModel(
    private val planetsRepository: PlanetsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PlanetsState())
    val state = _state.asStateFlow()

    init {
        getPlanets()
    }

    private fun getPlanets() {
        viewModelScope.launch(getPlatform().dispatcherIO) {
            _state.update { it.copy(isLoading = true, error = null) }

            // Обрабатываем наш Result
            when (val result = planetsRepository.getPlanets()) {
                is Result.Success -> {
                    _state.update { it.copy(isLoading = false, planets = result.data) }
                }
                is Result.Error -> {
                    _state.update { it.copy(isLoading = false, error = "Ошибка загрузки. Проверьте интернет.") }
                }
            }
        }
    }

    fun getPlanetById(planetId: Int) {
        viewModelScope.launch(getPlatform().dispatcherIO) {
            when (val result = planetsRepository.getPlanetById(planetId)) {
                is Result.Success -> {
                    _state.update { it.copy(planet = result.data) }
                }
                is Result.Error -> {
                    _state.update { it.copy(error = "Ошибка загрузки планеты.") }
                }
            }
        }
    }
}