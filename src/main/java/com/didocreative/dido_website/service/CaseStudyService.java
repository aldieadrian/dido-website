package com.didocreative.dido_website.service;

import com.didocreative.dido_website.dto.casestudy.CaseStudyCopywritingSectionDTO;
import com.didocreative.dido_website.dto.casestudy.CaseStudyDetailDTO;
import com.didocreative.dido_website.dto.casestudy.CaseStudyImageSectionDTO;
import com.didocreative.dido_website.model.casestudy.*;
import com.didocreative.dido_website.repository.casestudy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaseStudyService {

    @Autowired
    private CaseStudyRepository caseStudyRepository;

    @Autowired
    private CaseStudyImageSectionRepository imageSectionRepository;

    @Autowired
    private CaseStudyImageRepository imageRepository;

    @Autowired
    private CaseStudyCopywritingSectionRepository copywritingSectionRepository;

    @Autowired
    private CaseStudyCopywritingRepository copywritingRepository;

    public List<CaseStudy> getAllCaseStudies(){
        return caseStudyRepository.findAll();
    }

    public CaseStudyDetailDTO getCaseStudyDetail(Long caseStudyId){
        CaseStudy caseStudy = caseStudyRepository.findById(caseStudyId).orElse(null);

        if (caseStudy == null) {
            return null;
        }

        CaseStudyDetailDTO detailDTO = new CaseStudyDetailDTO();
        detailDTO.setCaseStudy(caseStudy);

        List<CaseStudyImageSection> rawImgSections = imageSectionRepository.findByCaseStudyId(caseStudyId);
        List<CaseStudyImageSectionDTO> imgSectionsDTOs = new ArrayList<>();

        for (CaseStudyImageSection section : rawImgSections) {
            List<CaseStudyImage> images = imageRepository.findByCaseStudyImageSectionId(
                section.getCaseStudyImageSectionId());

            CaseStudyImageSectionDTO sectionDTO = new CaseStudyImageSectionDTO();
            sectionDTO.setSection(section);
            sectionDTO.setImages(images);

            imgSectionsDTOs.add(sectionDTO);
        }

        detailDTO.setImageSections(imgSectionsDTOs);

        List<CaseStudyCopywritingSection> rawTextSections = copywritingSectionRepository.findByCaseStudyId(caseStudyId);
        List<CaseStudyCopywritingSectionDTO> textSectionDTOs = new ArrayList<>();

        for (CaseStudyCopywritingSection section : rawTextSections) {
            List<CaseStudyCopywriting> texts = copywritingRepository.findByCaseStudyCopywritingSectionId(
                section.getCaseStudyCopywritingSectionId());

            CaseStudyCopywritingSectionDTO sectionDTO = new CaseStudyCopywritingSectionDTO();
            sectionDTO.setSection(section);
            sectionDTO.setCopywritingList(texts);

            textSectionDTOs.add(sectionDTO);
        }

        detailDTO.setCopywritingSections(textSectionDTOs);

        return detailDTO;

    }
}
