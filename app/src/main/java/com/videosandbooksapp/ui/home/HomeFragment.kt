package com.videosandbooksapp.ui.home

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.videosandbooksapp.R
import com.videosandbooksapp.VideosApplication
import com.videosandbooksapp.databinding.HomeFragmentBinding
import com.videosandbooksapp.di.ViewModelFactory
import javax.inject.Inject

class HomeFragment :Fragment(){
    lateinit var adapter: VideosAdapter
    private lateinit var binding:HomeFragmentBinding
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as VideosApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.home_fragment,container,false)
        binding.lifecycleOwner=this

        setUpAdapter()
        observeForMessage()
        observeForVideos()
        observeForLoading()

        return binding.root
    }
    private fun observeForLoading(){
        viewModel.progress.observe(viewLifecycleOwner, Observer {
         if (it){
             binding.loading.visibility=View.VISIBLE
         }else{
             binding.loading.visibility=View.GONE

         }
        })
    }

    private fun observeForVideos(){
        viewModel.getPosts()
        viewModel.videosList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
    private fun observeForMessage(){
     viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
         Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
     })
    }
    private fun setUpAdapter(){
        adapter= VideosAdapter()
        binding.videosRv.adapter=adapter
    }
}