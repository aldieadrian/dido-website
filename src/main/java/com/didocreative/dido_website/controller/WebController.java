package com.didocreative.dido_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

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
        return "services";
    }

    @GetMapping("/service")
    public String getServiceDetailPage() {
        return "service";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "contact";
    }

    @GetMapping("/portfolio")
    public String getPortfolioPage() {
        return "portfolio";
    }

    @GetMapping("/portfolio/{id}")
    public String getPortfolioDetailPage(@PathVariable Long id) {
        return "portfolio-detail";
    }

    @GetMapping("/cases")
    public String getCasesPage() {
        return "cases";
    }

    @GetMapping("/cases/{id}")
    public String getCaseDetailPage(@PathVariable Long id) {
        return "case-detail";
    }
}