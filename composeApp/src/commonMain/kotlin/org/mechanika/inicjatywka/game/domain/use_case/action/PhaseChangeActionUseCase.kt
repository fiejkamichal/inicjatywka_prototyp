package org.mechanika.inicjatywka.game.domain.use_case.action

import org.mechanika.inicjatywka.game.domain.model.action.Action
import org.mechanika.inicjatywka.game.domain.model.action.PhaseChangeAction
import org.mechanika.inicjatywka.game.domain.repository.ActionRepository
import org.mechanika.inicjatywka.game.domain.repository.PhaseRepository
import org.mechanika.inicjatywka.game.domain.use_case.phase.changePhase

class PhaseChangeActionUseCase(
    private val phaseRepository: PhaseRepository,
    private val actionRepository: ActionRepository
) : ActionUseCase {
    override fun undo(action: Action) {
        val a = action as? PhaseChangeAction
        if (a != null) changePhase(
            to = a.from,
            repository = phaseRepository
        )
    }

    override fun redo(action: Action) {
        val a = action as? PhaseChangeAction
        if (a != null) changePhase(
            to = a.to,
            repository = phaseRepository
        )
    }

    override fun delete(action: Action) {
        val actionId = action.id
        if (actionId != null) actionRepository.deletePhaseChangeAction(actionId)
    }

    override fun insert(action: Action): Long {
        val actionId = actionRepository.insertPhaseChangeAction(action as PhaseChangeAction)
        action.id = actionId
        return actionId
    }

    override fun get(id: Long): Action? {
        return actionRepository.getPhaseChangeAction(id)
    }


}