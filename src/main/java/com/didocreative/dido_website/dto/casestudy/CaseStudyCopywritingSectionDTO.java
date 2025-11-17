package com.didocreative.dido_website.dto.casestudy;

import com.didocreative.dido_website.model.casestudy.CaseStudyCopywriting;
import com.didocreative.dido_website.model.casestudy.CaseStudyCopywritingSection;

import java.util.List;

public class CaseStudyCopywritingSectionDTO {

    private CaseStudyCopywritingSection section;

    private List<CaseStudyCopywriting> copywritingList;

    public CaseStudyCopywritingSection getSection() {
        return section;
    }

    public void setSection(CaseStudyCopywritingSection section) {
        this.section = section;
    }

    public List<CaseStudyCopywriting> getCopywritingList() {
        return copywritingList;
    }

    public void setCopywritingList(List<CaseStudyCopywriting> copywritingList) {
        this.copywritingList = copywritingList;
    }
}
