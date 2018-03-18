package io.github.reughdurgem.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorMainActivity extends AppCompatActivity {

    //Definitions for variables
    EditText num1, num2;
    TextView result;
    Button add, sub, mult, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);

        //Changes Activity header
        setTitle("Michael's Awesome Android Calculator");

        //Assigning variables to their layout IDs
        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);

        result = (TextView)findViewById(R.id.result);

        add = (Button)findViewById(R.id.add);
        sub = (Button)findViewById(R.id.sub);
        mult = (Button)findViewById(R.id.mult);
        div = (Button)findViewById(R.id.div);

        //Add Button
        //Button OnClick func
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check to make sure the values are null
                if(num1.getText().length() != 0 && num2.getText().length() != 0){
                    //Math
                    double n1 = Double.parseDouble(num1.getText().toString());
                    double n2 = Double.parseDouble(num2.getText().toString());

                    double res = n1 + n2;

                    result.setText(String.valueOf(res));
                }
                else{
                    //Show toast(?) message. Like an alert.
                    Toast.makeText(view.getContext(),"Please enter both numbers",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Sub Button
        //Button OnClick func
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check to make sure the values are null
                if(num1.getText().length() != 0 && num2.getText().length() != 0){
                    //Math
                    double n1 = Double.parseDouble(num1.getText().toString());
                    double n2 = Double.parseDouble(num2.getText().toString());

                    double res = n1 - n2;

                    result.setText(String.valueOf(res));
                }
                else{
                    //Show toast(?) message. Like an alert.
                    Toast.makeText(view.getContext(),"Please enter both numbers",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Mult Button
        //Button OnClick func
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check to make sure the values are null
                if(num1.getText().length() != 0 && num2.getText().length() != 0){
                    //Math
                    double n1 = Double.parseDouble(num1.getText().toString());
                    double n2 = Double.parseDouble(num2.getText().toString());

                    double res = n1 * n2;

                    result.setText(String.valueOf(res));
                }
                else{
                    //Show toast(?) message. Like an alert.
                    Toast.makeText(view.getContext(),"Please enter both numbers",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Div Button
        //Button OnClick func
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check to make sure the values are null
                if(num1.getText().length() != 0 && num2.getText().length() != 0){
                    //Math
                    double n1 = Double.parseDouble(num1.getText().toString());
                    double n2 = Double.parseDouble(num2.getText().toString());

                    double res = n1 / n2;

                    result.setText(String.valueOf(res));
                }
                else{
                    //Show toast(?) message. Like an alert.
                    Toast.makeText(view.getContext(),"Please enter both numbers",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
