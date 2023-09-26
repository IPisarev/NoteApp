package ru.pisarev.noteapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.pisarev.noteapp.feature_note.data.data_source.NoteDao
import ru.pisarev.noteapp.feature_note.data.data_source.NoteDataBase
import ru.pisarev.noteapp.feature_note.data.repository.NoteRepositoryImpl
import ru.pisarev.noteapp.feature_note.domain.repository.NoteRepository
import ru.pisarev.noteapp.feature_note.domain.use_case.DeleteNotesUseCase
import ru.pisarev.noteapp.feature_note.domain.use_case.GetNotesUseCase
import ru.pisarev.noteapp.feature_note.domain.use_case.NoteUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDataBase {
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDataBase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNotesUseCase = DeleteNotesUseCase(repository)
        )
    }
}