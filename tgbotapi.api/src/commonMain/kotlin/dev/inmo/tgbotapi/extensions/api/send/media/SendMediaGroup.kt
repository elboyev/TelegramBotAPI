package dev.inmo.tgbotapi.extensions.api.send.media

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.requests.send.media.*
import dev.inmo.tgbotapi.types.ChatIdentifier
import dev.inmo.tgbotapi.types.media.*
import dev.inmo.tgbotapi.types.MessageIdentifier
import dev.inmo.tgbotapi.types.chat.Chat
import dev.inmo.tgbotapi.types.message.content.MediaGroupContent
import dev.inmo.tgbotapi.types.message.content.VisualMediaGroupContent
import dev.inmo.tgbotapi.types.message.content.AudioContent
import dev.inmo.tgbotapi.types.message.content.DocumentContent
import dev.inmo.tgbotapi.utils.RiskFeature
import kotlin.jvm.JvmName

/**
 * @see SendMediaGroup
 */
@RiskFeature(rawSendingMediaGroupsWarning)
suspend fun TelegramBot.sendMediaGroup(
    chatId: ChatIdentifier,
    media: List<MediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = execute(
    SendMediaGroup<MediaGroupContent>(
        chatId, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
    )
)

/**
 * @see SendMediaGroup
 */
@RiskFeature(rawSendingMediaGroupsWarning)
suspend fun TelegramBot.sendMediaGroup(
    chat: Chat,
    media: List<MediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendMediaGroup(
    chat.id, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)

/**
 * @see SendMediaGroup
 */
@RiskFeature(rawSendingMediaGroupsWarning)
@JvmName("sendMedaGroupByContent")
suspend fun TelegramBot.sendMediaGroup(
    chatId: ChatIdentifier,
    media: List<MediaGroupContent>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendMediaGroup(
    chatId, media.map { it.toMediaGroupMemberTelegramMedia() }, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)

/**
 * @see SendMediaGroup
 */
@RiskFeature(rawSendingMediaGroupsWarning)
@JvmName("sendMedaGroupByContent")
suspend fun TelegramBot.sendMediaGroup(
    chat: Chat,
    media: List<MediaGroupContent>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendMediaGroup(
    chat.id, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)

/**
 * @see SendPlaylist
 */
suspend fun TelegramBot.sendPlaylist(
    chatId: ChatIdentifier,
    media: List<AudioMediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = execute(
    SendPlaylist(
        chatId, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
    )
)

/**
 * @see SendPlaylist
 */
suspend fun TelegramBot.sendPlaylist(
    chat: Chat,
    media: List<AudioMediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendPlaylist(
    chat.id, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)

/**
 * @see SendPlaylist
 */
@JvmName("sendPlaylistByContent")
suspend fun TelegramBot.sendPlaylist(
    chatId: ChatIdentifier,
    media: List<AudioContent>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendPlaylist(
    chatId, media.map { it.toMediaGroupMemberTelegramMedia() }, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)

/**
 * @see SendPlaylist
 */
@JvmName("sendPlaylistByContent")
suspend fun TelegramBot.sendPlaylist(
    chat: Chat,
    media: List<AudioContent>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendPlaylist(
    chat.id, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)

/**
 * @see SendDocumentsGroup
 */
suspend fun TelegramBot.sendDocumentsGroup(
    chatId: ChatIdentifier,
    media: List<DocumentMediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = execute(
    SendDocumentsGroup(
        chatId, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
    )
)

/**
 * @see SendDocumentsGroup
 */
suspend fun TelegramBot.sendDocumentsGroup(
    chat: Chat,
    media: List<DocumentMediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendDocumentsGroup(
    chat.id, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)

/**
 * @see SendDocumentsGroup
 */
@JvmName("sendDocumentsByContent")
suspend fun TelegramBot.sendDocumentsGroup(
    chatId: ChatIdentifier,
    media: List<DocumentContent>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendDocumentsGroup(
    chatId, media.map { it.toMediaGroupMemberTelegramMedia() }, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)

/**
 * @see SendDocumentsGroup
 */
@JvmName("sendDocumentsByContent")
suspend fun TelegramBot.sendDocumentsGroup(
    chat: Chat,
    media: List<DocumentContent>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendDocumentsGroup(
    chat.id, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)

/**
 * @see SendVisualMediaGroup
 */
suspend fun TelegramBot.sendVisualMediaGroup(
    chatId: ChatIdentifier,
    media: List<VisualMediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = execute(
    SendVisualMediaGroup(
        chatId, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
    )
)

/**
 * @see SendVisualMediaGroup
 */
suspend fun TelegramBot.sendVisualMediaGroup(
    chat: Chat,
    media: List<VisualMediaGroupMemberTelegramMedia>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendVisualMediaGroup(
    chat.id, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)

/**
 * @see SendVisualMediaGroup
 */
@JvmName("sendVisualMediaGroupByContent")
suspend fun TelegramBot.sendVisualMediaGroup(
    chatId: ChatIdentifier,
    media: List<VisualMediaGroupContent>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendVisualMediaGroup(
    chatId, media.map { it.toMediaGroupMemberTelegramMedia() }, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)

/**
 * @see SendVisualMediaGroup
 */
@JvmName("sendVisualMediaGroupByContent")
suspend fun TelegramBot.sendVisualMediaGroup(
    chat: Chat,
    media: List<VisualMediaGroupContent>,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    allowSendingWithoutReply: Boolean? = null
) = sendVisualMediaGroup(
    chat.id, media, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply
)
