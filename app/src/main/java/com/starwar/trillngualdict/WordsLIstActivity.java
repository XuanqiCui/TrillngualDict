package com.starwar.trillngualdict;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;

public class WordsLIstActivity extends AppCompatActivity {

    private FloatingActionButton btn_refresh;
    private LinearLayout ll_title;
    private ListView lv_words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_words_list);

        initView();

        lv_words.setOnItemClickListener(((parent, view, position, id) -> {
            TextView tvId = view.findViewById(R.id.tv_item_context);
            String item = tvId.getText().toString();
//            Log.d("点击项", "你点击的是：" + item);
            Intent intent = new Intent(this, WordDetailActivity.class);
            intent.putExtra("englishwords", item);
            startActivity(intent);
        }));
    }

    private void initView() {
        btn_refresh = (FloatingActionButton) findViewById(R.id.btn_list_refresh);
        ll_title = (LinearLayout) findViewById(R.id.ll_title);
        lv_words = (ListView) findViewById(R.id.lv_words);

        Bmob.initialize(this,"f3656b69beef4b62f81b5a781bf731fa");
        //查询数据并放到列表上
        String bql = "select englishwords,chinesewords,japanesewords from Words";
        BmobQuery<Words> bmobQuery = new BmobQuery<>();
        bmobQuery.doSQLQuery(bql, new SQLQueryListener<Words>() {
            @Override
            public void done(BmobQueryResult<Words> bmobQueryResult, BmobException e) {
                List<Words> results = bmobQueryResult.getResults();
                if (results != null && !results.isEmpty()){
                    NowWordsAdapter adapter = new NowWordsAdapter(WordsLIstActivity.this, results);
                    lv_words.setAdapter(adapter);
                }
                else {
                    Toast.makeText(WordsLIstActivity.this, "查询失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }