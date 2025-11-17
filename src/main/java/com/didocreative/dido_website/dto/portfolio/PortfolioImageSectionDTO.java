package com.didocreative.dido_website.dto.portfolio;

import com.didocreative.dido_website.model.portfolio.PortfolioImage;
import com.didocreative.dido_website.model.portfolio.PortfolioImageSection;

import java.util.List;

public class PortfolioImageSectionDTO {

    private PortfolioImageSection section;

    private List<PortfolioImage> images;

    public PortfolioImageSection getSection() {
        return section;
    }

    public void setSection(PortfolioImageSection section) {
        this.section = section;
    }

    public List<PortfolioImage> getImages() {
        return images;
    }

    public void setImages(List<PortfolioImage> images) {
        this.images = images;
    }
}
