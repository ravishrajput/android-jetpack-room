package com.ravish.android.jetpack.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ravish.android.jetpack.room.db.dao.UserDao
import com.ravish.android.jetpack.room.db.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}