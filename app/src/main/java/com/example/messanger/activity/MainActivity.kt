package com.example.messanger.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messanger.R
import com.example.messanger.adapter.ChatAdapter
import com.example.messanger.fragment.ChatFragment
import com.example.messanger.fragment.PeopleFragment
import com.example.messanger.model.Chat
import com.example.messanger.model.Message
import com.example.messanger.model.Room
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chatFragment= ChatFragment()
        val contactsFragment= PeopleFragment()
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        setCurrentFragment(chatFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_chats->setCurrentFragment(chatFragment)
                R.id.menu_contacts->setCurrentFragment(contactsFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}