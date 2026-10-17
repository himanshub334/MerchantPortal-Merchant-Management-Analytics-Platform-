package com.example.merchantportal.merchant;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class MerchantService {
    private final MerchantRepository repository;
    public MerchantService(MerchantRepository repository) { this.repository = repository; }

    @Transactional
    @CacheEvict(value = "merchantSummary", allEntries = true)
    public Merchant create(MerchantRequest request) {
        if (repository.existsByNameIgnoreCase(request.name().trim())) {
            throw new DuplicateMerchantException("A merchant with this name already exists");
        }
        return repository.save(new Merchant(request.name().trim(), request.email().trim(), request.category().trim()));
    }

    @Transactional(readOnly = true)
    public List<Merchant> list() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public boolean nameAvailable(String name) {
        return name != null && !name.isBlank() && !repository.existsByNameIgnoreCase(name.trim());
    }

    @Cacheable("merchantSummary")
    @Transactional(readOnly = true)
    public Map<String, Object> summary() {
        List<Merchant> merchants = repository.findAll();
        long active = merchants.stream().filter(m -> "ACTIVE".equals(m.getStatus())).count();
        long pending = merchants.stream().filter(m -> "PENDING".equals(m.getStatus())).count();
        return Map.of("totalMerchants", merchants.size(), "activeMerchants", active,
                      "pendingMerchants", pending, "transactionVolume", 125430.75,
                      "chargebackRate", 0.42, "volumeTrend", List.of(42, 48, 45, 63, 58, 72, 81),
                      "categoryBreakdown", List.of(Map.of("category", "Retail", "count", 18),
                                                   Map.of("category", "Services", "count", 12),
                                                   Map.of("category", "Digital", "count", 9)));
    }
}
