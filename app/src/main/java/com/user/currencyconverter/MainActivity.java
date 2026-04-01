package com.user.currencyconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    EditText et1;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        et1=findViewById(R.id.et1);
        spinner=findViewById(R.id.spinner);
        et1.setText("1");

        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this,R.array.conversions, R.layout.spinner_item);
        ad.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                String edittext;
                switch(text)
                {
                    case "Rupees to Dollars":
                        tv1.setText("Rupees");
                        tv2.setText("Dollars");
                        edittext= et1.getText().toString().trim();
                        if (!edittext.isEmpty())
                        {
                            float val = Float.parseFloat(edittext);
                            float conversion = (float) (val * 0.011);
                            tv3.setText(String.valueOf(conversion));
                        }
                        recalculate(0.011F);
                        break;
                    case "Dollars to Rupees":
                        tv1.setText("Dollars");
                        tv2.setText("Rupees");
                        edittext= et1.getText().toString().trim();
                        if (!edittext.isEmpty())
                        {
                            float val = Float.parseFloat(edittext);
                            float conversion = (float) (val * 93.72);
                            tv3.setText(String.valueOf(conversion));
                        }
                        recalculate(93.72F);
                        break;
                    case "Rupees to Yen":
                        tv1.setText("Rupees");
                        tv2.setText("Yen");
                        edittext= et1.getText().toString().trim();
                        if (!edittext.isEmpty())
                        {
                            float val = Float.parseFloat(edittext);
                            float conversion = (float) (val * 1.69);
                            tv3.setText(String.valueOf(conversion));
                        }
                        recalculate(1.69F);
                        break;
                    case "Yen to Rupees":
                        tv1.setText("Yen");
                        tv2.setText("Rupees");
                        edittext= et1.getText().toString().trim();
                        if (!edittext.isEmpty())
                        {
                            float val = Float.parseFloat(edittext);
                            float conversion = (float) (val * 0.59);
                            tv3.setText(String.valueOf(conversion));
                        }
                        recalculate(0.59F);
                        break;
                    case "Rupees to Peso":
                        tv1.setText("Rupees");
                        tv2.setText("Peso");
                        edittext= et1.getText().toString().trim();
                        if (!edittext.isEmpty())
                        {
                            float val = Float.parseFloat(edittext);
                            float conversion = (float) (val * 0.64);
                            tv3.setText(String.valueOf(conversion));
                        }
                        recalculate(0.64F);
                        break;
                    case "Peso to Rupees":
                        tv1.setText("Peso");
                        tv2.setText("Rupees");
                        edittext= et1.getText().toString().trim();
                        if (!edittext.isEmpty())
                        {
                            float val = Float.parseFloat(edittext);
                            float conversion = (float) (val * 1.55);
                            tv3.setText(String.valueOf(conversion));
                        }
                        recalculate(1.55F);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    void recalculate(float rate)
    {
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString().trim();
                if (input.isEmpty())
                {
                    tv3.setText("");
                }
                else
                {
                    float val = Float.parseFloat(input);
                    float conversion = (float) (val * rate);
                    tv3.setText(String.valueOf(conversion));
                }
            }
        });
    }
}