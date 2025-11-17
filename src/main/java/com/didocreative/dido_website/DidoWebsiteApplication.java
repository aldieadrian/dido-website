package com.didocreative.dido_website;

// --- 1. ADD NEW IMPORTS (for CaseStudy models/repos) ---
import com.didocreative.dido_website.model.*;
import com.didocreative.dido_website.model.casestudy.*;
import com.didocreative.dido_website.model.portfolio.*;
import com.didocreative.dido_website.repository.*;
// --- END NEW IMPORTS ---

import com.didocreative.dido_website.repository.casestudy.*;
import com.didocreative.dido_website.repository.portfolio.*;
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

    // --- 2. UPDATE THE METHOD SIGNATURE ---
    // We've added all the CaseStudy repositories
    @Bean
    public CommandLineRunner loadTestData(
            ProjectTypeRepository projectTypeRepo,
            PortfolioRepository portfolioRepo,
            PortfolioImageSectionRepository imageSectionRepo,
            PortfolioImageRepository imageRepo,
            PortfolioCopywritingSectionRepository copywritingSectionRepo,
            PortfolioCopywritingRepository copywritingRepo,
            // --- NEW REPOSITORIES INJECTED ---
            CaseStudyRepository caseStudyRepo,
            CaseStudyImageSectionRepository caseImageSectionRepo,
            CaseStudyImageRepository caseImageRepo,
            CaseStudyCopywritingSectionRepository caseCopywritingSectionRepo,
            CaseStudyCopywritingRepository caseCopywritingRepo
    ) {
        return args -> {
            System.out.println("--- INJECTING TEMPLATE DATA ---");

            // 1. Get or Create Project Types
            ProjectType branding = projectTypeRepo.findByKey("BRANDING").stream().findFirst().orElseGet(() -> {
                ProjectType t = new ProjectType();
                t.setKey("BRANDING"); t.setValue("Branding"); t.setDescription("Identity and Logos");
                return projectTypeRepo.save(t);
            });
            ProjectType design = projectTypeRepo.findByKey("DESIGN").stream().findFirst().orElseGet(() -> {
                ProjectType t = new ProjectType();
                t.setKey("DESIGN"); t.setValue("Design"); t.setDescription("Product and UI/UX");
                return projectTypeRepo.save(t);
            });
            ProjectType photography = projectTypeRepo.findByKey("PHOTO").stream().findFirst().orElseGet(() -> {
                ProjectType t = new ProjectType();
                t.setKey("PHOTO"); t.setValue("Photography"); t.setDescription("Commercial Photography");
                return projectTypeRepo.save(t);
            });


            // --- 3. ALL THE PORTFOLIO DATA (Unchanged) ---
            if (portfolioRepo.findByTitle("Interior design studio").isEmpty()) {
                Portfolio p1 = new Portfolio();
                p1.setTitle("Interior design studio");
                p1.setProjectTypeId(branding.getProjectTypeId());
                p1.setCoverImageUrl("/img/works/1.jpg");
                portfolioRepo.save(p1);
                createPortfolioOverviewSection(p1.getPortfolioId(), copywritingSectionRepo, copywritingRepo, "Simplicity, elegance, innovation!", "A home surveillance camera that pays great attention to security...");
                createPortfolioGallerySection(p1.getPortfolioId(), imageSectionRepo, imageRepo, "Project Gallery", List.of("/img/works/1/1.jpg", "/img/works/1/2.jpg", "/img/works/1/3.jpg"));
            }
            if (portfolioRepo.findByTitle("Home Security Camera").isEmpty()) {
                Portfolio p2 = new Portfolio();
                p2.setTitle("Home Security Camera");
                p2.setProjectTypeId(design.getProjectTypeId());
                p2.setCoverImageUrl("/img/works/2.jpg");
                portfolioRepo.save(p2);
            }
            if (portfolioRepo.findByTitle("Kemia Honest Skincare").isEmpty()) {
                Portfolio p3 = new Portfolio();
                p3.setTitle("Kemia Honest Skincare");
                p3.setProjectTypeId(design.getProjectTypeId());
                p3.setCoverImageUrl("/img/works/3.jpg");
                portfolioRepo.save(p3);
            }
            if (portfolioRepo.findByTitle("Cascade of Lava").isEmpty()) {
                Portfolio p4 = new Portfolio();
                p4.setTitle("Cascade of Lava");
                p4.setProjectTypeId(photography.getProjectTypeId());
                p4.setCoverImageUrl("/img/works/4.jpg");
                portfolioRepo.save(p4);
            }
            if (portfolioRepo.findByTitle("Air Pro by Molekule").isEmpty()) {
                Portfolio p5 = new Portfolio();
                p5.setTitle("Air Pro by Molekule");
                p5.setProjectTypeId(design.getProjectTypeId());
                p5.setCoverImageUrl("/img/works/5.jpg");
                portfolioRepo.save(p5);
            }
            if (portfolioRepo.findByTitle("Tony's Chocolonely").isEmpty()) {
                Portfolio p6 = new Portfolio();
                p6.setTitle("Tony's Chocolonely");
                p6.setProjectTypeId(design.getProjectTypeId());
                p6.setCoverImageUrl("/img/works/6.jpg");
                portfolioRepo.save(p6);
            }


            // --- 4. NEW: INJECT CASE STUDY DATA ---
            if (caseStudyRepo.findByTitle("How to Become a Graphic Designer").isEmpty()) {
                // A. Create the parent CaseStudy
                CaseStudy cs1 = new CaseStudy();
                cs1.setTitle("How to Become a Graphic Designer");
                cs1.setProjectTypeId(design.getProjectTypeId()); // Link to "Design"
                cs1.setCoverImageUrl("/img/blog/1.jpg"); // From blog.html
                caseStudyRepo.save(cs1); // Save parent to get ID

                // B. Create the Overview Text
                createCaseStudyCopywritingSection(cs1.getCaseStudyId(), caseCopywritingSectionRepo, caseCopywritingRepo,
                        "Understand the Field",
                        "Start by gaining a comprehensive understanding of what graphic design entails.",
                        List.of("Are you passionate about design and interested in pursuing a career as a graphic designer? Graphic design is a dynamic field that combines creativity, technical skills, and a keen eye for aesthetics.")
                );

                // C. Create a Gallery
                createCaseStudyGallerySection(cs1.getCaseStudyId(), caseImageSectionRepo, caseImageRepo,
                        "Project Gallery",
                        "A few images from the project.",
                        List.of("/img/blog/4.jpg", "/img/blog/7.jpg") // From publication.html
                );
            }

            System.out.println("--- DATA INJECTION COMPLETE ---");
        };
    }


    // --- 5. HELPER METHODS FOR PORTFOLIO (Rename) ---
    private void createPortfolioOverviewSection(Long portfolioId, PortfolioCopywritingSectionRepository secRepo, PortfolioCopywritingRepository textRepo, String title, String text) {
        PortfolioCopywritingSection sec = new PortfolioCopywritingSection();
        sec.setPortfolioId(portfolioId);
        sec.setKey("OVERVIEW");
        sec.setValue(title);
        sec.setDescription(text);
        secRepo.save(sec);

        PortfolioCopywriting p = new PortfolioCopywriting();
        p.setPortfolioCopywritingSectionId(sec.getPortfolioCopywritingSectionId());
        p.setCopytext(text);
        textRepo.save(p);
    }

    private void createPortfolioGallerySection(Long portfolioId, PortfolioImageSectionRepository secRepo, PortfolioImageRepository imgRepo, String title, List<String> urls) {
        PortfolioImageSection sec = new PortfolioImageSection();
        sec.setPortfolioId(portfolioId);
        sec.setKey("GALLERY");
        sec.setValue(title);
        sec.setDescription("Gallery images");
        secRepo.save(sec);

        for (String url : urls) {
            PortfolioImage img = new PortfolioImage();
            img.setPortfolioImageSectionId(sec.getPortfolioImageSectionId());
            img.setImageUrl(url);
            imgRepo.save(img);
        }
    }

    // --- 6. NEW: HELPER METHODS FOR CASE STUDY ---
    private void createCaseStudyCopywritingSection(Long caseStudyId, CaseStudyCopywritingSectionRepository secRepo, CaseStudyCopywritingRepository textRepo, String title, String description, List<String> paragraphs) {
        CaseStudyCopywritingSection sec = new CaseStudyCopywritingSection();
        sec.setCaseStudyId(caseStudyId);
        sec.setKey("OVERVIEW");
        sec.setValue(title);
        sec.setDescription(description);
        secRepo.save(sec);

        for (String text : paragraphs) {
            CaseStudyCopywriting p = new CaseStudyCopywriting();
            p.setCaseStudyCopywritingSectionId(sec.getCaseStudyCopywritingSectionId());
            p.setCopytext(text);
            textRepo.save(p);
        }
    }

    private void createCaseStudyGallerySection(Long caseStudyId, CaseStudyImageSectionRepository secRepo, CaseStudyImageRepository imgRepo, String title, String description, List<String> urls) {
        CaseStudyImageSection sec = new CaseStudyImageSection();
        sec.setCaseStudyId(caseStudyId);
        sec.setKey("GALLERY");
        sec.setValue(title);
        sec.setDescription(description);
        secRepo.save(sec);

        for (String url : urls) {
            CaseStudyImage img = new CaseStudyImage();
            img.setCaseStudyImageSectionId(sec.getCaseStudyImageSectionId());
            img.setImageUrl(url);
            imgRepo.save(img);
        }
    }

}