package com.ravish.android.jetpack.room.db

import com.ravish.android.jetpack.room.db.entity.User

interface DBUseCase {
    suspend fun getUsers(): List<User>
    suspend fun insertAll(users: List<User>)
}