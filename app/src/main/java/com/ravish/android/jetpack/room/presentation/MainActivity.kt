package com.ravish.android.jetpack.room.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ravish.android.jetpack.room.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val dbViewModel: DBViewModel by viewModels()
    private val userListAdapter: UserListAdapter by lazy { UserListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUI()
        observeLiveData()
        dbViewModel.fetchUsers()
    }

    private fun initUI() {
        binding.rvUsersList.adapter = userListAdapter
        binding.btnAddData.setOnClickListener {
            dbViewModel.addUsers()
        }
    }

    private fun observeLiveData() {
        dbViewModel.usersLiveData.observe(this, {
            userListAdapter.submitList(it)
            if (it.isNotEmpty()) binding.btnAddData.isEnabled = false
        })
    }

}