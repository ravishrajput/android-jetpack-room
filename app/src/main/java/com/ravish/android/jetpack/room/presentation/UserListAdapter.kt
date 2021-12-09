package com.ravish.android.jetpack.room.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ravish.android.jetpack.room.databinding.UserListItemBinding
import com.ravish.android.jetpack.room.db.entity.User

class UserListAdapter : ListAdapter<User, UserListAdapter.ViewHolder>(UserItemDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(parent: ViewGroup) :
        BoundHolder<UserListItemBinding>(parent.viewBinding(UserListItemBinding::inflate)) {
        fun bind(user: User) {
            with(binding) {
                txtName.text = user.name
                txtEmail.text = user.email
            }
        }
    }

    object UserItemDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem._id == newItem._id

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem

    }
}