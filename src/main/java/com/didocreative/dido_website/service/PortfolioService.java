package com.didocreative.dido_website.service;

import com.didocreative.dido_website.dto.portfolio.PortfolioCopywritingSectionDTO;
import com.didocreative.dido_website.dto.portfolio.PortfolioDetailDTO;
import com.didocreative.dido_website.dto.portfolio.PortfolioImageSectionDTO;
import com.didocreative.dido_website.model.portfolio.*;
import com.didocreative.dido_website.repository.portfolio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//    @Service: This is the most important annotation.
//    It tells Spring "This is a service bean. Create an object
//    of this class and keep it in memory so others can @Autowire it."
@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private PortfolioImageSectionRepository imageSectionRepository;

    @Autowired
    private PortfolioImageRepository imageRepository;

    @Autowired
    private PortfolioCopywritingSectionRepository copywritingSectionRepository;

    @Autowired
    private PortfolioCopywritingRepository copywritingRepository;

    public List<Portfolio> getAllPortfolios(){
        return portfolioRepository.findAll();
    }

    public PortfolioDetailDTO getPortfolioDetail(Long portfolioId){
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElse(null);

        if (portfolio == null) {
            return null;
        }

        PortfolioDetailDTO detailDTO = new PortfolioDetailDTO();
        detailDTO.setPortfolio(portfolio);

        List<PortfolioImageSection> rawImgSections = imageSectionRepository.findByPortfolioId(portfolioId);
        List<PortfolioImageSectionDTO> imgSectionDTOs = new ArrayList<>();

        for (PortfolioImageSection section : rawImgSections) {
            List<PortfolioImage> images = imageRepository.findByPortfolioImageSectionId(
                section.getPortfolioImageSectionId());

            PortfolioImageSectionDTO sectionDTO = new PortfolioImageSectionDTO();
            sectionDTO.setSection(section);
            sectionDTO.setImages(images);

            imgSectionDTOs.add(sectionDTO);
        }

        detailDTO.setImageSections(imgSectionDTOs);

        List<PortfolioCopywritingSection> rawTextSections = copywritingSectionRepository.findByPortfolioId(portfolioId);
        List<PortfolioCopywritingSectionDTO> textSectionDTOs = new ArrayList<>();

        for (PortfolioCopywritingSection section : rawTextSections) {
            List<PortfolioCopywriting> texts = copywritingRepository.findByPortfolioCopywritingSectionId(
                section.getPortfolioCopywritingSectionId());

            PortfolioCopywritingSectionDTO sectionDTO = new PortfolioCopywritingSectionDTO();
            sectionDTO.setSection(section);
            sectionDTO.setCopywritingList(texts);

            textSectionDTOs.add(sectionDTO);
        }

        detailDTO.setCopywritingSections(textSectionDTOs);

        return detailDTO;

    }



}
