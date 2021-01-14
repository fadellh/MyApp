package com.example.basictutorial.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basictutorial.R
import com.example.basictutorial.databinding.ItemTodoBinding
import com.example.basictutorial.model.Cat
import com.example.basictutorial.model.Image
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import java.net.URL

class HomeImageAdapter(
    var imageList : List<Cat>
) :RecyclerView.Adapter<HomeImageAdapter.ImageHolder>() {

    inner class ImageHolder (itemView:View) : RecyclerView.ViewHolder(itemView)
    private lateinit var binding: ItemTodoBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return ImageHolder(view)

    }

    override fun getItemCount(): Int {
      return imageList.size
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {

        holder.itemView.apply {
            binding = ItemTodoBinding.bind(this)

            Picasso.get().load(imageList[position].url).into(binding.imgHome)
            binding.tvTitleHome.text = imageList[position].id
  /* val txtView = findViewById<MaterialTextView>(R.id.tvTitleHome)
            txtView.text = imageList[position].title*/
            //binding.imgHome.setImageBitmap(bitImg)
        }
    }

}
