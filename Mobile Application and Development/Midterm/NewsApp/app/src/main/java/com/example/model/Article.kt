import kotlinx.serialization.Serializable

//you are required to fix this class, I only put the name for you so it does not give error
@Serializable
class Article(
    val title : String,
    val article: String,
    val image : String,
    val category : String,
    val author : String,
    val date : String
)