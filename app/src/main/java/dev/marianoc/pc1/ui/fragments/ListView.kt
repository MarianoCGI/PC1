package dev.marianoc.pc1.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.marianoc.pc1.R

class ListView : AppCompatActivity() {
    var arrSO = arrayOf("Manchester United","Barcelona FC","Liverpool","Real Madrid", "Juventus",
        "Pumas UNAM", "La U", "Flamengo", "Boca", "River Plate")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lvsEqui: ListView = findViewById<View>(R.id.lvsEqui) as ListView
        val adaptador: Any? =
            ArrayAdapter<Any?>(this,android.R.layout.simple_list_item_1,arrSO)
        lvsEqui.adapter = adaptador as ListAdapter?

        lvsEqui.setOnItemClickListener(){ parent, view, position, id ->
            Toast.makeText(
                applicationContext,
                "Position: $position",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}