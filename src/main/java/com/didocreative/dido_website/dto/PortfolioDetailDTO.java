package com.didocreative.dido_website.dto;

import com.didocreative.dido_website.model.Portfolio;
import com.didocreative.dido_website.model.PortfolioCopywritingSection;
import com.didocreative.dido_website.model.PortfolioImageSection;

import java.util.List;

public class PortfolioDetailDTO {

    private Portfolio portfolio;

    private List<PortfolioImageSectionDTO> imageSections;

    private List<PortfolioCopywritingSectionDTO> copywritingSections;

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public List<PortfolioImageSectionDTO> getImageSections() {
        return imageSections;
    }

    public void setImageSections(List<PortfolioImageSectionDTO> imageSections) {
        this.imageSections = imageSections;
    }

    public List<PortfolioCopywritingSectionDTO> getCopywritingSections() {
        return copywritingSections;
    }

    public void setCopywritingSections(List<PortfolioCopywritingSectionDTO> copywritingSections) {
        this.copywritingSections = copywritingSections;
    }
}
