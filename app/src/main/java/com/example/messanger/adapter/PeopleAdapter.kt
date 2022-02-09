package com.example.messanger.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messanger.R
import com.example.messanger.fragment.PeopleFragment
import com.example.messanger.model.Stories
import com.google.android.material.imageview.ShapeableImageView
import java.util.ArrayList

class PeopleAdapter (var fragment: PeopleFragment, var items: ArrayList<Stories>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_ADDED_YES = 0
    private val TYPE_ADDED_NO = 1


    override fun getItemViewType(position: Int): Int {

        val chat: Stories = items[position]
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
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_stories_view, parent, false)
            return AddedViewHolderYes(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_stories_view_active, parent, false)
        return AddedViewHolderNo(view)

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]
        if (holder is AddedViewHolderYes){
            val iv_stories = holder.iv_stories
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.textView

            iv_stories.setImageResource(chat.stories)
            iv_profile.setImageResource(chat.profile)
            tv_fullname.setText(chat.fullname)
        }
        else  if (holder is AddedViewHolderNo){
            val iv_stories = holder.iv_stories
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.textView

            iv_stories.setImageResource(chat.stories)
            iv_profile.setImageResource(chat.profile)
            tv_fullname.setText(chat.fullname)

        }

    }

    class AddedViewHolderYes(view: View) : RecyclerView.ViewHolder(view) {
        var iv_stories : ShapeableImageView = view.findViewById(R.id.iv_stories)
        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)
        var textView : TextView = view.findViewById(R.id.tv_fullname)


    }
    class AddedViewHolderNo(view: View) : RecyclerView.ViewHolder(view) {
        var iv_stories : ShapeableImageView = view.findViewById(R.id.iv_stories)
        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)
        var textView : TextView = view.findViewById(R.id.tv_fullname)


    }
}