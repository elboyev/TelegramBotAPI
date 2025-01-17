package dev.inmo.tgbotapi.types.message.content

import dev.inmo.tgbotapi.requests.abstracts.Request
import dev.inmo.tgbotapi.requests.send.SendContact
import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.buttons.KeyboardMarkup
import dev.inmo.tgbotapi.types.message.abstracts.ContentMessage
import kotlinx.serialization.Serializable

@Serializable
data class ContactContent(
    val contact: Contact
) : MessageContent {
    override fun createResend(
        chatId: ChatIdentifier,
        disableNotification: Boolean,
        protectContent: Boolean,
        replyToMessageId: MessageIdentifier?,
        allowSendingWithoutReply: Boolean?,
        replyMarkup: KeyboardMarkup?
    ): Request<ContentMessage<ContactContent>> = SendContact(
        chatId, contact, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply, replyMarkup
    )
}
