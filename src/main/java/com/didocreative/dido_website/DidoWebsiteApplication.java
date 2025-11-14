package com.didocreative.dido_website;

import com.didocreative.dido_website.model.*;
import com.didocreative.dido_website.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DidoWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(DidoWebsiteApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadTestData(
            ProjectTypeRepository projectTypeRepo,
            PortfolioRepository portfolioRepo,
            PortfolioImageSectionRepository imageSectionRepo,
            PortfolioImageRepository imageRepo,
            PortfolioCopywritingSectionRepository copywritingSectionRepo,
            PortfolioCopywritingRepository copywritingRepo
    ) {
        return args -> {
            System.out.println("--- INJECTING TEMPLATE DATA ---");

            // 1. Get or Create Project Types (The Safe Way)
            // This logic says: "Find BRANDING. If it doesn't exist, create it, save it, and RETURN it."

            ProjectType branding = projectTypeRepo.findByKey("BRANDING").stream().findFirst().orElseGet(() -> {
                ProjectType t = new ProjectType();
                t.setKey("BRANDING");
                t.setValue("Branding");
                t.setDescription("Identity and Logos");
                return projectTypeRepo.save(t);
            });

            ProjectType design = projectTypeRepo.findByKey("DESIGN").stream().findFirst().orElseGet(() -> {
                ProjectType t = new ProjectType();
                t.setKey("DESIGN");
                t.setValue("Design");
                t.setDescription("Product and UI/UX");
                return projectTypeRepo.save(t);
            });

            ProjectType photography = projectTypeRepo.findByKey("PHOTO").stream().findFirst().orElseGet(() -> {
                ProjectType t = new ProjectType();
                t.setKey("PHOTO");
                t.setValue("Photography");
                t.setDescription("Commercial Photography");
                return projectTypeRepo.save(t);
            });


            // --- PROJECT 1: Interior Design Studio (Branding) ---
            if (portfolioRepo.findByTitle("Interior design studio").isEmpty()) {
                Portfolio p1 = new Portfolio();
                p1.setTitle("Interior design studio");
                p1.setProjectTypeId(branding.getProjectTypeId());
                p1.setCoverImageUrl("/img/works/1.jpg");
                portfolioRepo.save(p1);

                createOverviewSection(p1.getPortfolioId(), copywritingSectionRepo, copywritingRepo,
                        "Simplicity, elegance, innovation!",
                        "A home surveillance camera that pays great attention to security and user privacy.");

                createGallerySection(p1.getPortfolioId(), imageSectionRepo, imageRepo,
                        "Project Gallery",
                        List.of("/img/works/1/1.jpg", "/img/works/1/2.jpg", "/img/works/1/3.jpg"));
            }

            // --- PROJECT 2: Home Security Camera (Design) ---
            if (portfolioRepo.findByTitle("Home Security Camera").isEmpty()) {
                Portfolio p2 = new Portfolio();
                p2.setTitle("Home Security Camera");
                p2.setProjectTypeId(design.getProjectTypeId());
                p2.setCoverImageUrl("/img/works/2.jpg");
                portfolioRepo.save(p2);
            }

            // --- PROJECT 3: Kemia Honest Skincare (Design) ---
            if (portfolioRepo.findByTitle("Kemia Honest Skincare").isEmpty()) {
                Portfolio p3 = new Portfolio();
                p3.setTitle("Kemia Honest Skincare");
                p3.setProjectTypeId(design.getProjectTypeId());
                p3.setCoverImageUrl("/img/works/3.jpg");
                portfolioRepo.save(p3);
            }

            // --- PROJECT 4: Cascade of Lava (Photography) ---
            if (portfolioRepo.findByTitle("Cascade of Lava").isEmpty()) {
                Portfolio p4 = new Portfolio();
                p4.setTitle("Cascade of Lava");
                p4.setProjectTypeId(photography.getProjectTypeId());
                p4.setCoverImageUrl("/img/works/4.jpg");
                portfolioRepo.save(p4);
            }

            // --- PROJECT 5: Air Pro by Molekule (Design) ---
            if (portfolioRepo.findByTitle("Air Pro by Molekule").isEmpty()) {
                Portfolio p5 = new Portfolio();
                p5.setTitle("Air Pro by Molekule");
                p5.setProjectTypeId(design.getProjectTypeId());
                p5.setCoverImageUrl("/img/works/5.jpg");
                portfolioRepo.save(p5);
            }

            // --- PROJECT 6: Tony's Chocolonely (Design) ---
            if (portfolioRepo.findByTitle("Tony's Chocolonely").isEmpty()) {
                Portfolio p6 = new Portfolio();
                p6.setTitle("Tony's Chocolonely");
                p6.setProjectTypeId(design.getProjectTypeId());
                p6.setCoverImageUrl("/img/works/6.jpg");
                portfolioRepo.save(p6);
            }

            System.out.println("--- DATA INJECTION COMPLETE ---");
        };
    }

    // --- Helper Methods (Paste these inside the class, below the loadTestData method) ---

    private void createOverviewSection(Long portfolioId, PortfolioCopywritingSectionRepository secRepo, PortfolioCopywritingRepository textRepo, String title, String text) {
        // 1. Create the Section
        PortfolioCopywritingSection sec = new PortfolioCopywritingSection();
        sec.setPortfolioId(portfolioId);
        sec.setKey("OVERVIEW");
        sec.setValue(title);
        sec.setDescription(text);
        secRepo.save(sec);

        // 2. Create the Text Entry inside it
        PortfolioCopywriting p = new PortfolioCopywriting();
        p.setPortfolioCopywritingSectionId(sec.getPortfolioCopywritingSectionId());
        p.setCopytext(text);
        textRepo.save(p);
    }

    private void createGallerySection(Long portfolioId, PortfolioImageSectionRepository secRepo, PortfolioImageRepository imgRepo, String title, List<String> urls) {
        // 1. Create the Section
        PortfolioImageSection sec = new PortfolioImageSection();
        sec.setPortfolioId(portfolioId);
        sec.setKey("GALLERY");
        sec.setValue(title);
        sec.setDescription("Gallery images");
        secRepo.save(sec);

        // 2. Loop through URLs and create Images
        for (String url : urls) {
            PortfolioImage img = new PortfolioImage();
            img.setPortfolioImageSectionId(sec.getPortfolioImageSectionId());
            img.setImageUrl(url);
            imgRepo.save(img);
        }
    }



}