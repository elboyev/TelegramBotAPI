package dev.inmo.tgbotapi.requests.send.media

import dev.inmo.tgbotapi.requests.abstracts.MultipartFile
import dev.inmo.tgbotapi.requests.abstracts.Request
import dev.inmo.tgbotapi.requests.send.abstracts.SendMessageRequest
import dev.inmo.tgbotapi.requests.send.media.base.*
import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.media.*
import dev.inmo.tgbotapi.types.message.abstracts.MediaGroupMessage
import dev.inmo.tgbotapi.types.message.abstracts.TelegramBotAPIMessageDeserializeOnlySerializerClass
import dev.inmo.tgbotapi.types.message.content.MediaGroupContent
import dev.inmo.tgbotapi.types.message.content.VisualMediaGroupContent
import dev.inmo.tgbotapi.types.message.content.AudioContent
import dev.inmo.tgbotapi.types.message.content.DocumentContent
import dev.inmo.tgbotapi.utils.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.buildJsonArray

const val rawSendingMediaGroupsWarning = "Media groups contains restrictions related to combinations of media" +
    " types. Currently it is possible to combine photo + video OR audio OR documents"

@RiskFeature(rawSendingMediaGroupsWarning)
fun <T : MediaGroupContent> SendMediaGroup(
    chatId: ChatIdentifier,
    media: List<MediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
): Request<List<MediaGroupMessage<T>>> {
    if (media.size !in mediaCountInMediaGroup) {
        throwRangeError("Count of members in media group", mediaCountInMediaGroup, media.size)
    }

    val files: List<MultipartFile> = media.flatMap {
        listOfNotNull(
            it.file as? MultipartFile,
            if (it is ThumbedTelegramMedia) {
                it.thumb as? MultipartFile
            } else {
                null
            }
        )
    }

    val data = SendMediaGroupData(
        chatId,
        media,
        disableNotification,
        protectContent,
        replyToMessageId,
        allowSendingWithoutReply
    )

    return (if (files.isEmpty()) {
        data
    } else {
        MultipartRequestImpl(
            data,
            SendMediaGroupFiles(files)
        )
    }) as Request<List<MediaGroupMessage<T>>>
}

/**
 * Use this method to be sure that you are correctly sending playlist with audios
 *
 * @see TelegramMediaAudio
 */
@Suppress("NOTHING_TO_INLINE")
inline fun SendPlaylist(
    chatId: ChatIdentifier,
    media: List<AudioMediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = SendMediaGroup<AudioContent>(chatId, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply)

/**
 * Use this method to be sure that you are correctly sending documents media group
 *
 * @see TelegramMediaDocument
 */
@Suppress("NOTHING_TO_INLINE")
inline fun SendDocumentsGroup(
    chatId: ChatIdentifier,
    media: List<DocumentMediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = SendMediaGroup<DocumentContent>(chatId, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply)

/**
 * Use this method to be sure that you are correctly sending visual media group
 *
 * @see TelegramMediaPhoto
 * @see TelegramMediaVideo
 */
@Suppress("NOTHING_TO_INLINE")
inline fun SendVisualMediaGroup(
    chatId: ChatIdentifier,
    media: List<VisualMediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = SendMediaGroup<VisualMediaGroupContent>(chatId, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply)

private val messagesListSerializer: KSerializer<List<MediaGroupMessage<MediaGroupContent>>>
    = ListSerializer(TelegramBotAPIMessageDeserializeOnlySerializerClass())

@Serializable
data class SendMediaGroupData internal constructor(
    @SerialName(chatIdField)
    override val chatId: ChatIdentifier,
    val media: List<MediaGroupMemberTelegramMedia> = emptyList(),
    @SerialName(disableNotificationField)
    override val disableNotification: Boolean = false,
    @SerialName(protectContentField)
    override val protectContent: Boolean = false,
    @SerialName(replyToMessageIdField)
    override val replyToMessageId: MessageIdentifier? = null,
    @SerialName(allowSendingWithoutReplyField)
    override val allowSendingWithoutReply: Boolean? = null
) : DataRequest<List<MediaGroupMessage<MediaGroupContent>>>, SendMessageRequest<List<MediaGroupMessage<MediaGroupContent>>> {
    @SerialName(mediaField)
    private val convertedMedia: String
        get() = buildJsonArray {
            media.forEach {
                add(it.toJsonWithoutNulls(MediaGroupMemberTelegramMediaSerializer))
            }
        }.toString()


    override fun method(): String = "sendMediaGroup"
    override val requestSerializer: SerializationStrategy<*>
        get() = serializer()
    override val resultDeserializer: DeserializationStrategy<List<MediaGroupMessage<MediaGroupContent>>>
        get() = messagesListSerializer
}

data class SendMediaGroupFiles internal constructor(
    val files: List<MultipartFile>
) : Files by (files.map { it.fileId to it }.toMap())
