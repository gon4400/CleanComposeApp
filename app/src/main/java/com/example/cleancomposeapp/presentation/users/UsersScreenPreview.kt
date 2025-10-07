package com.example.cleancomposeapp.presentation.users

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme

@Composable
private fun previewUsers() = listOf(
    UserUi(1, "Alice Martin", "alice@example.com"),
    UserUi(2, "Bruno Dupont", "bruno@acme.io"),
    UserUi(3, "Chloé Bernard", "chloe@dev.fr")
)

/** Liste (clair) */
@Preview(
    name = "Users - List (Light)",
    showBackground = true,
    device = "id:pixel_7"
)
@Composable
private fun UsersScreenPreview_List_Light() {
    MaterialTheme {
        UsersScreen(
            state = UsersState(
                isLoading = false,
                users = previewUsers(),
                error = null
            ),
            onRefresh = {},
            onOpen = {}
        )
    }
}

/** Liste (sombre) */
@Preview(
    name = "Users - List (Dark)",
    showBackground = true,
    device = "id:pixel_7",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun UsersScreenPreview_List_Dark() {
    MaterialTheme {
        UsersScreen(
            state = UsersState(
                isLoading = false,
                users = previewUsers(),
                error = null
            ),
            onRefresh = {},
            onOpen = {}
        )
    }
}

/** Loading */
@Preview(name = "Users - Loading", showBackground = true, device = "id:pixel_7")
@Composable
private fun UsersScreenPreview_Loading() {
    MaterialTheme {
        UsersScreen(
            state = UsersState(isLoading = true),
            onRefresh = {},
            onOpen = {}
        )
    }
}

/** Erreur */
@Preview(name = "Users - Error", showBackground = true, device = "id:pixel_7")
@Composable
private fun UsersScreenPreview_Error() {
    MaterialTheme {
        UsersScreen(
            state = UsersState(
                isLoading = false,
                users = emptyList(),
                error = "Oups, réseau indisponible"
            ),
            onRefresh = {},
            onOpen = {}
        )
    }
}
