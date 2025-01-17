package dev.inmo.tgbotapi.types.message

import com.soywiz.klock.DateTime
import dev.inmo.tgbotapi.types.MessageIdentifier
import dev.inmo.tgbotapi.types.chat.User
import dev.inmo.tgbotapi.types.chat.GroupChat
import dev.inmo.tgbotapi.types.message.ChatEvents.abstracts.GroupEvent
import dev.inmo.tgbotapi.types.message.abstracts.GroupEventMessage

data class CommonGroupEventMessage<T : GroupEvent>(
    override val messageId: MessageIdentifier,
    override val from: User,
    override val chat: GroupChat,
    override val chatEvent: T,
    override val date: DateTime
) : GroupEventMessage<T>
