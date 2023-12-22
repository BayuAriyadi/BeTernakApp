import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beternakapp.data.response.DataItem
import com.example.beternakapp.databinding.ItemProductBinding
import com.example.beternakapp.ui.ProductDetail

class ProductAdapter : ListAdapter<DataItem, ProductAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)

        holder.itemView.setOnClickListener {
            val intentToDetail = Intent(holder.itemView.context, ProductDetail::class.java)
            intentToDetail.putExtra(ProductDetail.TITLE, product.productTitle)
            intentToDetail.putExtra(ProductDetail.PRICE, product.productPrice)
            intentToDetail.putExtra(ProductDetail.DESC, product.productDesc)
            intentToDetail.putExtra(ProductDetail.IMG, product.productImage)
            holder.itemView.context.startActivity(intentToDetail)
        }
    }
    class MyViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: DataItem){

            binding.tvTitle.text = product.productTitle
            binding.tvPrice.text = "Rp. ${product.productPrice}"
            Glide.with(binding.imgProduct)
                .load(product.productImage)
                .into(binding.imgProduct)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}