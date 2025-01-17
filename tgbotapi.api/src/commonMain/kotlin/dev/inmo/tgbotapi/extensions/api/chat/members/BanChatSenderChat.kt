package dev.inmo.tgbotapi.extensions.api.chat.members

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.requests.chat.members.BanChatSenderChat
import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.chat.PublicChat

suspend fun TelegramBot.banChatSenderChat(
    chatId: ChatIdentifier,
    senderChatId: ChatId
) = execute(BanChatSenderChat(chatId, senderChatId))

suspend fun TelegramBot.banChatSenderChat(
    chat: PublicChat,
    senderChatId: ChatId
) = banChatSenderChat(chat.id, senderChatId)

suspend fun TelegramBot.banChatSenderChat(
    chatId: ChatId,
    senderChat: PublicChat
) = banChatSenderChat(chatId, senderChat.id)

suspend fun TelegramBot.banChatSenderChat(
    chat: PublicChat,
    senderChat: PublicChat,
) = banChatSenderChat(chat.id, senderChat)
