package ru.pisarev.noteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.pisarev.noteapp.ui.theme.BabyBlue
import ru.pisarev.noteapp.ui.theme.LightGreen
import ru.pisarev.noteapp.ui.theme.RedOrange
import ru.pisarev.noteapp.ui.theme.RedPink
import ru.pisarev.noteapp.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {    companion object {
        val noteColors = listOf(RedOrange, RedPink, BabyBlue, Violet, LightGreen)
    }
}

class InvalidNoteException(message: String): Exception(message)
