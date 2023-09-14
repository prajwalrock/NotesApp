package com.notes.data.repository

import com.notes.data.local.dao.NoteDao
import com.notes.data.mapper.asExternalModel
import com.notes.data.mapper.toEntity
import com.notes.domain.model.Note
import com.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes().map { notes -> //I'm confused here how this is working "map" keyword
                notes.map {
                    it.asExternalModel()
                }
        }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)?.asExternalModel()
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note.toEntity())
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note.toEntity())
    }

    override suspend fun updateNote(note: Note) {
        dao.updateNote(note.toEntity())
    }
}