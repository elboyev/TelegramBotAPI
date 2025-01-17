package dev.inmo.tgbotapi.types.message

import com.soywiz.klock.DateTime
import dev.inmo.tgbotapi.types.MessageIdentifier
import dev.inmo.tgbotapi.types.chat.User
import dev.inmo.tgbotapi.types.chat.SupergroupChat
import dev.inmo.tgbotapi.types.message.ChatEvents.abstracts.SupergroupEvent
import dev.inmo.tgbotapi.types.message.abstracts.SupergroupEventMessage

data class CommonSupergroupEventMessage<T : SupergroupEvent>(
    override val messageId: MessageIdentifier,
    override val from: User,
    override val chat: SupergroupChat,
    override val chatEvent: T,
    override val date: DateTime
) : SupergroupEventMessage<T>
