package com.didocreative.dido_website;

// Import your new Service and DTO
import com.didocreative.dido_website.dto.PortfolioDetailDTO;
import com.didocreative.dido_website.model.Portfolio;
import com.didocreative.dido_website.service.PortfolioService;

// Import Spring libraries
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // For handling {id}
import java.util.List;

@Controller
public class WebController {

    // --- 1. "INJECT" YOUR NEW SERVICE ---
    // It's clean. The controller only talks to the service,
    // not all the different repositories.
    @Autowired
    private PortfolioService portfolioService;

    // --- 2. YOUR STATIC PAGES ---

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }

    @GetMapping("/services")
    public String getServicesPage() {
        return "services"; // This already exists and is correct!
    }

    @GetMapping("/service")
    public String getServiceDetailPage() {
        // This just shows the static service detail page for now
        // Later, we can make this dynamic like /service/{id}
        return "service";
    }

    @GetMapping("/cases")
    public String getCasesPage() {
        // We'll make this dynamic in Phase 2, for now it's static
        return "cases";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "contact";
    }

    // --- 3. YOUR PORTFOLIO "LIST" PAGE ---
    // This is now powered by the service.

    @GetMapping("/portfolio")
    public String getPortfolioPage(Model model) {

        // 1. Fetch all portfolios from the *service*
        List<Portfolio> portfolioList = portfolioService.getAllPortfolios();

        // 2. Add the list to the model for the HTML
        model.addAttribute("portfolios", portfolioList);

        // 3. Send to portfolio.html
        return "portfolio";
    }

    // --- 4. YOUR NEW "PORTFOLIO DETAIL" PAGE ---
    // This handles dynamic URLs like /portfolio/1, /portfolio/2, etc.

    @GetMapping("/portfolio/{id}")
    public String getPortfolioDetailPage(@PathVariable Long id, Model model) {

        // 1. Call our service to get the complete "data package" (the DTO)
        PortfolioDetailDTO dto = portfolioService.getPortfolioDetail(id);

        // 2. Check if the DTO is null (meaning the portfolio ID wasn't found)
        if (dto == null) {
            // If not found, just send the user back to the main portfolio list
            return "redirect:/portfolio";
        }

        // 3. If we *did* find it, add the DTO to the model
        //    Our HTML will be able to access this object
        model.addAttribute("portfolioDetail", dto);

        // 4. Send the user to our new "portfolio-detail.html" page
        return "portfolio-detail";
    }
}