package com.example.android.miwok;

/** Word class represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

    /**Default translation for the word */
    private String mDefaultTranslation;

    /**Miwok translation for the word */
    private String mMiwokTranslation;

    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /** Get default translation word */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**Get Miwok Translation */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
}
