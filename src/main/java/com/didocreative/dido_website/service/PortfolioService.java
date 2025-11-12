package com.didocreative.dido_website.service;

import com.didocreative.dido_website.dto.PortfolioDetailDTO;
import com.didocreative.dido_website.model.Portfolio;
import com.didocreative.dido_website.model.PortfolioCopywritingSection;
import com.didocreative.dido_website.model.PortfolioImageSection;
import com.didocreative.dido_website.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        if (portfolio == null){
            return null;
        }

        List<PortfolioImageSection> imageSections = imageSectionRepository.findByPortfolioId(portfolioId);
        List<PortfolioCopywritingSection> copywritingSections = copywritingSectionRepository.findByPortfolioId(portfolioId);

        PortfolioDetailDTO dto = new PortfolioDetailDTO();

        dto.setPortfolio(portfolio);
        dto.setImageSections(imageSections);
        dto.setCopywritingSections(copywritingSections);

        return dto;
    }



}
