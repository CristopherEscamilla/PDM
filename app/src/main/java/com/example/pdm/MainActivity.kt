package com.example.pdm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pdm.adapters.StringAdapter
import com.example.pdm.databinding.ActivityMainBinding
import com.example.pdm.interfaces.OnItemClickListener
import com.example.pdm.java.activities.lesson2.FirstActivity
import com.example.pdm.providers.SubtemasProvider

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars=insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter= StringAdapter(SubtemasProvider.lesson2Activities,this)
    }

    // Implementar el método de la interfaz OnItemClickListener
    override fun onItemClick(item: String, position: Int) {
        // Aquí puedes manejar lo que sucede al hacer clic en un ítem

        if(position==0){
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Clic en $item", Toast.LENGTH_SHORT).show()
        }

    }
}