package com.example.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.note.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    companion object {
        lateinit var binding: ActivityMainBinding
        lateinit var db: NoteDB
        var notelist = ArrayList<NoteEntity>()

        fun update() {
            var list = db.notes().getNote()
            list = list.reversed()
            notelist.clear()
            for (l in list) {
                if (l.pinned) {
                    notelist.add(l)
                }
            }
            for (l in list) {
                if (!l.pinned) {
                    notelist.add(l)
                }
            }
            binding.recycle.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            binding.recycle.adapter = NotesAdapter(notelist)
        }

    }



override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    db = NoteDB.getInstances(this)

    binding.btnAdd.setOnClickListener {
        startActivity(Intent(this@MainActivity, AddNote::class.java))
    }

    update()
}


override fun onResume() {
    super.onResume()
    update()
}
}
