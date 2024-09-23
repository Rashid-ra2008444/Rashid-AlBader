package com.example.quickmart.repository

import android.app.Application
import com.example.quickmart.dataSource.local.QuickMartDB
import com.example.quickmart.model.Category
import com.example.quickmart.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class ProductRepository(appContext : Application) {

    private val categoryDao by lazy { QuickMartDB.getDatabase(appContext).categoryDao()}
    private val productDao by lazy { QuickMartDB.getDatabase(appContext).productDao()}


    fun getAllProduct(): Flow<List<Product>> = productDao.getAllProduct()
    fun getAllCategory(): Flow<List<Category>> = categoryDao.getAllCategories()
    fun getProductByCategory(categoryId :Int) : Flow<List<Product>> = productDao.getProductsByCategory(categoryId)

    suspend fun getProduct(productId :String): Product {
        return getAllProduct().first().find { it.id == productId } ?: throw NoSuchElementException("Product Not Found")
    }

    suspend fun getMatchingProducts(productIds: List<String?>): List<Product> {
        val allProducts = getAllProduct().first()
        return allProducts.filter { productIds.contains(it.id) }
    }

    suspend fun updateProductRating(productId : String , rating : Int) {
        productDao.updateRating(productId,rating)
    }

    suspend fun upsertProduct(product: Product){
        productDao.upsertProduct(product)
    }

    suspend fun deleteProduct(product: Product){
        productDao.deleteProduct(product)
    }

}

//var productList: List<Product> = listOf()
//var categories: List<Category> = listOf()
//lateinit var currentProduct: Product
//
//fun initProducts(context: Context) {
//    if (productList.isEmpty()) {
//        val products =
//            context.assets.open("products.json").bufferedReader().use { it.readText() }
//        productList = Json.decodeFromString(products)
//    }
//}
//
//fun initCategories(context: Context): List<Category> {
//    if (categories.isEmpty()) {
//        val category =
//            context.assets.open("categories.json").bufferedReader()
//                .use { it.readText() }
//        categories = Json.decodeFromString(category)
//    }
//    return categories
//}
//
//fun getProducts(name: String, category: Category = categories[0]): List<Product> {
//    var productsList = when (category.id) {
//        0 -> productList
//        else -> productList.filter { it.categoryId == category.id }
//    }
//    return productsList.filter { it.title.contains(name, ignoreCase = true) }
//}
//
//fun getProduct(productId: String): Product {
//    return productList.find { it.id == productId }!!
//}
//
//fun getMatchingProducts(productIds: List<String>): List<Product> =
//    productList.filter { productIds.contains(it.id) }