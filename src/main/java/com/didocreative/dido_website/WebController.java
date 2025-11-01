package com.didocreative.dido_website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Tells Spring this is a web controller
public class WebController {

    @GetMapping("/") // Maps this method to the homepage ("/")
    public String getHomePage(){
        // This string "index" tells Spring to look for a file named
        // "index.html" inside the templates folder.
        return "index";
    }

    @GetMapping("/services") // Maps to the /services URL
    public String getServicePage(){
        return "services"; // Renders services.html
    }

    @GetMapping("/portfolio")
    public String getPortfolioPage(){
        return "portfolio";
    }

    @GetMapping("/cases")
    public String getCasesPage(){
        return "cases";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "about";
    }

    @GetMapping("/contact")
    public String getContactPage(){
        return "contact";
    }

}
