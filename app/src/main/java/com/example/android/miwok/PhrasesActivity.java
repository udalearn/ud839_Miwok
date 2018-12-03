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

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    // Handles audio focus for sound files
    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mOnCompleteListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Pause playback immediately
                        mMediaPlayer.pause();
                        // Use seekTo to start audio file at beginning if focus is regained.
                        mMediaPlayer.seekTo(0);
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus.  Stop and release media player
                        // through our releaseMediaPlayer function.
                        releaseMediaPlayer();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // We have gained focus.  Start the media player.
                        mMediaPlayer.start();
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);


        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        /*        // Create a list of words
        ArrayList<String> words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");*/

        WordAdapter itemsAdapter =
                new WordAdapter(this, words, R.color.category_phrases);

/*        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        ArrayAdapter<Word> itemsAdapter =
                new ArrayAdapter<Word>(this, R.layout.list_item, words);*/

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = (ListView) findViewById(R.id.list_all);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

        //Creating a click listener on the items in the listview so we can play associated mp3 files
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Display toast message to check setup is correct; Remove when unnecessary
                    //Toast.makeText(NumbersActivity.this, "List item clicked.", Toast.LENGTH_SHORT).show();

                    //words.get(position) will return the Element at the defined position, in this case the Word object
                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.get(position).getAudioResourceId());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mOnCompleteListener);
                }
            }
        });

        /*        //Create an array list of words for the Numbers activity
        ArrayList<String> wordNumbers = new ArrayList<String>();
        wordNumbers.add("one");
        wordNumbers.add("two");
        wordNumbers.add("three");
        wordNumbers.add("four");
        wordNumbers.add("five");
        wordNumbers.add("six");
        wordNumbers.add("seven");
        wordNumbers.add("eight");
        wordNumbers.add("nine");
        wordNumbers.add("ten");

        //Find the root view of the whole layout
        LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);

        int i = 0;
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
        }

        //LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);
        //TextView wordView = new TextView(this);
        //wordView.setText(wordNumbers.get(0));
        //rootView.addView(wordView);*/
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped (no longer being used by user, we should release the
        // media player resource.
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Abandon audio focus when playback completes.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
