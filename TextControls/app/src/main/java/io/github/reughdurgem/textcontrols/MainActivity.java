package io.github.reughdurgem.textcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView active;
    MultiAutoCompleteTextView activer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Text-tastic!");

        //AutoCompleteTextView Code
        active = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new String[] {"Rocket League!"});
        active.setAdapter(aa);

        //MultiAutoCompleteTextView Code
        activer = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);
        ArrayAdapter<String> aa2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new String[] {"Microsoft Windows", "macOS", "Linux", "PlayStation 4", "Xbox One", "Nintendo Switch"});
        activer.setAdapter(aa2);
        activer.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
