package com.example.notasv2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * from notes WHERE id = :id")
    fun getItem(id: Int): Flow<Note>

    @Query("SELECT * from notes ORDER BY id ASC")
    fun getAllItems(): Flow<List<Note>>
}
