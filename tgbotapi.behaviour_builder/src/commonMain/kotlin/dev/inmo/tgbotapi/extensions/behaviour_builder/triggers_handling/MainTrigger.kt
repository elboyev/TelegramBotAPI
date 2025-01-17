package dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling

import dev.inmo.micro_utils.coroutines.*
import dev.inmo.tgbotapi.extensions.behaviour_builder.*
import dev.inmo.tgbotapi.extensions.behaviour_builder.expectations.expectFlow
import dev.inmo.tgbotapi.extensions.behaviour_builder.utils.SimpleFilter
import dev.inmo.tgbotapi.extensions.behaviour_builder.utils.marker_factories.MarkerFactory
import dev.inmo.tgbotapi.types.update.abstracts.Update

internal suspend inline fun <BC : BehaviourContext, reified T> BC.on(
    markerFactory: MarkerFactory<in T, Any>,
    initialFilter: SimpleFilter<T>? = null,
    noinline subcontextUpdatesFilter: CustomBehaviourContextAndTwoTypesReceiver<BC, Boolean, T, Update>? = null,
    noinline scenarioReceiver: CustomBehaviourContextAndTypeReceiver<BC, Unit, T>,
    noinline updateToData: (Update) -> List<T>?
) = flowsUpdatesFilter.expectFlow(bot) {
    updateToData(it) ?.mapNotNull { data ->
        if (initialFilter ?.invoke(data) != false) it to data else null
    } ?: emptyList()
}.subscribeSafelyWithoutExceptionsAsync(
    scope,
    { markerFactory(it.second) }
) { (update, triggerData) ->
    createSubContextAndDoWithUpdatesFilter(
        stopOnCompletion = false
    ) {
        if (subcontextUpdatesFilter ?.invoke(this, triggerData, update) != false) {
            scenarioReceiver(triggerData)
        }
    }
}
