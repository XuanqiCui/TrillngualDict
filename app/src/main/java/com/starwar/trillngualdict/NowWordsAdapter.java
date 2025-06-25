package com.starwar.trillngualdict;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NowWordsAdapter extends BaseAdapter {
    private Context context;
    private List<Words> wordsList;

    public NowWordsAdapter(Context context, List<Words> wordsList) {
        this.context = context;
        this.wordsList = wordsList;
    }

    @Override
    public int getCount() {
        return wordsList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = View.inflate(context, R.layout.item_word_list, null);
            TextView tv_item_context = convertView.findViewById(R.id.tv_item_context);
            tv_item_context.setText(this.wordsList.get(position).getEnglishwords().toString());
        }
        return convertView;
    }
}
