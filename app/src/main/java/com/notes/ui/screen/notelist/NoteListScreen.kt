package com.notes.ui.screen.notelist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.notes.domain.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(
    noteList: List<Note>,
    onNoteClick: (Note) -> Unit,
    onAddNoteClick: () -> Unit
) {
    
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddNoteClick() }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add Button"
                )
            }
        }
    ) { padding ->
        
        LazyColumn(
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                bottom = 15.dp + padding.calculateBottomPadding(),
                top = 15.dp + padding.calculateTopPadding()
            )
        ){
            item {
                Text(
                    text = "Notes",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            items(noteList) { note ->
                ListItem(
                    headlineText = {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.titleMedium)
                    },
                    supportingText = {
                        Text(
                            text = note.content,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                             )
                    },
                    modifier = Modifier
                        .background(Color.LightGray)
                        .clickable(onClick = {
                            onNoteClick(note)
                        }),
                    trailingContent = {
                        Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Edit option")
                    },
                    shadowElevation = 50.dp,
                )

                Spacer(modifier = Modifier.height(10.dp))

            }
        }
        
    }
    
}