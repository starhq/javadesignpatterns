package com.iluwatar.caching;

/**
 * Created by starhq on 2017/3/21.
 */
public enum CachingPolicy {

    THROUGH("through"), AROUND("around"), BEHIND("behind"), ASIDE("aside");

    private String policy;

    CachingPolicy(String policy) {
        this.policy = policy;
    }

    public String getPolicy() {
        return policy;
    }
}
