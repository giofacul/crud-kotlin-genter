package com.inforizz.aplicationgilbarco.view

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyRecyclerViewAdapter internal constructor(context: Context?, data: List<String>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {
    private val mData: List<String>
    private val mInflater: LayoutInflater
    private var mClickListener: ItemClickListener? = null

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = mInflater.inflate(R.layout.activity_list_item, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = mData[position]
        holder.myTextView.text = animal
    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData.size
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var myTextView: TextView
        override fun onClick(view: View) {
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }

        init {
            myTextView = itemView.findViewById(R.id.text1)
            itemView.setOnClickListener(this)
        }
    }

    // convenience method for getting data at click position
    fun getItem(id: Int): String {
        return mData[id]
    }

    // allows clicks events to be caught
    fun setClickListener(itemClickListener: SearchClient) {
        mClickListener = itemClickListener as ItemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    // data is passed into the constructor
    init {
        mInflater = LayoutInflater.from(context)
        mData = data
    }
}
//
//
//class RecyclerClient : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    private var mData: List<String>? = null
//    private var mInflater: LayoutInflater? = null
//    private var mClickListener: ItemClickListener? = null
//
//
//    fun MyRecyclerViewAdapter(context: Context?, data: List<String?>?) {
//        mInflater = LayoutInflater.from(context)
//        mData = data as List<String>?
//    }
//
//    // inflates the row layout from xml when needed
//    fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
//        val view: View = mInflater!!.inflate(R.layout.activity_list_item, parent, false)
//        return ViewHolder(view)
//    }
//
//    // binds the data to the TextView in each row
//    fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val animal = mData!![position]
//        holder.myTextView.text = animal
//    }
//
//    // total number of rows
//    override fun getItemCount(): Int {
//        return mData!!.size
//    }
//
//
//    // stores and recycles views as they are scrolled off screen
//    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
//        View.OnClickListener {
//        var myTextView: TextView
//        fun onClick(view: View?) {
//            if (mClickListener != null) mClickListener.onItemClick(view, adapterPosition)
//        }
//
//        init {
//            myTextView = itemView.findViewById(R.id.tvAnimalName)
//            itemView.setOnClickListener(this)
//        }
//    }
//
//    // convenience method for getting data at click position
//    fun getItem(id: Int): String? {
//        return mData!![id]
//    }
//
//    // allows clicks events to be caught
//    fun setClickListener(itemClickListener: ItemClickListener?) {
//        mClickListener = itemClickListener
//    }
//
//    // parent activity will implement this method to respond to click events
//    interface ItemClickListener {
//        fun onItemClick(view: View?, position: Int)
//    }
