package com.videosandbooksapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.videosandbooksapp.R
import com.videosandbooksapp.databinding.HomeFragmentBinding
import com.videosandbooksapp.models.Videos

class HomeFragment :Fragment(){
    lateinit var adapter: VideosAdapter
    private lateinit var binding:HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.home_fragment,container,false)
        binding.lifecycleOwner=this

        setUpAdapter()


        return binding.root
    }

    private fun setUpAdapter(){
        adapter= VideosAdapter()
        binding.videosRv.adapter=adapter
    }
}