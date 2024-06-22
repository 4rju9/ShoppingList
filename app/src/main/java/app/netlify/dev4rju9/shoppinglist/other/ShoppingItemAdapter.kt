package app.netlify.dev4rju9.shoppinglist.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.netlify.dev4rju9.shoppinglist.data.db.entities.ShoppingEntity
import app.netlify.dev4rju9.shoppinglist.databinding.ShoppingItemBinding
import app.netlify.dev4rju9.shoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter (
    var items: List<ShoppingEntity>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ViewHolder>() {

    inner class ViewHolder (val binding: ShoppingItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.binding.tvName.text = item.name
        holder.binding.tvAmount.text = "${item.amount}"

        holder.binding.ivDelete.setOnClickListener { viewModel.delete(item) }
        holder.binding.ivPlus.setOnClickListener {
            item.amount++
            viewModel.upsert(item)
        }
        holder.binding.ivMinus.setOnClickListener {
            if (item.amount > 0) {
                item.amount--
                viewModel.upsert(item)
            }
        }
    }

}