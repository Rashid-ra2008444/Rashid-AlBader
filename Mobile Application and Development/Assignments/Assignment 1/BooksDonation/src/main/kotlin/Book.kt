import java.util.*
import kotlinx.serialization.Serializable

@Serializable

data class Book (
    val id: Int,
    val title: String,
    var isbn: String? = null,
    val pageCount: Int,
    val publishedDate: PublishedDate? = null,
    val thumbnailUrl: String? =null,
    val shortDescription: String? = null,
    val longDescription: String? = null,
    val status: String?,
    val authors: List<String>,
    val categories: List<String>
)