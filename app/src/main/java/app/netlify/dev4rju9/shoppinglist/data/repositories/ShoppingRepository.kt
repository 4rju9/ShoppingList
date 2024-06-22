package app.netlify.dev4rju9.shoppinglist.data.repositories

import app.netlify.dev4rju9.shoppinglist.data.db.ShoppingDatabase
import app.netlify.dev4rju9.shoppinglist.data.db.entities.ShoppingEntity

class ShoppingRepository (
    private val db: ShoppingDatabase
) {
    suspend fun upsert (item: ShoppingEntity) = db.getShoppingDao().upsert(item)

    suspend fun delete (item: ShoppingEntity) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems () = db.getShoppingDao().getAllShoppingItems()
}