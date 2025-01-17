package dev.inmo.tgbotapi.extensions.utils.updates

import dev.inmo.tgbotapi.types.ChatId
import dev.inmo.tgbotapi.types.chat.Chat
import dev.inmo.tgbotapi.types.update.media_group.SentMediaGroupUpdate
import dev.inmo.tgbotapi.types.update.abstracts.BaseMessageUpdate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter

/**
 * [Flow.filter] incoming [BaseMessageUpdate]s by their [ChatId]
 */
fun <T : BaseMessageUpdate> Flow<T>.filterBaseMessageUpdatesByChatId(chatId: ChatId): Flow<T> = filter { it.data.chat.id == chatId }
/**
 * [Flow.filter] incoming [BaseMessageUpdate]s by their [ChatId] using [Chat.id] of [chat]
 */
fun <T : BaseMessageUpdate> Flow<T>.filterBaseMessageUpdatesByChat(chat: Chat): Flow<T> = filterBaseMessageUpdatesByChatId(chat.id)


/**
 * [Flow.filter] incoming [SentMediaGroupUpdate]s by their [ChatId]
 */
fun <T : SentMediaGroupUpdate> Flow<T>.filterSentMediaGroupUpdatesByChatId(chatId: ChatId): Flow<T> = filter { it.data.first().chat.id == chatId }
/**
 * [Flow.filter] incoming [SentMediaGroupUpdate]s by their [ChatId] using [Chat.id] of [chat]
 */
fun <T : SentMediaGroupUpdate> Flow<T>.filterSentMediaGroupUpdatesByChat(chat: Chat): Flow<T> = filterSentMediaGroupUpdatesByChatId(chat.id)
