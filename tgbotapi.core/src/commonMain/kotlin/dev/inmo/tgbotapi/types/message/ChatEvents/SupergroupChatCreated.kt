package dev.inmo.tgbotapi.types.message.ChatEvents

import dev.inmo.tgbotapi.types.ChatId
import dev.inmo.tgbotapi.types.message.ChatEvents.abstracts.SupergroupEvent

class SupergroupChatCreated(
    val migratedFrom: ChatId?
): SupergroupEvent
