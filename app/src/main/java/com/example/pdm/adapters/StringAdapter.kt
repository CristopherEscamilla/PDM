package com.example.pdm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pdm.R
import com.example.pdm.interfaces.OnItemClickListener


class StringAdapter(
    private val items: List<String>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<StringAdapter.StringViewHolder>() {

    // ViewHolder que mantiene la referencia a la vista de cada elemento
    class StringViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }

    // Crea nuevas vistas (invocado por el layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_string, parent, false)
        return StringViewHolder(view)
    }

    // Reemplaza el contenido de una vista (invocado por el layout manager)
    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item

        // Agregar el listener al holder
        holder.itemView.setOnClickListener {
            listener.onItemClick(item, position) // Delegar el clic al listener
        }
    }

    // Retorna el tamaño de tu dataset (invocado por el layout manager)
    override fun getItemCount() = items.size
}