package com.example.merchantportal.merchant;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {
    private final MerchantService service;
    public MerchantController(MerchantService service) { this.service = service; }

    @GetMapping public List<Merchant> list() { return service.list(); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Merchant create(@Valid @RequestBody MerchantRequest request) { return service.create(request); }
    @GetMapping("/name-available")
    public Map<String, Boolean> nameAvailable(@RequestParam String name) {
        return Map.of("available", service.nameAvailable(name));
    }
    @GetMapping("/summary") public Map<String, Object> summary() { return service.summary(); }
}
