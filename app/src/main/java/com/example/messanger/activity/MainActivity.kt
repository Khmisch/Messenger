package com.example.messanger.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messanger.R
import com.example.messanger.adapter.ChatAdapter
import com.example.messanger.model.Chat
import com.example.messanger.model.Message
import com.example.messanger.model.Room

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            initViews()
    }

    private fun initViews() {
       recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))
        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ChatAdapter(this, chats)
        recyclerView!!.adapter = adapter
    }

    private fun getAllChats(): ArrayList<Chat> {
        val stories:ArrayList<Room> = ArrayList<Room>()

        for (i in 1..15) {
            if (i == 1|| i == 6 || i == 10 ) {
                stories.add(Room(R.drawable.im_sample_007, "Khurshidbek"))
            }else if (i == 2 || i == 7|| i == 11) {
                stories.add(Room(R.drawable.im_sample_007, "Sherzodbek"))
            } else if (i == 4 || i == 8|| i == 13) {
                stories.add(Room(R.drawable.im_sample_007, "Begzodbek"))
            } else {
                stories.add(Room(R.drawable.im_sample_007,  "Xurshidbek"))
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