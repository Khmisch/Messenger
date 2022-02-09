package com.example.messanger.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messanger.R
import com.example.messanger.fragment.ChatFragment
import com.example.messanger.model.Chat
import com.example.messanger.model.Room
import com.google.android.material.imageview.ShapeableImageView
import java.security.AccessController.getContext
import java.util.ArrayList

class ChatAdapter  (var context: ChatFragment, var items: ArrayList<Chat>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1


    override fun getItemViewType(position: Int): Int {

        val feed: Chat = items[position]
        if (feed.rooms.size > 0)
            return TYPE_ITEM_ROOM
       return TYPE_ITEM_MESSAGE
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        if (viewType == TYPE_ITEM_ROOM) {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)
            return RoomViewHolder(context, view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message, parent, false)
        return MessageViewHolder(view)

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = items[position]
        if (holder is RoomViewHolder){
            var recyclerView = holder.recyclerView
            refreshAdapter(message.rooms, recyclerView)
        }
        if (holder is MessageViewHolder){
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname
            val is_online = holder.is_online

            iv_profile.setImageResource(message.message!!.profile)
            tv_fullname.text = message.message!!.fullname

            if (message.message!!.isOnline){
                is_online.visibility = View.VISIBLE
            }else{
                is_online.visibility = View.GONE
            }

        }

    }

    private fun refreshAdapter(rooms: ArrayList<Room>, recyclerView: RecyclerView) {
        val adapter = RoomAdapter(context, rooms)
        recyclerView!!.adapter = adapter

    }

    class RoomViewHolder(context: ChatFragment,view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView:RecyclerView

       init {
           recyclerView= view.findViewById(R.id.recyclerView)
           val manager = LinearLayoutManager(context.activity,(LinearLayoutManager.HORIZONTAL), false)
           recyclerView.setLayoutManager(manager)
       }

    }
    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)
        var is_online : LinearLayout = view.findViewById(R.id.is_online)

    }

}