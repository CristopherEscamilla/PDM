package com.example.pdm.java.activities.lesson2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pdm.R;
import com.example.pdm.SourceActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity  {

    public static final String EXTRA_MESSAGE = "Second_Act";
    public static final int TEXT_REQUEST = 1;

    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
    private Button bttn_java;
    private Button bttn_xml;
    EditText editText;
    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activities_first);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mReplyHeadTextView = (TextView) findViewById(R.id.text_header_reply);
        mReplyTextView = (TextView) findViewById(R.id.text_message_reply);
        editText = findViewById(R.id.etx_texto_enviar);
        bttn_java = findViewById(R.id.bttn_java);
        bttn_xml = findViewById(R.id.bttn_xml);

        bttn_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SourceActivity.class);
                intent.putExtra("source", "java");
                intent.putExtra("name", "FirstActivity.java");
                startActivity(intent);
            }
        });

        bttn_xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SourceActivity.class);
                intent.putExtra("source", "xml");
                intent.putExtra("name", "activity_activities_first.xml");
                startActivity(intent);
            }
        });

    }

    public void saltarSegundaActividad(View view){
        Log.d(LOG_TAG,"Click en el boton enviar");
        ArrayList<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        Perro miPerro = new Perro("Ronni", 6, "Manchado");
        Galleta galleta = new Galleta("Chocolate", 5);

        String message = editText.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("key_integer", 123);
        intent.putExtra("key_boolean", true);
        intent.putExtra("key_float", 3.14f);
        intent.putExtra("key_double", 2.718);
        intent.putStringArrayListExtra("key_list", list);
        intent.putExtra("key_serializable_object", miPerro);
        intent.putExtra("galleta", galleta);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_REPLY);

                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }

    }

}
