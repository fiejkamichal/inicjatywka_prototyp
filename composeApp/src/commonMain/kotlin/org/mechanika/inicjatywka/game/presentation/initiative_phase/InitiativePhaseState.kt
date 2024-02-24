package org.mechanika.inicjatywka.game.presentation.initiative_phase

import kotlinx.coroutines.flow.Flow
import org.mechanika.inicjatywka.game.domain.model.engine.Engine

data class InitiativePhaseState(
    val currentPhase: Flow<Engine.Phases>,
    val currentCardId: Flow<Long?>
)