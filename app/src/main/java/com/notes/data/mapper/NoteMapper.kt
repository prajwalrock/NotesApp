package com.notes.data.mapper

import com.notes.data.local.entity.NoteEntity
import com.notes.domain.model.Note

fun NoteEntity.asExternalModel(): Note = Note(
    id,title, content
)

fun Note.toEntity(): NoteEntity = NoteEntity(
    id,title, content
)