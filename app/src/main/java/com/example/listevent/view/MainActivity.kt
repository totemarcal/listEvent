package com.example.listevent.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listevent.R
import com.example.listevent.adapter.ListEventAdapter
import com.example.listevent.model.Event
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter by lazy {
        ListEventAdapter(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity_lista_noticias_recyclerview.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        searchEvent()
    }

    private fun searchEvent() {
        val list = arrayListOf<Event>()
        val e1 = Event(1, "Maria", "maria@gmail.com")
        val e2 = Event(2, "Tulio", "tulio@gmail.com")
        val e3 = Event(3, "Cristina", "cristina@gmail.com")
        list.addAll(listOf(e1, e2, e3))
        adapter.atualiza(list)
    }

}