package dev.inmo.tgbotapi.types

import dev.inmo.micro_utils.language_codes.IetfLanguageCode
import dev.inmo.tgbotapi.types.abstracts.WithOptionalLanguageCode
import java.util.*

fun IetfLanguageCode?.javaLocale() = this ?.code ?.let { Locale.forLanguageTag(it) }
fun WithOptionalLanguageCode?.javaLocale() = this ?.ietfLanguageCode ?.javaLocale()
