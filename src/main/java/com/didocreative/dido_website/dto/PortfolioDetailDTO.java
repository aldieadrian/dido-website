package com.didocreative.dido_website.dto;

import com.didocreative.dido_website.model.Portfolio;
import com.didocreative.dido_website.model.PortfolioCopywritingSection;
import com.didocreative.dido_website.model.PortfolioImageSection;

import java.util.List;

public class PortfolioDetailDTO {

    private Portfolio portfolio;

    private List<PortfolioImageSection> imageSections;

    private List<PortfolioCopywritingSection> copywritingSections;

    // Getter Setter
    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public List<PortfolioImageSection> getImageSections() {
        return imageSections;
    }

    public void setImageSections(List<PortfolioImageSection> imageSections) {
        this.imageSections = imageSections;
    }

    public List<PortfolioCopywritingSection> getCopywritingSections() {
        return copywritingSections;
    }

    public void setCopywritingSections(List<PortfolioCopywritingSection> copywritingSections) {
        this.copywritingSections = copywritingSections;
    }
}
