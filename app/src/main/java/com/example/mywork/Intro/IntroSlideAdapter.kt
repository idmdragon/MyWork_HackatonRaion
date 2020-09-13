package com.example.mywork.Intro


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mywork.R


class IntroSlideAdapter (private val introSlide: List<IntroSlide>): RecyclerView.Adapter<IntroSlideAdapter.IntroSlideViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        return IntroSlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.introitemcontainer,parent,false
            )

        )
    }

    override fun getItemCount(): Int {
        return introSlide.size
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSlide[position] )
    }

    inner class IntroSlideViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private  val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private  val textDescription = view.findViewById<TextView>(R.id.textDescription)
        private  val imageIcon = view.findViewById<ImageView>(R.id.imageSlideIcon)

        fun bind(introSlide: IntroSlide){
            textTitle.text = introSlide.Tittle
            textDescription.text = introSlide.Content
            imageIcon.setImageResource(introSlide.Image )

        }
    }

}