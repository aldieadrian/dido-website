package com.didocreative.dido_website.repository.portfolio;

import com.didocreative.dido_website.model.portfolio.Portfolio;
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
    // - ...and many more

    // Get Portfolios by projectTypeId
    List<Portfolio> findByProjectTypeId(Long projectTypeId);

    // Get Portfolios by title
    List<Portfolio> findByTitle(String title);

}
