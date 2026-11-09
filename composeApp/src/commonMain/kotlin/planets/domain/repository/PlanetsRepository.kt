package planets.domain.repository

import planets.data.Result
import planets.domain.domain.Planet

interface PlanetsRepository {
    fun getPlanets(): Result<List<Planet>>
    fun getPlanetById(planetId: Int): Result<Planet?>
}