package planets.data.repository

import planets.data.service.PlanetsService
import planets.domain.domain.Result
import kotlin.test.Test
import kotlin.test.assertTrue

class PlanetsRepositoryImplTest {

    @Test
    fun testGetPlanetsSuccess() {
        val service = PlanetsService()
        val repository = PlanetsRepositoryImpl(service)

        val result = repository.getPlanets()

        assertTrue(result is Result.Success, "Результат должен быть Success")

        val planets = (result as Result.Success).data
        assertTrue(planets.isNotEmpty(), "Список планет не должен быть пустым")
        assertTrue(planets.size == 8, "В солнечной системе должно быть 8 планет")
    }
}