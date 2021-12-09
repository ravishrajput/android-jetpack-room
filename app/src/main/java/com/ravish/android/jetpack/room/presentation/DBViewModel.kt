package com.ravish.android.jetpack.room.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravish.android.jetpack.room.db.DBUseCase
import com.ravish.android.jetpack.room.db.entity.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DBViewModel @Inject constructor(private val dbUseCase: DBUseCase) : ViewModel() {

    private val _usersLiveData = MutableLiveData<List<User>>()
    val usersLiveData: LiveData<List<User>>
        get() = _usersLiveData

    fun fetchUsers() {
        viewModelScope.launch {
            val allUsers = dbUseCase.getUsers()
            _usersLiveData.postValue(allUsers)
        }
    }

    fun addUsers() {
        viewModelScope.launch {
            dbUseCase.insertAll(getDummyUsers())
            delay(2000)
            fetchUsers()
        }
    }

    private fun getDummyUsers() = listOf(
        User(1, "Ravish Rajput", "ravish@gmail.com"),
        User(2, "Ronav Rajput", "Ronav@gmail.com"),
        User(3, "Dhruv Rajput", "Dhruv@gmail.com"),
        User(4, "Navita Rajput", "Navita@gmail.com"),
        User(5, "Sonu Rajput", "Sonu@gmail.com"),
        User(6, "Himani Rajput", "Himani@gmail.com"),
        User(7, "Dharmendra Rajput", "Dharmendra@gmail.com"),
        User(8, "Amit Rajput", "Amit@gmail.com"),
        User(9, "Rohit Rajput", "Rohit@gmail.com")
    )

}