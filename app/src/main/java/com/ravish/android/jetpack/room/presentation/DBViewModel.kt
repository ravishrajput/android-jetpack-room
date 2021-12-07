package com.ravish.android.jetpack.room.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravish.android.jetpack.room.db.DBUseCase
import com.ravish.android.jetpack.room.db.entity.User
import dagger.hilt.android.lifecycle.HiltViewModel
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

}