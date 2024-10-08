package com.example.pdm

import android.content.Context
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pdm.databinding.ActivitySourceBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class SourceActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySourceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars=insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val source = intent.getStringExtra("source")
        val namefile = intent.getStringExtra("name")
        binding.tvSource.movementMethod = ScrollingMovementMethod()

        if (source == "java") {
            // Lee el archivo .java desde assets
            val javaCode = readJavaFile(this, namefile.toString())
            // Muestra el código en el TextView
            binding.tvSource.text = javaCode
        }else{
            // Lee el archivo .xml desde assets
            val xmlCode = readJavaFile(this, namefile.toString())
            // Muestra el código en el TextView
            binding.tvSource.text = xmlCode
        }



    }

    fun readJavaFile(context: Context, fileName: String): String {
        val assetManager = context.assets
        val inputStream = assetManager.open(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()

        var line: String?
        while (reader.readLine().also { line = it } != null) {
            stringBuilder.append(line).append("\n")  // Añade saltos de línea
        }

        return stringBuilder.toString()
    }
}