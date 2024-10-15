package com.example.pdm.java.activities.lesson2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pdm.R;
import com.example.pdm.SourceActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";
    private Button bttn_java;
    private Button bttn_xml;
    TextView txt_array;
    TextView txt_serializable;
    TextView txt_parceable;
    EditText txt_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lesson2_second);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bttn_java = findViewById(R.id.bttn_java);
        bttn_xml = findViewById(R.id.bttn_xml);
        txt_mensaje = findViewById(R.id.tv_respuesta);
        txt_array = findViewById(R.id.tv_array);
        txt_serializable = findViewById(R.id.tv_serializable);
        txt_parceable = findViewById(R.id.tv_parceable);

        Intent intent = getIntent();
        String message =
                intent.getStringExtra(FirstActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(message);


        ArrayList<String> array = (ArrayList<String>) intent.getStringArrayListExtra("key_list");
        txt_array.setText(array.get(0));

        Perro perro = (Perro) intent.getSerializableExtra("key_serializable_object");
        txt_serializable.setText(perro.getNombre());

        Galleta galleta = getIntent().getParcelableExtra("galleta");
        if (galleta != null) {
            txt_parceable.setText(galleta.getSabor());
        }

        bttn_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, SourceActivity.class);
                intent.putExtra("source", "java");
                intent.putExtra("name", "SecondActivity.java");
                startActivity(intent);
            }
        });

        bttn_xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, SourceActivity.class);
                intent.putExtra("source", "xml");
                intent.putExtra("name", "activity_activities_second.xml");
                startActivity(intent);
            }
        });

    }

    public void returnReply(View view) {
        String reply = txt_mensaje.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}