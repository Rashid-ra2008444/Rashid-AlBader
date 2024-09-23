import kotlinx.serialization.json.Json
import java.io.File

private val json = Json { ignoreUnknownKeys = true }

object CovidRepo {

    var covidData = listOf<CovidStat>()

    init {
        var data = File("data/covid-data.json").readText()
        covidData = Json { ignoreUnknownKeys=true } .decodeFromString(data)

    }
}

fun main(){

    CovidRepo.covidData.forEach{println(it)}
}

