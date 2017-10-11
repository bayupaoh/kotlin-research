package me.bayupaoh.belajarkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

/**
 * Created by King Oil on 11/10/2017.
 */
class CustomAdapter(val userList: ArrayList<User>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent,false)
        return ViewHolder(v)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: User){
            val txtNama = itemView.findViewById(R.id.textViewUsername) as TextView
            val txtAddress = itemView.findViewById(R.id.textViewAddress) as TextView
            val imgAvatar = itemView.findViewById(R.id.imgAvatar) as ImageView
            txtNama.text = user.name
            txtAddress.text = user.address
            Glide.with(itemView.context).load(user.urlImage).into(imgAvatar)
        }
    }

}