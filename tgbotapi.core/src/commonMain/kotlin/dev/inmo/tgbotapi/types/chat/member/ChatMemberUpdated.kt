package dev.inmo.tgbotapi.types.chat.member

import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.chat.Chat
import dev.inmo.tgbotapi.types.chat.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatMemberUpdated(
    @SerialName(chatField)
    val chat: Chat,
    @SerialName(fromField)
    val user: User,
    @SerialName(dateField)
    val date: TelegramDate,
    @SerialName(oldChatMemberField)
    val oldChatMemberState: ChatMember,
    @SerialName(newChatMemberField)
    val newChatMemberState: ChatMember,
    @SerialName(inviteLinkField)
    val inviteLink: ChatInviteLink? = null
)
