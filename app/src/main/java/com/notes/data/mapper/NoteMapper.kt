package com.notes.data.mapper

import com.notes.data.local.entity.NoteEntity
import com.notes.domain.model.Note

/***
 * This is a extension function to map the values from Data layer
 * to Domain layer
 * i.e. it is taking data from Entity an mapping those values to Domain Layer
 */

fun NoteEntity.asExternalModel(): Note = Note(
    id,title, content
)

/***
 * this is extension function that I'm doing here to map the values
 * received from Domain Layer to Data Layer
 */

fun Note.toEntity(): NoteEntity = NoteEntity(
    id,title, content
)