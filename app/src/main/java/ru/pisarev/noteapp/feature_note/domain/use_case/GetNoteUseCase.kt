package ru.pisarev.noteapp.feature_note.domain.use_case

import ru.pisarev.noteapp.feature_note.domain.model.Note
import ru.pisarev.noteapp.feature_note.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? = repository.getNoteById(id)
}