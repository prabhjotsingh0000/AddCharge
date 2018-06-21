package com.example.prabhjot.addcharge;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout linearLayout = findViewById(R.id.linear_layout);
        final EditText editText = new EditText(this);
        editText.setHint(R.string.procedure_code);

        final LinearLayout.LayoutParams editTextParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        editText.setLayoutParams(editTextParams);

        editText.setTextSize(14);
        editText.setTextColor(getResources().getColor(R.color.dusky_blue_two));


        final TextInputLayout textInputLayout = new TextInputLayout(this);
        final LinearLayout.LayoutParams textInputLayoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        textInputLayoutParams.setMargins(0,0,0,100);
        textInputLayout.setLayoutParams(textInputLayoutParams);
        textInputLayout.addView(editText, editTextParams);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.notes_button:
                        linearLayout.removeView(textInputLayout);
                        break;
                    case R.id.procedures_button:
                        linearLayout.addView(textInputLayout, textInputLayoutParams);
                        break;
                }
            }
        });

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getBaseContext(), "Charge added successfully" , Toast.LENGTH_SHORT );
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        });
    }

}
