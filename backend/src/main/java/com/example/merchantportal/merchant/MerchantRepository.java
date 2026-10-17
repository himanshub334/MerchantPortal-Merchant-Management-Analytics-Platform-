package com.example.merchantportal.merchant;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    boolean existsByNameIgnoreCase(String name);
    Optional<Merchant> findByNameIgnoreCase(String name);
}
