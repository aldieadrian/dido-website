package com.didocreative.dido_website.dto;

import com.didocreative.dido_website.model.PortfolioCopywriting;
import com.didocreative.dido_website.model.PortfolioCopywritingSection;

import java.util.List;

public class PortfolioCopywritingSectionDTO {

    private PortfolioCopywritingSection section;

    private List<PortfolioCopywriting> copywritingList;

    public PortfolioCopywritingSection getSection() {
        return section;
    }

    public void setSection(PortfolioCopywritingSection section) {
        this.section = section;
    }

    public List<PortfolioCopywriting> getCopywritingList() {
        return copywritingList;
    }

    public void setCopywritingList(List<PortfolioCopywriting> copywritingList) {
        this.copywritingList = copywritingList;
    }
}
