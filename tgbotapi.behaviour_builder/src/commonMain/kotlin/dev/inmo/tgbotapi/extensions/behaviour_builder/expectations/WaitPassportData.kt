package dev.inmo.tgbotapi.extensions.behaviour_builder.expectations

import dev.inmo.tgbotapi.extensions.behaviour_builder.BehaviourContext
import dev.inmo.tgbotapi.extensions.behaviour_builder.utils.SimpleFilter
import dev.inmo.tgbotapi.extensions.utils.asMessageUpdate
import dev.inmo.tgbotapi.extensions.utils.asPassportMessage
import dev.inmo.tgbotapi.requests.abstracts.Request
import dev.inmo.tgbotapi.types.message.PassportMessage
import dev.inmo.tgbotapi.types.passport.PassportData
import dev.inmo.tgbotapi.types.passport.encrypted.abstracts.EncryptedPassportElement
import dev.inmo.tgbotapi.utils.RiskFeature
import dev.inmo.tgbotapi.utils.lowLevelRiskFeatureMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList

typealias PassportMessageMapper = suspend PassportMessage.() -> PassportData

@RiskFeature(lowLevelRiskFeatureMessage)
suspend inline fun <reified O : EncryptedPassportElement> BehaviourContext.waitPassportMessagesWith(
    initRequest: Request<*>? = null,
    noinline errorFactory: NullableRequestBuilder<*> = { null }
): Flow<O> = expectFlow(
    initRequest,
    errorFactory
) {
    it.asMessageUpdate() ?.data ?.asPassportMessage() ?.passportData ?.data ?.filterIsInstance<O>() ?: emptyList()
}

suspend fun BehaviourContext.waitAnyPassportMessages(
    initRequest: Request<*>? = null,
    errorFactory: NullableRequestBuilder<*> = { null }
) = waitPassportMessagesWith<EncryptedPassportElement>(initRequest, errorFactory)
