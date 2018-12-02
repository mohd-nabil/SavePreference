package com.mjm.savepreference;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * Created by nabilulaleem.md on 15-06-2018.
 */
public class Preference {

    private static Context mContext;
    private static int mMode = -1;
    private static String mPref;

    private static SharedPreferences mSharedPreferences;

    /**
     * Returns the underlying SharedPreference instance
     *
     * @return an instance of the SharedPreference
     * @throws RuntimeException if SharedPreference instance has not been instantiated yet.
     */
    @SuppressWarnings("WeakerAccess")
    public static SharedPreferences getPreferences() {
        if (mSharedPreferences != null) {
            return mSharedPreferences;
        }
        throw new RuntimeException(
                "Preference class not correctly instantiated. Please call Builder.setContext().build() in the Application class onCreate.");
    }

    private static void initialize(){
        mSharedPreferences = mContext.getSharedPreferences(mPref, mMode);
    }

    private static SharedPreferences.Editor openEditor(){
        return mSharedPreferences.edit();
    }

    private static void closeEditor(SharedPreferences.Editor editor){
        editor.apply();
        editor.commit();
    }

    /**
     * @param key
     * @param value
     */
    public static void save(String key, String value){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        editor.putString(key, value);
        closeEditor(editor);
    }

    /**
     * @param key
     * @param value
     */
    public static void save(String key, int value){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        editor.putInt(key, value);
        closeEditor(editor);
    }

    /**
     * @param key
     * @param value
     */
    public static void save(String key, float value){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        editor.putFloat(key, value);
        closeEditor(editor);
    }

    /**
     * @param key
     * @param value
     */
    public static void save(String key, long value){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        editor.putLong(key, value);
        closeEditor(editor);
    }


    /**
     * @param key
     * @param value
     */
    public static void save(String key, boolean value){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        editor.putBoolean(key, value);
        closeEditor(editor);
    }


    /**
     * @param key
     * @param value
     */
    public static void save(String key, Set<String> value){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        editor.putStringSet(key, value);
        closeEditor(editor);
    }

    /**
     * @param key
     * @param value
     */
    public static void save(String[] key, String[] value){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        for(int i=0; i<key.length; i++){
            try {
                editor.putString(key[i], value[i]);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        closeEditor(editor);
    }

    /**
     * @param key
     * @param value
     */
    public static void save(String[] key, int[] value){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        for(int i=0; i<key.length; i++){
            try {
                editor.putInt(key[i], value[i]);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        closeEditor(editor);
    }

    /**
     * @param key
     * @param value
     */
    public static void save(String[] key, float[] value){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        for(int i=0; i<key.length; i++){
            try {
                editor.putFloat(key[i], value[i]);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        closeEditor(editor);
    }

    /**
     * @param key
     * @param value
     */
    public static void save(String[] key, long[] value){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        for(int i=0; i<key.length; i++){
            try {
                editor.putLong(key[i], value[i]);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        closeEditor(editor);
    }


    /**
     * @param key
     * @param value
     */
    public static void save(String[] key, boolean[] value){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        for(int i=0; i<key.length; i++){
            try {
                editor.putBoolean(key[i], value[i]);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        closeEditor(editor);
    }

    /**
     * @param key
     */
    public static void clear(String key){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        editor.remove(key);
        closeEditor(editor);
    }

    /**
     * @param key
     */
    public static void clear(String[] key){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        for(String mKey: key){
            editor.remove(mKey);
        }
        closeEditor(editor);
    }

    /**
     * @param key
     * @param exceptThisKey
     */
    public static void clear(String[] key, String exceptThisKey){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        for(String mKey: key){
            if(!mKey.equals(exceptThisKey)){
                editor.remove(mKey);
            }
        }
        closeEditor(editor);
    }

    /**
     * @param key
     * @param exceptThisKey
     */
    public static void clear(String[] key, String[] exceptThisKey){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        for(String mKey: key){
            for(String mExceptThisKey: exceptThisKey){
                if(!mKey.equals(mExceptThisKey)){
                    editor.remove(mKey);
                }
            }
        }
        closeEditor(editor);
    }

    /**
     * Clear all
     */
    public static void clear(){
        getPreferences();
        SharedPreferences.Editor editor = openEditor();
        editor.clear();
        closeEditor(editor);
    }

    public final static class Builder{

        public Builder setContext(Context context){
            mContext = context;
            return this;
        }

        public Builder setMode(int mode){
            mMode = mode;
            return this;
        }

        public Builder setPrefName(String pref){
            mPref = pref;
            return this;
        }

        public Builder build(){
            if(mContext == null){
                throw new Error("Context not set, please set context before building the Prefs instance.");
            }

            if(mMode == -1){
                mMode = ContextWrapper.MODE_PRIVATE;
            }

            Preference.initialize();
            return this;
        }
    }
}
