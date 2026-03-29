package com.roy.rromeroarkanochallenge.presentation.ui.character

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.roy.rromeroarkanochallenge.R
import com.roy.rromeroarkanochallenge.domain.model.Character
import com.roy.rromeroarkanochallenge.domain.model.CharacterStatus
import com.roy.rromeroarkanochallenge.presentation.theme.RRomeroChallengeArkanoTheme
import kotlin.collections.map

@Composable
fun CharacterList(
    characters: List<Character>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = characters,
            key = { it.id }
        ) {
            CharacterItem(
                character = it,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = dimensionResource(R.dimen.padding_medium),
                        vertical = dimensionResource(R.dimen.padding_small)
                    )
            )
        }
    }
}

@Composable
fun CharacterItem(
    character: Character,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CharacterImage(
                imageUrl = character.imageUrl,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.image_size))
                    .padding(dimensionResource(R.dimen.padding_medium))
            )

            Text(
                text = character.name,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.weight(1f))

            val statusText = stringResource(
                when (character.status) {
                    CharacterStatus.ALIVE -> R.string.character_alive_string
                    CharacterStatus.DEATH -> R.string.character_death_string
                    CharacterStatus.UNKNOWN -> R.string.character_unknown_string
                }
            )

            val statusColor = when (character.status) {
                CharacterStatus.ALIVE -> Color.Blue
                CharacterStatus.DEATH -> Color.Red
                CharacterStatus.UNKNOWN -> Color.Gray
            }

            AssistChip(
                onClick = {},
                label = {
                    Text(
                        text = statusText,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Color.Transparent,
                    labelColor = statusColor
                ),
                border = BorderStroke(1.dp, statusColor),
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}

@Composable
fun CharacterImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val request = remember(imageUrl) {
        ImageRequest.Builder(context)
            .data(imageUrl)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .networkCachePolicy(CachePolicy.ENABLED)
            .build()
    }

    AsyncImage(
        model = request,
        contentDescription = null,
        placeholder = painterResource(R.drawable.placeholder_image),
        error = painterResource(R.drawable.not_found_image),
        modifier = modifier.clip(MaterialTheme.shapes.small)
    )
}

@Preview(showBackground = true)
@Composable
private fun CharactersListPrev() {
    RRomeroChallengeArkanoTheme {
        CharacterList(
            (1..15).map {
                Character(it, "Morty Smith $it", "", CharacterStatus.ALIVE)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterItemPrev() {
    RRomeroChallengeArkanoTheme {
        CharacterItem(
            Character(1, "Morty Smith", "", CharacterStatus.ALIVE),
            modifier = Modifier.padding(
                dimensionResource(R.dimen.padding_medium),
                dimensionResource(R.dimen.padding_small)
            )
        )
    }
}