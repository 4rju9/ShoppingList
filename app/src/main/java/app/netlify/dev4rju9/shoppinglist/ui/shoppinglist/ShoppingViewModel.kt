package app.netlify.dev4rju9.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import app.netlify.dev4rju9.shoppinglist.data.db.entities.ShoppingEntity
import app.netlify.dev4rju9.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel (
    private val repository: ShoppingRepository
) : ViewModel() {

    fun upsert (item: ShoppingEntity) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete (item: ShoppingEntity) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingList () = repository.getAllShoppingItems()
}