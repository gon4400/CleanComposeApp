package com.example.cleancomposeapp.presentation.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UsersRoute(
    vm: UsersViewModel,
    onOpenDetail: (Long) -> Unit
) {
    val state = vm.state.collectAsState().value
    UsersScreen(
        state = state,
        onRefresh = { vm.dispatch(UsersIntent.Refresh) },
        onOpen = onOpenDetail
    )
}

@Composable
fun UsersScreen(
    state: UsersState,
    onRefresh: () -> Unit,
    onOpen: (Long) -> Unit
) {
    Scaffold(
        topBar = { PlainAppBar(title = "Users", onRefresh = onRefresh) }
    ) { padding ->
        Box(Modifier.padding(padding).fillMaxSize()) {
            when {
                state.isLoading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
                state.error != null -> Text(
                    text = "Erreur: ${state.error}",
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.bodyLarge
                )
                else -> LazyColumn {
                    items(state.users) { u ->
                        UserRow(
                            user = u,
                            onClick = onOpen,
                            modifier = Modifier.fillMaxWidth()
                        )
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}

@Composable
private fun UserRow(
    user: UserUi,
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable { onClick(user.id) }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Text(
                text = user.title,
                style = MaterialTheme.typography.titleMedium
            )
            if (user.subtitle.isNotBlank()) {
                Text(
                    text = user.subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
