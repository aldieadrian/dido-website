package com.didocreative.dido_website;

// --- NEW IMPORTS ---
import com.didocreative.dido_website.model.*;
import com.didocreative.dido_website.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
// --- END NEW IMPORTS ---

@SpringBootApplication
public class DidoWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(DidoWebsiteApplication.class, args);
    }

    // --- NEW BEAN ---
    // This code will run ONCE, every time you start your app
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
            System.out.println("--- LOADING TEST DATA ---");

            // --- 1. Create a Project Type ---
            // Only add "Branding" if it doesn't exist
            if (projectTypeRepo.findByKey("BRANDING").isEmpty()) {
                ProjectType brandingType = new ProjectType();
                brandingType.setKey("BRANDING");
                brandingType.setValue("Branding");
                brandingType.setDescription("All branding projects");
                projectTypeRepo.save(brandingType);
                System.out.println("Saved ProjectType: Branding");
            }
            // Only add "Social Media Management" if it doesn't exist
            if (projectTypeRepo.findByKey("SOCIAL_MEDIA_MANAGEMENT").isEmpty()){
                ProjectType socmedType = new ProjectType();
                socmedType.setKey("SOCIAL_MEDIA_MANAGEMENT");
                socmedType.setValue("Social Media Management");
                socmedType.setDescription("Project type for Social Media Management project");
                projectTypeRepo.save(socmedType);
                System.out.println("Saved ProjectType: Social Media Management");
            }

            // Get the type we just saved (or a default if it failed)
            ProjectType branding = projectTypeRepo.findByKey("BRANDING").get(0);
            ProjectType socmed = projectTypeRepo.findByKey("SOCIAL_MEDIA_MANAGEMENT").get(0);

            // --- 2. Create some Portfolio ---
            // Only add "Brocode" if it doesn't exist
            if (portfolioRepo.findByTitle("Brocode").isEmpty()) {
                Portfolio brocode = new Portfolio();
                brocode.setTitle("Brocode");
                brocode.setProjectTypeId(socmed.getProjectTypeId()); // Link to Social Media Management
                brocode.setCoverImageUrl("/images/brocode-cover.jpg"); // Fake image path for now
                portfolioRepo.save(brocode); // Save it!
                System.out.println("Saved Portfolio: Brocode");

                // --- 3. Create a Copywriting Section for the Overview ---
                PortfolioCopywritingSection overviewSection = new PortfolioCopywritingSection();
                overviewSection.setPortfolioId(brocode.getPortfolioId()); // Link to Brocode
                overviewSection.setKey("OVERVIEW");
                overviewSection.setValue("Project Overview");
                overviewSection.setDescription("The main overview text for the Brocode project.");
                copywritingSectionRepo.save(overviewSection);

                // --- 4. Create a Copywriting Entry for that Section ---
                PortfolioCopywriting overviewText = new PortfolioCopywriting();
                overviewText.setPortfolioCopywritingSectionId(overviewSection.getPortfolioCopywritingSectionId()); // Link to section
                overviewText.setCopytext("This is the main overview for Brocode. It was a brand for barbershop...");
                copywritingRepo.save(overviewText);

                // --- 5. Create an Image Section for the Gallery ---
                PortfolioImageSection gallerySection = new PortfolioImageSection();
                gallerySection.setPortfolioId(brocode.getPortfolioId()); // Link to Brocode
                gallerySection.setKey("GALLERY_1");
                gallerySection.setValue("Haircut");
                gallerySection.setDescription("The haircut mockup carousel");
                imageSectionRepo.save(gallerySection);

                // --- 6. Create an Image for that Section ---
                PortfolioImage img1 = new PortfolioImage();
                img1.setPortfolioImageSectionId(gallerySection.getPortfolioImageSectionId()); // Link to section
                img1.setImageUrl("/images/brocode-haircut-1.jpg");
                imageRepo.save(img1);

                System.out.println("Brocode project and its sections are saved!");
            }

            // Only add "Kopi Kohi" if it doesn't exist
            if (portfolioRepo.findByTitle("Kopi Kohi").isEmpty()) {
                Portfolio kopiKohi = new Portfolio();
                kopiKohi.setTitle("Kopi Kohi");
                kopiKohi.setProjectTypeId(branding.getProjectTypeId()); // Link to Branding
                kopiKohi.setCoverImageUrl("/images/kopikohi-cover.jpg"); // Fake image path for now
                portfolioRepo.save(kopiKohi); // Save it!
                System.out.println("Saved Portfolio: Kopi Kohi");

                // --- 3. Create a Copywriting Section for the Overview ---
                PortfolioCopywritingSection overviewSection = new PortfolioCopywritingSection();
                overviewSection.setPortfolioId(kopiKohi.getPortfolioId()); // Link to Kopi Kohi
                overviewSection.setKey("OVERVIEW");
                overviewSection.setValue("Project Overview");
                overviewSection.setDescription("The main overview text for the Kopi Kohi project.");
                copywritingSectionRepo.save(overviewSection);

                // --- 4. Create a Copywriting Entry for that Section ---
                PortfolioCopywriting overviewText = new PortfolioCopywriting();
                overviewText.setPortfolioCopywritingSectionId(overviewSection.getPortfolioCopywritingSectionId()); // Link to section
                overviewText.setCopytext("This is the main overview for Kopi Kohi. It was a brand for coffee shop...");
                copywritingRepo.save(overviewText);

                // --- 5. Create an Image Section for the Gallery ---
                PortfolioImageSection gallerySection = new PortfolioImageSection();
                gallerySection.setPortfolioId(kopiKohi.getPortfolioId()); // Link to Kopi Kohi
                gallerySection.setKey("GALLERY_1");
                gallerySection.setValue("Coffee");
                gallerySection.setDescription("The coffee mockup carousel");
                imageSectionRepo.save(gallerySection);

                // --- 6. Create an Image for that Section ---
                PortfolioImage img1 = new PortfolioImage();
                img1.setPortfolioImageSectionId(gallerySection.getPortfolioImageSectionId()); // Link to section
                img1.setImageUrl("/images/kopikohi-coffee-1.jpg");
                imageRepo.save(img1);

                System.out.println("Kopi Kohi project and its sections are saved!");
            }

            System.out.println("--- TEST DATA LOADING COMPLETE ---");
        };
    }
    // --- END NEW BEAN ---

}