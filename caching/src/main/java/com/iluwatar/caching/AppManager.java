package com.iluwatar.caching;

/**
 * Created by starhq on 2017/3/21.
 */
public class AppManager {

    private static CachingPolicy cachingPolicy;

    private AppManager() {
    }

    public static void initDb(boolean useMongoDb) {
        if (useMongoDb) {
            DbManager.connect();
        } else {
            DbManager.createVirtualDb();
        }
    }


    public static void initCachingPolicy(CachingPolicy policy) {
        cachingPolicy = policy;
        if (cachingPolicy == CachingPolicy.BEHIND) {
            Runtime.getRuntime().addShutdownHook(new Thread(CacheStore::flushCache));
        }
        CacheStore.clearCache();
    }

    public static void initCacheCapacity(int capacity) {
        CacheStore.initCapacity(capacity);
    }

    public static UserAccount find(String userId) {
        switch (cachingPolicy) {
            case THROUGH:
            case AROUND:
                return CacheStore.readThrough(userId);
            case BEHIND:
                return CacheStore.readThroughWithWriteBackPolicy(userId);
            default:
                return findAside(userId);
        }
    }

    public static void save(UserAccount userAccount) {
        switch (cachingPolicy) {
            case THROUGH:
                CacheStore.writeThrough(userAccount);
                break;
            case AROUND:
                CacheStore.writeAround(userAccount);
                break;
            case BEHIND:
                CacheStore.writeBehind(userAccount);
                break;
            default:
                saveAside(userAccount);
        }
    }

    public static String printCacheContent() {
        return CacheStore.print();
    }

    private static void saveAside(UserAccount userAccount) {
        DbManager.updateDb(userAccount);
        CacheStore.invalidate(userAccount.getUserId());
    }

    private static UserAccount findAside(String userId) {
        UserAccount userAccount = CacheStore.get(userId);
        if (userAccount != null) {
            return userAccount;
        }

        userAccount = DbManager.readFromDb(userId);
        if (userAccount != null) {
            CacheStore.set(userId, userAccount);
        }

        return userAccount;
    }
}
