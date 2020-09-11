package com.example.quadriceq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class math extends AppCompatActivity {
    Double a, b, c;
    Double x1, x2;
    WebView wv;
    String st1,st2,st3;
    Intent gi = getIntent();
    String start = "https://www.google.com/search?sxsrf=ALeKk03_Ue9wbkhqMT9R5heidaeZm6E0jQ%3A1587986652875&ei=3MCmXo2ANcLAgweS4Y74Bw&q=";
    String trinom = "Ax%5E2BxC";
    String end = "&gs_lcp=CgZwc3ktYWIQAzIFCAAQywEyBQgAEMsBMgUIABDLATIECAAQHjIGCAAQBRAeMgYIABAFEB4yBggAEAUQHjIGCAAQBRAeMgYIABAFEB4yBggAEAUQHjoGCAAQBxAeOgQIIxAnOgcIIxDqAhAnOgYIIxAnEBM6AggAOgUIABCDAToHCAAQChDLAVC_5ChYk6UpYLGnKWgBcAB4AIABvAGIAfsLkgEEMC4xMZgBAKABAaoBB2d3cy13aXqwAQo&sclient=psy-ab&ved=0ahUKEwiN3uiiv4jpAhVC4OAKHZKwA38Q4dUDCAw&uact=5";
    String times = "*";
    String link;
    final String Plus = "%2B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        wv = (WebView) findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new MyWebViewClinet());
        a = gi.getDoubleExtra("opa", 123123);
        b = gi.getDoubleExtra("opb", 789789);
        c = gi.getDoubleExtra("opc", 456456);
        Double determinant = b * b - 4 * a * c;
        st1=a.toString();
        st2=b.toString();
        st3=c.toString();


        if (determinant > 0) {
            x1 =
                    x2 = (-b - Math.sqrt(determinant)) / (2 * a);
        } else if (determinant == 0) {
            x1 = x2 = -b / (2 * a);
        }
        if ((a > 0)&&(a!=1))
            trinom = trinom.replace("A", st1);
        else if(a!=1){
            trinom = trinom.replace("A", st1 + times);
        }
        else{
            trinom=trinom.substring(1);
        }
        if (b > 0) {
            trinom = trinom.replace("B", Plus + st2);
        } else {
            trinom = trinom.replace("B", st2);
        }
        if (c > 0) {
            trinom = trinom.replace("C", Plus + st3);
        } else {
            trinom = trinom.replace("C", st3);
        }
        link = start + trinom + end;
        wv.loadUrl(link);
    }



    public void back(View view) {
        setResult(RESULT_OK, gi);
        gi.putExtra("firstx", x1);
        gi.putExtra("secx", x2);

        finish();
    }

    private class MyWebViewClinet extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView View, String url) {
            View.loadUrl(url);
            return true;
        }
    }
}
