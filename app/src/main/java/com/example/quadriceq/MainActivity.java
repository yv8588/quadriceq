package com.example.quadriceq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Double;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText etb, etc, eta;
    Double a, b, c;
    String a1, b1, c1;
    TextView x1, x2;
    int main = 1;
    Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eta = (EditText) findViewById(R.id.eta);
        etb = (EditText) findViewById(R.id.etb);
        etc = (EditText) findViewById(R.id.etc);
        x1 = (TextView) findViewById(R.id.x1);
        x2 = (TextView) findViewById(R.id.x2);

    }

    public void go(View view) {
        a = (-100) + (100 - (-100)) * rnd.nextDouble();
        b = (-100) + (100 - (-100)) * rnd.nextDouble();
        c = (-100) + (100 - (-100)) * rnd.nextDouble();
        eta.setText(a.toString());
        etb.setText(b.toString());
        etc.setText(c.toString());
    }


    public void calculate(View view) {
        a1 = eta.getText().toString();
        a = Double.parseDouble(a1);
        b1 = etb.getText().toString();
        b = Double.parseDouble(b1);
        c1 = etc.getText().toString();
        c = Double.parseDouble(c1);
        Intent gosec = new Intent(this, math.class);
        gosec.putExtra("opa", a);
        gosec.putExtra("opb", b);
        gosec.putExtra("opc", c);
        startActivityForResult(gosec, main);
    }

    protected void onActivityResult(int source,int good,Intent data_back){
        super.onActivityResult(source,good,data_back);
        if(source==main) {
            if (data_back != null) {
                x1.setText("x1"+data_back.getDoubleExtra("answer1", 0.0));
                x2.setText("x2"+data_back.getDoubleExtra("answer2", 0.0));
            }
        }
    }
}