package com.example.quickmart.ui.favourite

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quickmart.data.model.CartItem
import com.example.quickmart.data.model.Product
import com.example.quickmart.data.repository.CartRepository
import com.example.quickmart.data.repository.FavouriteRepository
import com.example.quickmart.data.repository.ProductRepository
import com.example.quickmart.ui.theme.QuickMartTheme
import com.example.quickmart.viewModel.CartViewModel
import com.example.quickmart.viewModel.FavouriteViewModel

@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(navController : NavHostController) {
    val cartViewModel = CartViewModel()
    val favouriteViewModel = FavouriteViewModel()

    var favourites by rememberSaveable {
        mutableStateOf(favouriteViewModel.getFavourite())
    }
    val context = LocalContext.current
    QuickMartTheme {
        Scaffold(
            modifier = Modifier.padding(
                top = 16.dp,
                bottom = 16.dp
            ),
            content = {
                FavouriteItems(
                    favouriteItems = favourites,
                    onRemoveProductFromFavourite = { product ->
                        favourites = favourites.filter { it -> product.id != it.id }.toMutableList()
                    },
                    modifier = Modifier.padding(it)
                )
            },
            floatingActionButton = {
                ElevatedButton(
                    onClick = {
                        favourites.forEach {
                            cartViewModel.addCartItem(CartItem(it.id, 1))
                        }
                        favourites = emptyList<Product>().toMutableList()
                        Toast
                            .makeText(
                                context, "Products Added to cart", Toast.LENGTH_SHORT
                            )
                            .show()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.hsl(
                            150F, 0.73F, 0.38F
                        )
                    ),
                    enabled = favourites.isNotEmpty(),
                    shape = RoundedCornerShape(12.dp),

                    modifier = Modifier.padding(start = 30.dp)
                ) {
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontSize = TextUnit(1.5F, TextUnitType.Em),
                                    color = Color.White
                                )
                            ) {
                                append("Add All To Cart")
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        textAlign = TextAlign.Center
                    )
                }
            },
            floatingActionButtonPosition = FabPosition.End,
        )
    }
}

@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(paddingValues: PaddingValues) {
    val favouriteViewModel = FavouriteViewModel()

    var favourites by rememberSaveable {
        mutableStateOf(favouriteViewModel.getFavourite())
    }
    QuickMartTheme {
        Scaffold(
            modifier = Modifier.padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding()
            ),
            content = { it ->
                FavouriteItems(
                    favouriteItems = favourites,
                    onRemoveProductFromFavourite = { product ->
                        favourites = favourites.filter { product.id != it.id }.toMutableList()
                    },
                    modifier = Modifier.padding(it)
                )
            },
            floatingActionButton = {
                ElevatedButton(
                    onClick = {
                        favourites.forEach {
                            CartRepository.addCartItem(CartItem(it.id, 1))
                        }
                        favourites = emptyList<Product>().toMutableList()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.hsl(
                            150F, 0.73F, 0.38F
                        )
                    ),
                    enabled = favourites.isNotEmpty(),
                    shape = RoundedCornerShape(12.dp),

                    modifier = Modifier.padding(start = 30.dp)
                ) {
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontSize = TextUnit(1.5F, TextUnitType.Em),
                                    color = Color.White
                                )
                            ) {
                                append("Add All To Cart")
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        textAlign = TextAlign.Center
                    )
                }
            },
            floatingActionButtonPosition = FabPosition.End,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteItems(
    favouriteItems: List<Product>,
    onRemoveProductFromFavourite: (Product) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "My Favourites",
            letterSpacing = TextUnit(0.1F, TextUnitType.Em),
            fontSize = TextUnit(7F, TextUnitType.Em),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 12.dp)
        )
        Divider(
            Modifier.padding(top = 16.dp), 2.dp, MaterialTheme.colorScheme.surfaceVariant
        )
        if (favouriteItems.isEmpty()) {

            Icon(
                Icons.Outlined.Favorite,
                null,
                tint = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 12.dp)
            )
            Text(
                "No products in favourite",
                color = MaterialTheme.colorScheme.surfaceVariant,
                fontSize = TextUnit(7.5F, TextUnitType.Em),
                fontWeight = FontWeight(400)
            )
        } else
            LazyColumn(modifier = modifier.padding(bottom = 80.dp)) {
                items(favouriteItems) {
                    FavouriteItemCard(
                        it, onRemoveProductFromFavourite
                    )
                }
            }
    }

}

@SuppressLint("DiscouragedApi")
@Composable
fun FavouriteItemCard(
    item: Product,
    onRemoveProductFromFavourite: (Product) -> Unit
) {
    val product = ProductRepository.getProduct(item.id)

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Row(
            modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            if (product != null) {
                Image(
                    painterResource(
                        LocalContext.current.resources.getIdentifier(
                            product.imageName, "drawable", LocalContext.current.packageName
                        )
                    ), null,
                    Modifier
                        .padding(end = 8.dp)
                        .widthIn(max = 100.dp)
                        .aspectRatio(1.25F)
                )
            }
            Column {
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp)
                ) {
                    Column {
                        if (product != null) {
                            Text(
                                product.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = TextUnit(5.5F, TextUnitType.Em)
                            )
                        }
                        if (product != null) {
                            Text(
                                "QR ${String.format("%.2f", product.price)} / unit",
                                fontWeight = FontWeight.Bold,
                                fontSize = TextUnit(4.5F, TextUnitType.Em),
                                color = Color.LightGray
                            )
                        }
                    }
                    Icon(Icons.Default.Clear,
                        null,
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .clickable { onRemoveProductFromFavourite(item) }
                            .padding(top = 2.dp, end = 2.dp))
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 4.dp, top = 16.dp, end = 4.dp, bottom = 4.dp
                        )
                ) {
                    if (product != null) {
                        Text(
                            "QR ${String.format("%.2f", product.price)}",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = TextUnit(5F, TextUnitType.Em)
                        )
                    }
                }
            }
        }
        Divider(
            Modifier.padding(top = 16.dp), 2.dp, MaterialTheme.colorScheme.surfaceVariant
        )
    }
}