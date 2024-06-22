package app.netlify.dev4rju9.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.netlify.dev4rju9.shoppinglist.data.db.entities.ShoppingEntity

@Database(
    entities = [ShoppingEntity::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao (): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        operator fun invoke (context: Context) = instance ?: synchronized (LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        fun createDatabase (context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ShoppingDatabase::class.java, "ShoppingDatabase.db").build()

    }

}