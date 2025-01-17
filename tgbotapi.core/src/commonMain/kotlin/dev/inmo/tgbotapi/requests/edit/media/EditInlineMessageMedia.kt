package dev.inmo.tgbotapi.requests.edit.media

import dev.inmo.tgbotapi.requests.abstracts.MultipartFile
import dev.inmo.tgbotapi.requests.edit.abstracts.*
import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.media.TelegramMedia
import dev.inmo.tgbotapi.types.buttons.InlineKeyboardMarkup
import kotlinx.serialization.*

@Serializable
data class EditInlineMessageMedia(
    @SerialName(inlineMessageIdField)
    override val inlineMessageId: InlineMessageIdentifier,
    @SerialName(mediaField)
    override val media: TelegramMedia,
    @SerialName(replyMarkupField)
    override val replyMarkup: InlineKeyboardMarkup? = null
) : EditInlineMessage, EditReplyMessage, EditMediaMessage {

    init {
        if (media.file is MultipartFile) {
            throw IllegalArgumentException("For editing of media messages you MUST use file id (according to documentation)")
        }
    }
    override val requestSerializer: SerializationStrategy<*>
        get() = serializer()

    override fun method(): String = editMessageMediaMethod
}
