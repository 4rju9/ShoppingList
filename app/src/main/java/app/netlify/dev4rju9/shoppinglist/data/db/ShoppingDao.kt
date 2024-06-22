package app.netlify.dev4rju9.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.netlify.dev4rju9.shoppinglist.data.db.entities.ShoppingEntity

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert (item: ShoppingEntity)

    @Delete
    suspend fun delete (item: ShoppingEntity)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems (): LiveData<List<ShoppingEntity>>

}