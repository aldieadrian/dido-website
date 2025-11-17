package com.didocreative.dido_website.dto.portfolio;

import com.didocreative.dido_website.model.portfolio.Portfolio;

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
