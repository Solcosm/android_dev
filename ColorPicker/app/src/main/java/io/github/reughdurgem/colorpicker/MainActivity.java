package io.github.reughdurgem.colorpicker;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button color, color2, color3, color4, color5, color6, color7, confirmation;
    EditText customColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View as Main (Current)
        setContentView(R.layout.activity_main);
        // Custom Title
        setTitle("Color Configuration Station");
        // ID Definitions
        Button confirmation = (Button) findViewById(R.id.confirmation);
        Button color = (Button) findViewById(R.id.color);
        Button color2 = (Button) findViewById(R.id.color2);
        Button color3 = (Button) findViewById(R.id.color3);
        Button color4 = (Button) findViewById(R.id.color4);
        Button color5 = (Button) findViewById(R.id.color5);
        Button color6 = (Button) findViewById(R.id.color6);
        Button color7 = (Button) findViewById(R.id.color7);
        // Button Actions
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "Red";
                Uri uri = Uri.parse("https://www.google.com/search?q=" + query + " Color");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "Orange";
                Uri uri = Uri.parse("https://www.google.com/search?q=" + query + " Color");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "Yellow";
                Uri uri = Uri.parse("https://www.google.com/search?q=" + query + " Color");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        color4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "Green";
                Uri uri = Uri.parse("https://www.google.com/search?q=" + query + " Color");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        color5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "Blue";
                Uri uri = Uri.parse("https://www.google.com/search?q=" + query + " Color");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        color6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "Indigo";
                Uri uri = Uri.parse("https://www.google.com/search?q=" + query + " Color");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        color7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "Violet";
                Uri uri = Uri.parse("https://www.google.com/search?q=" + query + " Color");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        // Check to see if custom color is HEX_ENABLED
        // Custom Button Action
        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText customColor = (EditText) findViewById(R.id.customColor);
                final String inputColor = customColor.getText().toString();
                final Handler handler = new Handler();
                if (inputColor.length() == 6 && inputColor.matches("[A-F0-9]*")) {
                    Toast.makeText(MainActivity.this, "Generating Web View... ", Toast.LENGTH_SHORT).show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Uri uri = Uri.parse("https://www.google.com/search?q=" + "%23" + inputColor);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    }, 2500);
                } else if (!inputColor.matches("[A-F0-9]*")) {
                    Toast.makeText(MainActivity.this, "Syntax Error: A-F and 0-9 only", Toast.LENGTH_SHORT).show();
                } else if (inputColor.matches("[A-F0-9]*") && inputColor.length() >= 1 && inputColor.length() <= 6) {
                    Toast.makeText(MainActivity.this, "Six characters required", Toast.LENGTH_SHORT).show();
                } else if (inputColor.length() == 0) {
                    Toast.makeText(MainActivity.this, "Input required", Toast.LENGTH_SHORT).show();
                } else {
                    return;
                }
            }
        });
    }
}