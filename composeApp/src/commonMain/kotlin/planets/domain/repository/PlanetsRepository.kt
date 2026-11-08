package planets.domain.repository

import planets.domain.domain.Planet
import planets.domain.domain.Result

interface PlanetsRepository {
    fun getPlanets(): Result<List<Planet>>
    fun getPlanetById(planetId: Int): Result<Planet?>
}