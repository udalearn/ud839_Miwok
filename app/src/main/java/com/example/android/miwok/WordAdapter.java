package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorBgResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorBgResourceId){
        super(context, 0, words);
        mColorBgResourceId = colorBgResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Miwok word from the current Word object and
        // set this text on the Miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the Default word from the current Word object and
        // set this text on the Default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image_word_icon);
        if(currentWord.hasImage() == true){
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentWord.getImageResourceId());

            //Make sure image is visible
            iconView.setVisibility(View.VISIBLE);

        } else {
            //Take away image
            iconView.setVisibility(View.GONE);
        }

        // Set the background color for the text views
        LinearLayout textContainer = (LinearLayout) listItemView.findViewById(R.id.text_container);
        int colorBg = ContextCompat.getColor(getContext(), mColorBgResourceId);
        textContainer.setBackgroundColor(colorBg);

        // Return the whole list item layout (containing 2 TextViews and 1 Image View)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
