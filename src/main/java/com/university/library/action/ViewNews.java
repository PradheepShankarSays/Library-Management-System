
package com.university.library.action;

import com.university.library.model.assets.Asset;
import com.university.library.model.assets.digital.NewsLetter;
import com.university.library.repository.AssetRepository;

import java.text.SimpleDateFormat;
import java.util.List;

public class ViewNews {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM yyyy");

    public static void viewNewsletters() {
        AssetRepository assetRepository = AssetRepository.getInstance();
        List<Asset> allAssets = assetRepository.getAllAssets();

        System.out.println("Available Newsletters:");
        allAssets.stream()
                .filter(asset -> asset instanceof NewsLetter) // Filter out newsletters
                .map(asset -> (NewsLetter) asset) 
                .forEach(newsletter -> {
                    
                    String date = dateFormat.format(newsletter.getDate());
                    String title = newsletter.getTitle() == null || newsletter.getTitle().isEmpty() ? "Newsletter" : newsletter.getTitle();
                    System.out.println("Date: " + date + ", Title: " + title + ", Access Link: " + newsletter.getAccessLink());
                });

        if (allAssets.stream().noneMatch(asset -> asset instanceof NewsLetter)) {
            System.out.println("No newsletters available at the moment.");
        }
    }
}
