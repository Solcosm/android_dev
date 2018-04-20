package io.github.reughdurgem.birthdaywidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Widget Information Kiosk");

//        // Calculate number of days from two dates
//        SimpleDateFormat format = new SimpleDateFormat("MM/DD/YYYY");
//        String input1 = "1/1/2000";
//        String input2 = "4/18/2018";
//        try {
//            Date date1 = format.parse(input1);
//            Date date2 = format.parse(input2);
//            long diff = date2.getTime() - date1.getTime();
//
//            Toast.makeText(this, ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)), Toast.LENGTH_SHORT).show();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


    }
}
