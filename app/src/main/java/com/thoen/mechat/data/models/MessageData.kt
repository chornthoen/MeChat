package com.thoen.mechat.data.models

data class MessageData(
    val id: String = "",
    val senderId: String = "",
    val message: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val senderName: String = "",
    val senderImage: String? = null,
    val imageUrl: String? = null
)
