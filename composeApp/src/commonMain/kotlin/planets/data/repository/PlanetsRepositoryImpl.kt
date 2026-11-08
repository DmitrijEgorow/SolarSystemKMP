package planets.data.repository

import planets.data.service.PlanetsService
import planets.domain.domain.Planet
import planets.domain.domain.Result
import planets.domain.repository.PlanetsRepository

class PlanetsRepositoryImpl(
    private val service: PlanetsService,
) : PlanetsRepository {

    override fun getPlanets(): Result<List<Planet>> {

        val isInternetEnabled = true

        if (!isInternetEnabled) {
            return Result.Error("Не удалось загрузить данные. Проверьте подключение к интернету.")
        }

        return try {
            val planets = service.getPlanets();
            Result.Success(planets);
        } catch (e: Exception) {
            Result.Error("Не удалось загрузить планеты. Проверьте интернет.", e);
        }

    }

    override fun getPlanetById(planetId: Int): Result<Planet?> {

        return try {
            val planet = service.getPlanetById(planetId);
            Result.Success(planet);
        } catch (e: Exception) {
            Result.Error("Не удалось загрузить планету", e);
        }

    }

}