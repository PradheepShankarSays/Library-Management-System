package com.university.library.action;

import com.university.library.model.assets.digital.NewsLetter;
import com.university.library.repository.AssetRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UpdateNews {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM yyyy");
    private static final Scanner scanner = new Scanner(System.in);

    public static void updateNewsletterProcess() {
        // Step 1: List all newsletters
        ViewNews.viewNewsletters();

        // Step 2: User selects a newsletter to update by AssetID
        System.out.println("\nEnter the AssetID of the newsletter you want to update:");
        String assetId = scanner.nextLine();

        // Step 3: Ask user for new details
        System.out.println("Enter new publication date (MMM yyyy):");
        String dateString = scanner.nextLine();
        Date newDate = null;
        try {
            newDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use MMM yyyy.");
            return;
        }

        System.out.println("Enter new publication name:");
        String newPublication = scanner.nextLine();

        // New Step: Ask for the new access link
        System.out.println("Enter new access link:");
        String newAccessLink = scanner.nextLine();

        // Step 4: Update the newsletter based on AssetID, including the new access link
        updateNewsletter(assetId, newDate, newPublication, newAccessLink);
    }

    private static void updateNewsletter(String assetId, Date newDate, String newPublication, String newAccessLink) {
        AssetRepository assetRepository = AssetRepository.getInstance();
        NewsLetter newsletter = assetRepository.getNewsLetterByAssetId(assetId);

        if (newsletter != null) {
            newsletter.setDate(newDate);
            newsletter.setPublication(newPublication);
            newsletter.setAccessLink(newAccessLink);  // Assuming NewsLetter inherits setAccessLink from DigitalAsset
            assetRepository.update(newsletter); // Assuming there's an update method in AssetRepository that accepts an Asset object
            System.out.println("Newsletter updated successfully.");
        } else {
            System.out.println("Failed to update newsletter. Newsletter not found.");
        }
    }
}
