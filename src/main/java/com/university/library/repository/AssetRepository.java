package com.university.library.repository;

import com.university.library.model.assets.Asset;
import com.university.library.model.assets.digital.NewsLetter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class AssetRepository {

    private static final AtomicInteger assetIdGenerator = new AtomicInteger(0);

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

    public static void setInstance(AssetRepository mockInstance) {
        instance = mockInstance;
    }


    private boolean exists(String assetId) {
        return assets.containsKey(assetId);
    }

    private boolean contains(Asset asset){
        List<Asset> allassets = getAllAssets();
        for (Asset a : allassets){
            if(a.equals(asset)){
                return true;
            }
        }
        return false;
    }


    public boolean addAsset(Asset asset) {
        String newAssetId = String.valueOf(assetIdGenerator.getAndIncrement());
        if (exists(newAssetId) || contains(asset) ) {
            return false;
        } else {
            asset.setAssetId(newAssetId);
            assets.put(asset.getAssetId(), asset);
            return true;
        }
    }


    public Asset getAsset(String assetId) {
        return assets.get(assetId);
    }

    public List<Asset> getAllAssets() {
        return assets.values().stream().toList();
    }

    public NewsLetter getNewsLetterByAssetId(String assetId) {
        Asset asset = assets.get(assetId);
        if (asset instanceof NewsLetter) {
            return (NewsLetter) asset;
        } else {
            return null;
        }
    }

    public Asset removeAsset(String assetId) {
        return assets.remove(assetId);
    }

    public void update(Asset asset) {
        assets.put(asset.getAssetId(), asset);
    }
}
