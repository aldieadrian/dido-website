package com.didocreative.dido_website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    // Note: NO @Autowired Services anymore!

    @GetMapping("/")
    public String getHomePage() { return "index"; }

    @GetMapping("/about")
    public String getAboutPage() { return "about"; }

    @GetMapping("/services")
    public String getServicesPage() { return "services"; }

    @GetMapping("/contact")
    public String getContactPage() { return "contact"; }

    // --- PORTFOLIO ROUTES (Now just returning templates) ---

    @GetMapping("/portfolio")
    public String getPortfolioPage() {
        // No fetching data here! The HTML will do it via JS.
        return "portfolio";
    }

    @GetMapping("/portfolio/{id}")
    public String getPortfolioDetailPage(@PathVariable Long id) {
        // We just return the template. The template's JS will grab the ID from the URL.
        return "portfolio-detail";
    }
}