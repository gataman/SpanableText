package com.gurcanataman.spanabletext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    HtmlTextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        editText = findViewById(R.id.editText2);
        textView = findViewById(R.id.tvGelenYazi);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yaziGonder(editText.getText().toString());
            }
        });
    }

    private void yaziGonder(String gelenText) {

        gelenText = gelenText.replaceAll("\\*([a-zA-Z0-9ğüşıöçĞÜŞİÖÇ\\s]+)\\*", "<b>$1</b>");
        gelenText = gelenText.replaceAll("=([a-zA-Z0-9ğüşıöçĞÜŞİÖÇ\\s]+)=", "<i>$1</i>");
        gelenText = gelenText.replaceAll("_([a-zA-Z0-9ğüşıöçĞÜŞİÖÇ\\s]+)_", "<u>$1</u>");
        gelenText = gelenText.replaceAll("-([a-zA-Z0-9ğüşıöçĞÜŞİÖÇ\\s]+)-", "<strike>$1</strike>");

        textView.setHtml(gelenText);
    }
}
