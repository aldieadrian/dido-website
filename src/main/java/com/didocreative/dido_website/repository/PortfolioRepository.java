package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    // JpaRepository<Portfolio, Long> gives us:
    // - save(Portfolio entity)
    // - findById(Long portfolioId)
    // - findAll()
    // - deleteById(Long portfolioId)
    // - ...and many more, all for free!

    // Get Portfolios by projectTypeId
    List<Portfolio> findByProjectId(Long projectTypeId);

}
