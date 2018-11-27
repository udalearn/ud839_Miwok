package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation) {

        /** Defalut translation of the word */
        mDefaultTranslation = defaultTranslation;

        /** Miwok translation of he word */
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId) {

        /** Defalut translation of the word */
        mDefaultTranslation = defaultTranslation;

        /** Miwok translation of he word */
        mMiwokTranslation = miwokTranslation;

        /** Image Resource ID for the word */
        mImageResourceId = imageResourceId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Checks whether the object has an associated image
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
