package com.sample.framework.config;

import com.sample.framework.exceptions.UnsupportedPlatformException;

public enum Platform {
    ANDROID,
    IOS;

    public static Platform fromString(String platform) {
        if (platform.equalsIgnoreCase(Platform.ANDROID.toString())) {
            return ANDROID;
        } else if (platform.equalsIgnoreCase(Platform.IOS.toString())) {
            return IOS;
        } else {
            throw new UnsupportedPlatformException("Unknown Platform:" + platform);
        }
    }
}
