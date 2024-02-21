package com.university.library.repository;

import com.university.library.model.assets.Asset;

import java.util.HashMap;

public class AssetRepository {

    private static AssetRepository instance;
    private HashMap<String, Asset> assets = new HashMap<>();

    private AssetRepository() {
    }

    public static synchronized AssetRepository getInstance() {
        if (instance == null) {
            instance = new AssetRepository();
        }
        return instance;
    }

    private boolean exists(String assetId) {
        return assets.containsKey(assetId);
    }

    public boolean addAsset(Asset asset) {
        if (exists(asset.getAssetId())) {
            return false;
        }
        assets.put(asset.getAssetId(), asset);
        return true;
    }

    public Asset getAsset(String assetId) {
        return assets.get(assetId);
    }

    public Asset removeAsset(String assetId) {
        return assets.remove(assetId);
    }

}