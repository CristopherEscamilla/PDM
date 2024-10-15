package com.example.pdm.java.activities.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pdm.R;
import com.example.pdm.adapters.MyAdapter;
import com.example.pdm.classes.Alumno;

import java.util.ArrayList;

public class MainListAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adapter_main);

        ListView listView = findViewById(R.id.list_view);

        ArrayList<Integer> notasJuan = new ArrayList<>();
        notasJuan.add(80);
        notasJuan.add(85);
        notasJuan.add(90);

        ArrayList<Alumno> listAlumnos = new ArrayList<>();
        listAlumnos.add(new Alumno("Juan", 20,notasJuan));
        listAlumnos.add(new Alumno("María", 22,notasJuan));
        listAlumnos.add(new Alumno("Pedro", 21,notasJuan));

        MyAdapter adapter = new MyAdapter(this, listAlumnos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Alumno alumno = (Alumno) parent.getItemAtPosition(position);
                Toast.makeText(MainListAdapterActivity.this, "Clic en el alumno: " + alumno.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}