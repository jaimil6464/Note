package com.example.note

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.note.databinding.ActivityAddNoteBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AddNote : AppCompatActivity() {

    lateinit var binding: ActivityAddNoteBinding
    var selectColar = 0

    lateinit var db: NoteDB


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDB.getInstances(this)

        binding.btnsave.setOnClickListener {

            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss a")
            val current = LocalDateTime.now().format(formatter)

            var note = NoteEntity(
                binding.edttitle.text.toString(),
                binding.edtnote.text.toString(), current, selectColar, false
            )
            db.notes().addNote(note)
            finish()
        }





        }
    }

