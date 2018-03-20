package io.github.reughdurgem.buttoncontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    //Define Variables
    Button b;
    ToggleButton tb;
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mod Activity Header
        setTitle("Button Palooza");

        //Assign vars to layout IDs
        b = (Button)findViewById(R.id.button);
        tb = (ToggleButton)findViewById(R.id.toggleButton);
        ib = (ImageButton)findViewById(R.id.imageButton);

        //b Toast
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello! I'm a simple button!", Toast.LENGTH_SHORT).show();
            }
        });
        
        //tb Toast On/Off
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tb.isChecked()){
                    Toast.makeText(MainActivity.this, "I'm a toggle button. Click me again. I dare you.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "I can't believe you've done this...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //ib Toast
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "I'm an image button. I display cool images like this Rocket League logo. Copyright infringement not intended!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
