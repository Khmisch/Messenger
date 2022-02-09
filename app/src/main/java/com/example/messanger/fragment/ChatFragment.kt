package com.example.messanger.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messanger.R
import com.example.messanger.activity.MainActivity
import com.example.messanger.adapter.ChatAdapter
import com.example.messanger.model.Chat
import com.example.messanger.model.Message
import com.example.messanger.model.Room

class ChatFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_chat, container, false)
        initViews(view)
        return view
    }
    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(activity, 1))

        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ChatAdapter(this, chats)
        recyclerView!!.adapter = adapter
    }

    private fun getAllChats(): ArrayList<Chat> {
        val stories:ArrayList<Room> = ArrayList<Room>()

        for (i in 1..15) {
            if (i == 1 ) {
                stories.add(Room(R.drawable.ic_create, "Create Room", false))
            }else if (i == 2 || i == 7|| i == 11) {
                stories.add(Room(R.drawable.im_sample_007, "Sherzodbek Kurbanov", true))
            } else if (i == 4 || i == 8|| i == 13) {
                stories.add(Room(R.drawable.im_sample_007, "Begzodbek Kurbanov", true))
            } else {
                stories.add(Room(R.drawable.im_sample_007,  "Xurshidbek Kurbanov", true))
            }
        }
        val chats:ArrayList<Chat> = ArrayList<Chat>()
        chats.add(Chat(stories))
        for (i in 1..15) {
            if (i == 1|| i == 6 || i == 10 ) {
                chats.add(Chat(Message(R.drawable.im_sample_007, "Khurshidbek", true)))
            }else if (i == 2 || i == 7|| i == 11) {
                chats.add(Chat(Message(R.drawable.im_sample_007, "Sherzodbek",false )))
            } else if (i == 4 || i == 8|| i == 13) {
                chats.add(Chat(Message(R.drawable.im_sample_007, "Begzodbek",false )))
            } else {
                chats.add(Chat(Message(R.drawable.im_sample_007,  "Xurshidbek",true)))
            }
        }
        return chats

    }



}