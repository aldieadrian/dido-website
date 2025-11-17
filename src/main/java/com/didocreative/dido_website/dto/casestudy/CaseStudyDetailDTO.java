package com.didocreative.dido_website.dto.casestudy;

import com.didocreative.dido_website.model.casestudy.CaseStudy;

import java.util.List;

public class CaseStudyDetailDTO {

    private CaseStudy caseStudy;

    private List<CaseStudyImageSectionDTO> imageSections;

    private List<CaseStudyCopywritingSectionDTO> copywritingSections;

    public CaseStudy getCaseStudy() {
        return caseStudy;
    }

    public void setCaseStudy(CaseStudy caseStudy) {
        this.caseStudy = caseStudy;
    }

    public List<CaseStudyImageSectionDTO> getImageSections() {
        return imageSections;
    }

    public void setImageSections(List<CaseStudyImageSectionDTO> imageSections) {
        this.imageSections = imageSections;
    }

    public List<CaseStudyCopywritingSectionDTO> getCopywritingSections() {
        return copywritingSections;
    }

    public void setCopywritingSections(List<CaseStudyCopywritingSectionDTO> copywritingSections) {
        this.copywritingSections = copywritingSections;
    }
}
