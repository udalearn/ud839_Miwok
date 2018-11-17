/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.android.miwok.WordAdapter;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //Create an array list of words for the Numbers activity
        //Original ArrayList
        ArrayList<Word> wordNumbers = new ArrayList<Word>();


        //Populate our ArrayList with our new object
        wordNumbers.add(new Word("one", "lutti"));
        wordNumbers.add(new Word("two", "otiko"));
        wordNumbers.add(new Word("three", "tolookosu"));
        wordNumbers.add(new Word("four", "oyyisa"));
        wordNumbers.add(new Word("five", "massoka"));
        wordNumbers.add(new Word("six", "temmokka"));
        wordNumbers.add(new Word("seven", "kenekaku"));
        wordNumbers.add(new Word("eight", "kawinta"));
        wordNumbers.add(new Word("nine", "wo'e"));
        wordNumbers.add(new Word("ten", "na'aacha"));

        //Original ArrayList Values
/*        wordNumbers.add("one");
        wordNumbers.add("two");
        wordNumbers.add("three");
        wordNumbers.add("four");
        wordNumbers.add("five");
        wordNumbers.add("six");
        wordNumbers.add("seven");
        wordNumbers.add("eight");
        wordNumbers.add("nine");
        wordNumbers.add("ten");*/

/*        //Find the root view of the whole layout
        LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);*/

//        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wordNumbers);
/*        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.list_item, wordNumbers);*/

        WordAdapter wordAdapter = new WordAdapter(this, wordNumbers);

        ListView listView = (ListView) findViewById(R.id.list);

/*
        listView.setAdapter(itemsAdapter);
*/

        listView.setAdapter(wordAdapter);

/*        int i = 0;
        while(i < wordNumbers.size()){
            TextView wordView = new TextView(this);
            wordView.setText(wordNumbers.get(i));
            rootView.addView(wordView);
            i++;
        }

        for(int j = 0; j < wordNumbers.size(); j++){
            TextView wordView = new TextView(this);
            wordView.setText(wordNumbers.get(j));
            rootView.addView(wordView);
        }*/

        //LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);
        //TextView wordView = new TextView(this);
        //wordView.setText(wordNumbers.get(0));
        //rootView.addView(wordView);
    }
}
