package com.example.lrcjaeger;

import java.io.File;

public class SongItem {
    private String mTitle;
    private String mArtist;
    private String mPath;
    private String mLrcPath;
    private boolean mHasLrc;
    
    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }
    
    public String getPath() {
        return mPath;
    }
    
    public String getLrcPath() {
        return mLrcPath;
    }

    public boolean isHasLrc() {
        return mHasLrc;
    }

    public SongItem(String title, String artist, String path) {
        mTitle = title;
        mArtist = artist;
        mPath = path;
        
        mLrcPath = getLrcPath(path);
        mHasLrc = mLrcPath == null ? false : (new File(mLrcPath)).exists();
    }

    /** 
     * Get file extension name, with leading dot
     */
    private static String getLrcPath(String file) {
        int index = file.lastIndexOf(".");
        if (index != -1 && file.length() > index + 1) {
            return file.substring(0, index) + ".lrc";
        }
        return null;
    }
}
