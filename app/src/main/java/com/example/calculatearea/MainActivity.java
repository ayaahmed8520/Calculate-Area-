package com.example.calculatearea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp_shapes;
    EditText rectangleWidth, rectangleHeight, circleRadius, triangleBase, triangleHeight;
    TextView resultArea;
    Button btn_CalculateArea;
    double area;
    double rectangle_width, rectangle_height, radius, triangle_base,triangle_height ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_shapes = findViewById(R.id.spinner_shapes);
        rectangleWidth = findViewById(R.id.editText_Rectangle_Width);
        rectangleHeight = findViewById(R.id.editText_Rectangle_height);
        circleRadius = findViewById(R.id.editText_Circle_radius);
        triangleBase = findViewById(R.id.editText_Triangle_Base);
        triangleHeight = findViewById(R.id.editText_Triangle_height);
        resultArea = findViewById(R.id.textView_Result_Area);
        btn_CalculateArea = findViewById(R.id.button_calculateArea);

        sp_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext() , "selected item: "+i , Toast.LENGTH_LONG).show();
                switch (i){
                    case 0:
                        //select shape
                        rectangleWidth.setVisibility(View.GONE);
                        rectangleHeight.setVisibility(View.GONE);
                        circleRadius.setVisibility(View.GONE);
                        triangleBase.setVisibility(View.GONE);
                        triangleHeight.setVisibility(View.GONE);
                        btn_CalculateArea.setVisibility(View.GONE);
                        resultArea.setVisibility(View.GONE);
                        break;
                    case 1:
                        //rectangle
                        rectangleWidth.setVisibility(View.VISIBLE);
                        rectangleHeight.setVisibility(View.VISIBLE);
                        circleRadius.setVisibility(View.GONE);
                        triangleBase.setVisibility(View.GONE);
                        triangleHeight.setVisibility(View.GONE);
                        btn_CalculateArea.setVisibility(View.VISIBLE);
                        resultArea.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        //circle
                        rectangleWidth.setVisibility(View.GONE);
                        rectangleHeight.setVisibility(View.GONE);
                        circleRadius.setVisibility(View.VISIBLE);
                        triangleBase.setVisibility(View.GONE);
                        triangleHeight.setVisibility(View.GONE);
                        btn_CalculateArea.setVisibility(View.VISIBLE);
                        resultArea.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        //triangle
                        rectangleWidth.setVisibility(View.GONE);
                        rectangleHeight.setVisibility(View.GONE);
                        circleRadius.setVisibility(View.GONE);
                        triangleBase.setVisibility(View.VISIBLE);
                        triangleHeight.setVisibility(View.VISIBLE);
                        btn_CalculateArea.setVisibility(View.VISIBLE);
                        resultArea.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_CalculateArea.setOnClickListener(view -> {

            int position = sp_shapes.getSelectedItemPosition();

            switch (position){

                case 1:

                    if (rectangleWidth.getText().toString().isEmpty() &&
                            !rectangleHeight.getText().toString().isEmpty()) {
                        rectangle_width = 0;
                        rectangle_height = Double.parseDouble(rectangleHeight.getText().toString());
                    } else if (!rectangleWidth.getText().toString().isEmpty() &&
                            rectangleHeight.getText().toString().isEmpty()) {
                        rectangle_width = Double.parseDouble(rectangleWidth.getText().toString());
                        rectangle_height = 0;
                    } else if (rectangleWidth.getText().toString().isEmpty() &&
                            rectangleHeight.getText().toString().isEmpty()) {
                        rectangle_width = 0;
                        rectangle_height = 0;
                    }else {
                        rectangle_width = Double.parseDouble(rectangleWidth.getText().toString());
                        rectangle_height = Double.parseDouble(rectangleHeight.getText().toString());
                    }

                    area = (rectangle_width * rectangle_height);
                    rectangleWidth.getText().clear();
                    rectangleHeight.getText().clear();
                    break;

                case 2:

                    if (circleRadius.getText().toString().isEmpty()){
                        radius = 0;
                    }else {
                        radius = Double.parseDouble(circleRadius.getText().toString());
                    }

                    area = (Math.PI *radius *radius);
                    circleRadius.getText().clear();
                    break;

                case 3:

                    if (triangleBase.getText().toString().isEmpty() &&
                            !triangleHeight.getText().toString().isEmpty()) {
                        triangle_base = 0;
                        triangle_height = Double.parseDouble(triangleHeight.getText().toString());
                    } else if (!triangleBase.getText().toString().isEmpty() &&
                            triangleHeight.getText().toString().isEmpty()) {
                        triangle_base = Double.parseDouble(triangleBase.getText().toString());
                        triangle_height = 0;
                    } else if (triangleBase.getText().toString().isEmpty() &&
                            triangleHeight.getText().toString().isEmpty()) {
                        triangle_base = 0;
                        triangle_height = 0;
                    }else {
                        triangle_base = Double.parseDouble(triangleBase.getText().toString());
                        triangle_height = Double.parseDouble(triangleHeight.getText().toString());
                    }

                    area = (0.5 * triangle_base * triangle_height);
                    triangleBase.getText().clear();
                    triangleHeight.getText().clear();
                    break;
            }
            resultArea.setText(String.format("Area = %s", area));
        });
    }
}