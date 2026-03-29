package com.roy.rromeroarkanochallenge.presentation.ui.character

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roy.rromeroarkanochallenge.R
import com.roy.rromeroarkanochallenge.presentation.theme.RRomeroChallengeArkanoTheme

@Composable
fun ErrorContent(
    modifier: Modifier = Modifier,
    onRetry: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_larger)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.internet_error_image),
            contentDescription = null
        )
        Spacer(
            modifier = Modifier
                .height(dimensionResource(R.dimen.height_spacer))
        )
        Text(
            text = stringResource(R.string.error_string),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(
            modifier = Modifier
                .height(dimensionResource(R.dimen.height_spacer))
        )
        Button(
            onClick = onRetry,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text(
                text = stringResource(R.string.retry_btn),
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ErrorContentPrev() {
    RRomeroChallengeArkanoTheme {
        ErrorContent(
            onRetry = {}
        )
    }
}