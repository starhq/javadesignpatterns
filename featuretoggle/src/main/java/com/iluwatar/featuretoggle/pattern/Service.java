package com.iluwatar.featuretoggle.pattern;

import com.iluwatar.featuretoggle.user.User;

/**
 * Created by starhq on 2017/3/31.
 */
public interface Service {

    String getWelcomeMessage(User user);

    boolean isEnhanced();
}
