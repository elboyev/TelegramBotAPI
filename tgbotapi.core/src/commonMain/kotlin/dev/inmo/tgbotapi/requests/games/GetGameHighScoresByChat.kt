package dev.inmo.tgbotapi.requests.games

import dev.inmo.tgbotapi.abstracts.types.MessageAction
import dev.inmo.tgbotapi.requests.games.abstracts.GetGameHighScores
import dev.inmo.tgbotapi.types.*
import kotlinx.serialization.*

@Serializable
data class GetGameHighScoresByChat (
    @SerialName(userIdField)
    override val userId: UserId,
    @SerialName(chatIdField)
    override val chatId: ChatId,
    @SerialName(messageIdField)
    override val messageId: MessageIdentifier
) : GetGameHighScores, MessageAction {
    override val requestSerializer: SerializationStrategy<*>
        get() = serializer()
}
