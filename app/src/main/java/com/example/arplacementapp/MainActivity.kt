package com.example.arplacementapp


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.arplacementapp.databinding.ActivityMainBinding
import com.example.arplacementapp.model.Drill

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val drills = listOf(
        Drill("Drill 1", "Description for Drill 1", "Tip: Stay focused."),
        Drill("Drill 2", "Description for Drill 2", "Tip: Watch your posture."),
        Drill("Drill 3", "Description for Drill 3", "Tip: Keep a steady hand.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, drills.map { it.name })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.drillSpinner.adapter = adapter

        binding.drillSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(
                parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long
            ) {
                val selectedDrill = drills[position]
                binding.drillDescription.text =
                    "${selectedDrill.description}\n\n${selectedDrill.tips}"
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.startArButton.setOnClickListener {
            val intent = Intent(this, ArActivity::class.java)
            startActivity(intent)
        }
    }
}
