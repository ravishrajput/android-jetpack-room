package com.ravish.android.jetpack.room.db

import com.ravish.android.jetpack.room.db.entity.User
import javax.inject.Inject

class DBUseCaseImpl @Inject constructor(private val appDB: AppDatabase) : DBUseCase {

    override suspend fun getUsers(): List<User> = appDB.userDao().getAll()

    override suspend fun insertAll(users: List<User>) = appDB.userDao().insertAll(users)
}