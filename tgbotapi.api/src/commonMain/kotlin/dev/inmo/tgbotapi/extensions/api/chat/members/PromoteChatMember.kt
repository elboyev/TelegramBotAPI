package dev.inmo.tgbotapi.extensions.api.chat.members

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.requests.chat.members.PromoteChatMember
import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.chat.PublicChat
import dev.inmo.tgbotapi.types.chat.User

suspend fun TelegramBot.promoteChatMember(
    chatId: ChatIdentifier,
    userId: UserId,
    untilDate: TelegramDate? = null,
    isAnonymous: Boolean? = null,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPinMessages: Boolean? = null,
    canPromoteMembers: Boolean? = null,
    canManageVideoChats: Boolean? = null,
    canManageChat: Boolean?
) = execute(
    PromoteChatMember(
        chatId,
        userId,
        untilDate,
        isAnonymous,
        canChangeInfo,
        canPostMessages,
        canEditMessages,
        canDeleteMessages,
        canInviteUsers,
        canRestrictMembers,
        canPinMessages,
        canPromoteMembers,
        canManageVideoChats,
        canManageChat
    )
)

suspend fun TelegramBot.promoteChatMember(
    chat: PublicChat,
    userId: UserId,
    untilDate: TelegramDate? = null,
    isAnonymous: Boolean? = null,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPinMessages: Boolean? = null,
    canPromoteMembers: Boolean? = null,
    canManageVideoChats: Boolean? = null,
    canManageChat: Boolean? = null
) = promoteChatMember(
    chat.id,
    userId,
    untilDate,
    isAnonymous,
    canChangeInfo,
    canPostMessages,
    canEditMessages,
    canDeleteMessages,
    canInviteUsers,
    canRestrictMembers,
    canPinMessages,
    canPromoteMembers,
    canManageVideoChats,
    canManageChat
)

suspend fun TelegramBot.promoteChatMember(
    chatId: ChatId,
    user: User,
    untilDate: TelegramDate? = null,
    isAnonymous: Boolean? = null,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPinMessages: Boolean? = null,
    canPromoteMembers: Boolean? = null,
    canManageVideoChats: Boolean? = null,
    canManageChat: Boolean? = null
) = promoteChatMember(
    chatId,
    user.id,
    untilDate,
    isAnonymous,
    canChangeInfo,
    canPostMessages,
    canEditMessages,
    canDeleteMessages,
    canInviteUsers,
    canRestrictMembers,
    canPinMessages,
    canPromoteMembers,
    canManageVideoChats,
    canManageChat
)

suspend fun TelegramBot.promoteChatMember(
    chat: PublicChat,
    user: User,
    untilDate: TelegramDate? = null,
    isAnonymous: Boolean? = null,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPinMessages: Boolean? = null,
    canPromoteMembers: Boolean? = null,
    canManageVideoChats: Boolean? = null,
    canManageChat: Boolean? = null
) = promoteChatMember(
    chat.id,
    user.id,
    untilDate,
    isAnonymous,
    canChangeInfo,
    canPostMessages,
    canEditMessages,
    canDeleteMessages,
    canInviteUsers,
    canRestrictMembers,
    canPinMessages,
    canPromoteMembers,
    canManageVideoChats,
    canManageChat
)
