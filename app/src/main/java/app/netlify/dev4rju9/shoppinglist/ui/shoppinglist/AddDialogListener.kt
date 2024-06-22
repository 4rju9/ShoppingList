package app.netlify.dev4rju9.shoppinglist.ui.shoppinglist

import app.netlify.dev4rju9.shoppinglist.data.db.entities.ShoppingEntity

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingEntity)
}