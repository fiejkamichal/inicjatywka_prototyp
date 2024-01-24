package org.mechanika.inicjatywka.game.presentation.initiative_phase

import kotlinx.coroutines.flow.Flow
import org.mechanika.inicjatywka.game.domain.model.phase.Phase

data class InitiativePhaseState(
    val currentPhase: Flow<Phase.Phases>
)