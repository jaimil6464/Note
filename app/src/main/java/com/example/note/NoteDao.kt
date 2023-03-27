package com.example.note

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface NoteDao {

    @Insert
    fun addNote(note:NoteEntity)

    @Query("SELECT * FROM Note")
    fun  getNote():List<NoteEntity>

    @Update
    fun updateNote(note: NoteEntity)

}