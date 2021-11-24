package com.dev.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.exam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var lEvents: List<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        lEvents = getEvents()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = EventsAdapter(lEvents)
        }

    }

    private fun getEvents() =
        assets.open(eventsTXT)
            .bufferedReader()
            .lineSequence()
            .map { str->
                str.split("|").let{
                    Event(
                        header = it[0],
                        date = it[1],
                        img = it[2]
                    )
                }

            }
            .toList().filterNotNull()


    companion object {
        const val eventsTXT = "data/events.txt"
    }

}