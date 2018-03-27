package io.github.reughdurgem.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //Declare variables
    private ListView listView;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SetTitle
        setTitle("Colorful List");

        //Set variable (bit redundant)
        listView = (ListView)findViewById(R.id.listView);

        //String containing list items
        String[] colors = new String[] {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet", "Black", "White"};
        //Add colors to array
        ArrayList<String> colorArrayList = new ArrayList<String>();
        colorArrayList.addAll(Arrays.asList(colors));
        //Set listAdapter as previous array and set list style
            //Simple_list = list style; In this case it's for checked lists
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, colorArrayList);
        //Setting adapter
        listView.setAdapter(listAdapter);
        //Setting list choice mode
        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);

        //REDUNDANT CODE BELOW
        /*//Enabling taps to send messages
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String listItemValue = (String) listView.getItemAtPosition(position);
                        Toast.makeText(MainActivity.this, "The color you chose is: " + listItemValue, Toast.LENGTH_SHORT).show();
                    }
                }
        );*/
        //REDUNDANT CODE ABOVE
    }
    //Get list item and position of item when button pressed
    public void doClick(View view) {
        int count=listView.getCount();
        SparseBooleanArray viewItems = listView.getCheckedItemPositions();
        for(int i=0; i<count; i++) {
            if(viewItems.get(i)) {
                String selectedColor = (String) listView.getItemAtPosition(i);
                Toast.makeText(this, selectedColor + " is checked at position " + i, Toast.LENGTH_SHORT).show();
                //Outputs to log
                /*Log.v("ListViewDemo", selectedColor + " is checked at position " + i);*/
            }
        }
    }
}