package com.starwar.trillngualdict;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WordDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_word_detail);

        initView();
    }

    private void initView() {
        TextView tv_en_word = (TextView) findViewById(R.id.tv_en_word);
        Intent intent = getIntent();
        String englishwords = intent.getStringExtra("englishwords");
        tv_en_word.setText(englishwords);

    }


}