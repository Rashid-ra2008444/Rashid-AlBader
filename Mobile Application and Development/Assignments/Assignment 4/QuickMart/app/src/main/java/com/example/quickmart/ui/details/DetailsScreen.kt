package com.example.quickmart.ui.details

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quickmart.R
import com.example.quickmart.model.Product
import com.example.quickmart.ui.favourite.FavouriteViewModel
import com.example.quickmart.ui.product.ProductViewModel
import com.example.quickmart.ui.theme.QuickMartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    onBackPressed: () -> Unit,
    productViewModel: ProductViewModel,
    detailsViewModel: DetailsViewModel = viewModel(),
    favouriteViewModel: FavouriteViewModel,
    userId : String
) {
    val productState by detailsViewModel.product.collectAsState()
    val product = productViewModel.selectedProduct
    val quantity = detailsViewModel.quantity
    val total by detailsViewModel.total.collectAsState()
    val isFavouriteMap by favouriteViewModel.isFavouriteMap.collectAsState()

    val isFavourite = isFavouriteMap[product.id] ?: false


    LaunchedEffect(key1 = product.id){
        detailsViewModel.loadProductDetails(product.id)
    }
    LaunchedEffect(key1 = productState) {
        detailsViewModel.checkIfProductIsFavourite(productState?.id,userId)
    }

        val context = LocalContext.current
        val categoryName =
            product.categoryId.let { productViewModel.getCategoryByID(it)?.category }

        QuickMartTheme {
            Scaffold(
                topBar = {
                    IconButton({ onBackPressed() }, Modifier.padding(4.dp)) {
                        Icon(Icons.Default.KeyboardArrowLeft, null, Modifier.size(36.dp))
                    }
                },
                content = { paddingValues ->
                    if (categoryName != null) {
                        ProductDetails(
                            product = product,
                            quantity = quantity,
                            total = total,
                            isFavourite = isFavourite,
                            categoryName = categoryName,
                            onDecreaseQuantity = { detailsViewModel.updateQuantity(-1) },
                            onIncreaseQuantity = { detailsViewModel.updateQuantity(1) },
                            onFavourite = {
                                favouriteViewModel.toggleFavourite(product.id, userId)
                            }, paddingValues = paddingValues
                        )
                    }

                },
                floatingActionButton = {
                    ElevatedButton(
                        onClick = {
                            product.price.let {
                                detailsViewModel.addToCart(
                                    productId = product.id,
                                    userId = userId,
                                )
                            }
                            onBackPressed()
                            Toast
                                .makeText(
                                    context,
                                    "Added ${product.title} to cart",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.hsl(
                                150F, 0.73F, 0.38F
                            )
                        ),
                        enabled = true,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                    ) {
                        Text(
                            "Add to Cart",
                            fontSize = TextUnit(6F, TextUnitType.Em),
                            color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                },
                floatingActionButtonPosition = FabPosition.Center
            )
        }
    }

    @SuppressLint("DiscouragedApi")
    @Composable
    fun ProductDetails(
        product: Product,
        quantity: Int,
        total: Double,
        isFavourite: Boolean,
        categoryName: String,
        onDecreaseQuantity: () -> Unit,
        onIncreaseQuantity: () -> Unit,
        onFavourite: () -> Unit,
        paddingValues: PaddingValues
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState(), true)
        ) {
            Image(
                painterResource(
                    LocalContext.current.resources.getIdentifier(
                        product.imageName, "drawable",
                        LocalContext.current.packageName
                    )
                ), null,
                Modifier
                    .height(250.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Divider(Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp),
                Arrangement.SpaceBetween,
                Alignment.CenterVertically
            ) {
                Text(
                    text = product.title,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(7.5F, TextUnitType.Em)
                )
                IconButton(onClick = { onFavourite() }) {
                    Icon(
                        if (isFavourite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        null,
                        Modifier.size(28.dp),
                        if (isFavourite) Color.Red else Color.LightGray
                    )
                }
            }
            Text(
                "QR ${String.format("%.2f", product.price)} / unit",
                Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp),
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(5.5F, TextUnitType.Em),
                color = Color.LightGray,
                textAlign = TextAlign.Start
            )
            Spacer(Modifier.height(36.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(R.drawable.baseline_remove_24),
                        null,
                        tint = if (quantity > 1) Color.hsl(
                            144F, 0.99F, 0.39F
                        ) else MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier
                            .border(
                                2.5.dp,
                                MaterialTheme.colorScheme.surfaceVariant,
                                RoundedCornerShape(12.dp)
                            )
                            .padding(6.dp)
                            .clickable(enabled = quantity > 1, onClick = { onDecreaseQuantity() })
                    )
                    Text(
                        quantity.toString(),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = TextUnit(5.5F, TextUnitType.Em),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Icon(Icons.Default.Add,
                        null,
                        tint = Color.hsl(144F, 0.99F, 0.39F),
                        modifier = Modifier
                            .border(
                                2.5.dp,
                                MaterialTheme.colorScheme.surfaceVariant,
                                RoundedCornerShape(12.dp)
                            )
                            .padding(6.dp)
                            .clickable { onIncreaseQuantity() })
                }
                Text(
                    "QR ${String.format("%.2f", total)}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = TextUnit(5.5F, TextUnitType.Em)
                )
            }
            Divider(Modifier.padding(12.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    "Product Category",
                    fontWeight = FontWeight.Medium,
                    fontSize = TextUnit(5.5F, TextUnitType.Em),
                    textAlign = TextAlign.Start
                )
                Text(
                    categoryName.uppercase(),
                    fontSize = TextUnit(5.5F, TextUnitType.Em),
                    textAlign = TextAlign.End,
                    color = Color.LightGray
                )
            }
            Divider(Modifier.padding(12.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    "Product Ratings",
                    fontWeight = FontWeight.Medium,
                    fontSize = TextUnit(5.5F, TextUnitType.Em),
                    textAlign = TextAlign.Start
                )
                Row {
                    product.rating.let {
                        IntRange(1, it).forEach { _ ->
                            Icon(
                                Icons.Default.Star,
                                null,
                                tint = Color.hsl(40F, 1F, 0.6F),
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    }
                    IntRange(product.rating.plus(1), 5).forEach { _ ->
                        Icon(
                            painterResource(R.drawable.baseline_star_border_24),
                            null,
                            tint = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
            }
            Divider(Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp))
            DescriptionCard(product.description)
        }
    }

    @Composable
    fun DescriptionCard(description: String) {
        var isExpanded by rememberSaveable { mutableStateOf(false) }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Product Description",
                    fontWeight = FontWeight.Medium,
                    fontSize = TextUnit(5.5F, TextUnitType.Em),
                    textAlign = TextAlign.Start
                )
                IconButton({ isExpanded = !isExpanded }) {
                    Icon(
                        if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        null, Modifier.size(28.dp)
                    )
                }
            }
            if (isExpanded)
                Text(
                    description,
                    Modifier.padding(bottom = 12.dp),
                    fontSize = TextUnit(5.5F, TextUnitType.Em),
                    textAlign = TextAlign.Start,
                    color = Color.LightGray
                )
            Divider(Modifier.padding(bottom = 90.dp))
        }
    }
