package ru.pisarev.noteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.pisarev.noteapp.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDataBase: RoomDatabase() {

    abstract val noteDao: NoteDao
    companion object {
        const val DATABASE_NAME = "notes.db"
    }
}