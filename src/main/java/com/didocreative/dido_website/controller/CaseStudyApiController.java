package com.didocreative.dido_website.controller;

import com.didocreative.dido_website.dto.casestudy.CaseStudyDetailDTO;
import com.didocreative.dido_website.model.casestudy.CaseStudy;
import com.didocreative.dido_website.service.CaseStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class CaseStudyApiController {

    @Autowired
    private CaseStudyService caseStudyService;

    @GetMapping("")
    public ResponseEntity<List<CaseStudy>> getAllCaseStudies() {
        return ResponseEntity.ok(caseStudyService.getAllCaseStudies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaseStudyDetailDTO> getCaseStudyDetail(@PathVariable Long id) {
        CaseStudyDetailDTO dto = caseStudyService.getCaseStudyDetail(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }
}
