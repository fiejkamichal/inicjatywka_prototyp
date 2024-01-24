package org.mechanika.inicjatywka.game.presentation.components.character

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CharacterList (
    viewModel: CharacterViewModel
) {
    val cards = viewModel.state.cards.collectAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row {
            Text(
                text = "Karty Postaci (${cards.value.size})",
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
        cards.value.forEach {
            Character(it, viewModel)
        }
    }
}