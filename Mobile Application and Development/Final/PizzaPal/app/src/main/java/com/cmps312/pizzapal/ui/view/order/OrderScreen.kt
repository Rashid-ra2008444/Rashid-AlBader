import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cmps312.pizzapal.entity.Order
import com.cmps312.pizzapal.ui.navigation.NavDestination
import com.cmps312.pizzapal.ui.viewmodel.PizzaPalViewModel
import kotlin.random.Random



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(
                pizzaPalViewModel: PizzaPalViewModel,
                onSelect: (Order) -> Unit,
                navHostController: NavHostController) {
    val orders = pizzaPalViewModel.orders.collectAsState().value
    val context = LocalContext.current
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("PizzaPal Orders", color = MaterialTheme.colorScheme.onTertiary) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MaterialTheme.colorScheme.tertiary),
                navigationIcon = {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                        modifier = Modifier.clickable {  })
//
                },
                actions = {

                }
            )
        },
        content = {
            OrderList(orders, modifier = Modifier.padding(it) , pizzaPalViewModel , onSelect )
        },
        floatingActionButton = {
            Icon(
                imageVector = Icons.Outlined.AddCircle,
                contentDescription = "Add Customer",
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        navHostController.navigate(NavDestination.OrderEditor.route) {
                            launchSingleTop = true
                        }
                    }
            )
        }
    )
}

@Composable
fun OrderList(orders: List<Order>, modifier: Modifier = Modifier , pizzaPalViewModel: PizzaPalViewModel, onSelect: (Order) -> Unit) {
    LazyColumn(modifier = modifier) {
        items(orders) { customer ->
            OrderCard(
                order = customer,
                onSelect = {
                    onSelect(customer)
                }, onDelete = {
                    pizzaPalViewModel.deleteOrder(customer)
                },
                pizzaPalViewModel = pizzaPalViewModel
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderCard(
    order: Order,
    onSelect: (Order) -> Unit,
    onDelete: (Int) -> Unit,
    modifier: Modifier = Modifier,
    pizzaPalViewModel: PizzaPalViewModel
) {
    ElevatedCard(
        modifier = modifier.padding(16.dp),
        onClick = {
            pizzaPalViewModel.getPizzasByOrderId(order.id)
            onSelect(order)},
        colors = CardDefaults.elevatedCardColors(MaterialTheme.colorScheme.tertiary)

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Customer Name: ${order.customerName}",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onTertiary
                )

                IconButton(
                    onClick = { pizzaPalViewModel.deleteOrder(order) },
                    modifier = Modifier.width(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Delete customer",
                        tint = MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.clickable {
                            onDelete(order.id) // Call the onDelete callback with the customer ID
                        }
                    )
                }
            }
            Text(
                text = "Order Number : ${order.id +1}",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onTertiary
            )
            Divider()
            Text(
                text = "Address: ${order.address}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onTertiary
            )

            Text(
                text = "Phone: ${order.phone}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onTertiary
            )

            Text(
                text = "Email: ${order.email}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onTertiary
            )

        }
    }
}

//@Preview
//@Composable
//fun OrderCardPreview() {
//    OrderCard(
//        order = Order(
//            customerName = "John Doe",
//            address = "123 Main St",
//            phone = "555-1234",
//            email = "john@example.com",
//            id = Random.nextInt(10)
//        ),
//        onSelect = {},
//        onDelete = {}
//    )
//}

//@Preview
//@Composable
//fun OrderListPreview() {
//    OrderList(
//        orders = listOf(
//            Order(
//                customerName = "John Doe",
//                address = "123 Main St",
//                phone = "555-1234",
//                email = "john@example.com",
//                id = Random.nextInt(10)
//            ),
//            Order(
//                customerName = "Jane Smith",
//                address = "456 Park Ave",
//                phone = "555-5678",
//                email = "jane@example.com",
//                id = Random.nextInt(10)
//            )
//        )
//    )
//}