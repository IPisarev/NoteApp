package ru.pisarev.noteapp.feature_note.domain.use_case

import ru.pisarev.noteapp.feature_note.domain.model.InvalidNoteException
import ru.pisarev.noteapp.feature_note.domain.model.Note
import ru.pisarev.noteapp.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()) {
            throw InvalidNoteException("The node's title can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The node's content can't be empty.")
        }
        repository.insertNote(note)
    }
}