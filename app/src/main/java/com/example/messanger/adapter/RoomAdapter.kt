package com.example.messanger.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messanger.R
import com.example.messanger.fragment.ChatFragment
import com.example.messanger.model.Chat
import com.example.messanger.model.Room
import com.example.messanger.model.Stories
import com.google.android.material.imageview.ShapeableImageView
import java.util.ArrayList

class RoomAdapter (var fragment: ChatFragment, var items: ArrayList<Room>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_ADDED_YES = 0
    private val TYPE_ADDED_NO = 1


    override fun getItemViewType(position: Int): Int {

        val chat: Room = items[position]
        if (chat.isOnline) {
            return  TYPE_ADDED_YES
        }
        return TYPE_ADDED_NO

    }
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        if (viewType == TYPE_ADDED_YES) {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_room_view, parent, false)
            return RoomViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room_view_create, parent, false)
        return RoomViewHolderCreate(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val room = items[position]
        if (holder is RoomViewHolder){
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(room.profile)
            tv_fullname.text = room.fullname

        }
        if (holder is RoomViewHolderCreate){
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(room.profile)
            tv_fullname.text = room.fullname
        }
    }

    class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)

    }
   class RoomViewHolderCreate(view: View) : RecyclerView.ViewHolder(view) {

        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)
       var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)


   }


}