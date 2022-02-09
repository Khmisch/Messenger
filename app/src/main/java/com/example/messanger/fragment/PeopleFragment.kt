package com.example.messanger.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messanger.R
import com.example.messanger.adapter.PeopleAdapter
import com.example.messanger.model.Message
import com.example.messanger.model.Stories
import java.util.ArrayList

class PeopleFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_people, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(activity, 2))
        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Stories>) {
        val adapter = PeopleAdapter(this, chats)
        recyclerView!!.adapter = adapter

    }
    private fun getAllChats(): ArrayList<Stories> {
        val chats: ArrayList<Stories> = ArrayList<Stories>()
        for (i in 1..14) {
            if (i == 1) {
                chats.add(Stories(R.drawable.ic_plus_add, R.drawable.im_sample_007, "Add to Story", true))
            }else if (i == 2 || i == 8|| i == 13) {
                chats.add(Stories(R.drawable.im_person_me, R.drawable.im_stories_my, "KIM", false))
            }else if (i == 3 || i == 9) {
                chats.add(Stories(R.drawable.im_peron_0,R.drawable.im_stories_feynamn, "Richard Feynman", false))
            } else if (i == 4 || i ==11) {
                chats.add(Stories(R.drawable.im_person_3,R.drawable.im_stories_holiday, "Barbara Peace", false))
            } else if (i == 6 || i == 12) {
                chats.add(Stories(R.drawable.im_person_2,R.drawable.im_stories_concert, "John Nash", false))
            } else {
                chats.add(Stories(R.drawable.im_sample_007, R.drawable.im_sample_007, "Khurshidbek Kurbanov", false))

            }
        }
        return chats
    }
}