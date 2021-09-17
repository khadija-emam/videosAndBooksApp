package com.videosandbooksapp

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


    /**
     * Binding adapter used to hide the spinner once data is available
     */
    @androidx.databinding.BindingAdapter("goneIfNotNull")
    fun goneIfNotNull(view: View, it: Any?) {
        view.visibility = if (it != null) View.GONE else View.VISIBLE
    }

    /**
     * Binding adapter used to display images from URL using Glide
     */
    @BindingAdapter("imageUrl")
    fun setImage(imageView: ImageView, drawable:Int) {
        Glide.with(imageView.context).load(drawable).into(imageView)
    }
