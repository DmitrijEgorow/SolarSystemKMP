package planets.data.repository

import planets.data.Result
import planets.data.service.PlanetsService
import planets.domain.domain.Planet
import planets.domain.repository.PlanetsRepository

class PlanetsRepositoryImpl(
    private val service: PlanetsService,
) : PlanetsRepository {

    override fun getPlanets(): Result<List<Planet>> {
        return try {
            val planets = service.getPlanets()
            Result.Success(planets)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override fun getPlanetById(planetId: Int): Result<Planet?> {
        return try {
            val planet = service.getPlanetById(planetId)
            Result.Success(planet)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}