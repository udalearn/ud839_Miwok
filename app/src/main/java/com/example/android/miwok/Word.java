package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {

        /** Defalut translation of the word */
        mDefaultTranslation = defaultTranslation;

        /** Miwok translation of the word */
        mMiwokTranslation = miwokTranslation;

        /** Miwok word audio */
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {

        /** Defalut translation of the word */
        mDefaultTranslation = defaultTranslation;

        /** Miwok translation of he word */
        mMiwokTranslation = miwokTranslation;

        /** Image Resource ID for the word */
        mImageResourceId = imageResourceId;

        /** Miwok word audio */
        mAudioResourceId = audioResourceId;
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

    //Return the audio resource Id integer for the appropriate audio file
    public int getAudioResourceId(){return mAudioResourceId;}

    /**
     * Checks whether the object has an associated image
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
