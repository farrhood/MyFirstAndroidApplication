package ninja.farhood.myfirstandroidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_compute = (Button) findViewById(R.id.btn_compute);
        final EditText edit_height = (EditText) findViewById(R.id.edit_height);
        final EditText edit_weight = (EditText) findViewById(R.id.edit_weight);
        final TextView txt_result = (TextView) findViewById(R.id.txt_result);

        btn_compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = edit_height.getText().toString();
                String weight = edit_weight.getText().toString();

                if (height.length() > 0 && weight.length() > 0) {

                    float heightValue = Float.parseFloat(height);
                    float weightValue = Float.parseFloat(weight);
                    String result = calculateBMI(weightValue, heightValue);
                    txt_result.setText(result);

                }
            }
        });

        Button btn_clear =(Button) findViewById(R.id.btn_clear);

        btn_clear.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                edit_height.setText("");
                edit_weight.setText("");
                txt_result.setText("");

            }
        });
    }

    private String calculateBMI(float weight, float height) {
        height = (height / 100);
        float BMI = weight / (height * height);
        String result;

        if (BMI < 16) {
            result = "Your BMI: " + BMI + " (Severely underweight)";
        } else if (BMI < 18.5) {
            result = "Your BMI: " + BMI + " (Underweight)";
        } else if (BMI < 25) {
            result = "Your BMI: " + BMI + " (Normal)";

        } else if (BMI < 30) {
            result = "Your BMI: " + BMI + " (Overweight)";
        } else {
            result = "Your BMI: " + BMI + " (Obese)";
        }

        return result;

    }

}

