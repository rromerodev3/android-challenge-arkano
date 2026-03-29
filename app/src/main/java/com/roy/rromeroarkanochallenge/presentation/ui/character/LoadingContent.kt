package com.roy.rromeroarkanochallenge.presentation.ui.character

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.roy.rromeroarkanochallenge.R
import com.roy.rromeroarkanochallenge.presentation.theme.RRomeroChallengeArkanoTheme

@Composable
fun LoadingContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        Spacer(
            modifier = Modifier
                .height(dimensionResource(R.dimen.padding_larger))
        )
        Text(
            text = stringResource(R.string.loading_string),
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoadingContentPrev() {
    RRomeroChallengeArkanoTheme {
        LoadingContent()
    }
}