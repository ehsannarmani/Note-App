package ir.ehsan.asmrnoteapp.repositories

import ir.ehsan.asmrnoteapp.database.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepo {
    suspend fun addNote(note:NoteEntity)
    suspend fun deleteNote(note: NoteEntity)
    suspend fun getNotes():Flow<List<NoteEntity>>
}