package com.didocreative.dido_website.dto.casestudy;

import com.didocreative.dido_website.model.casestudy.CaseStudyImage;
import com.didocreative.dido_website.model.casestudy.CaseStudyImageSection;

import java.util.List;

public class CaseStudyImageSectionDTO {

    private CaseStudyImageSection section;

    private List<CaseStudyImage> images;

    public CaseStudyImageSection getSection() {
        return section;
    }

    public void setSection(CaseStudyImageSection section) {
        this.section = section;
    }

    public List<CaseStudyImage> getImages() {
        return images;
    }

    public void setImages(List<CaseStudyImage> images) {
        this.images = images;
    }
}
