package com.didocreative.dido_website.controller;

import com.didocreative.dido_website.dto.portfolio.PortfolioDetailDTO;
import com.didocreative.dido_website.model.portfolio.Portfolio;
import com.didocreative.dido_website.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioApiController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("")
    public ResponseEntity<List<Portfolio>> getAllPortfolios() {
        return ResponseEntity.ok(portfolioService.getAllPortfolios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioDetailDTO> getPortfolioDetail(@PathVariable Long id) {
        PortfolioDetailDTO dto = portfolioService.getPortfolioDetail(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }
}