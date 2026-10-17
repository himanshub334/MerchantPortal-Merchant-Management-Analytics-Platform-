package com.example.merchantportal.merchant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MerchantServiceTest {
    @Mock MerchantRepository repository;
    @InjectMocks MerchantService service;

    @Test void rejectsDuplicateMerchantName() {
        when(repository.existsByNameIgnoreCase("Acme")).thenReturn(true);
        assertThrows(DuplicateMerchantException.class,
            () -> service.create(new MerchantRequest("Acme", "ops@example.com", "Retail")));
        verify(repository, never()).save(any());
    }

    @Test void nameIsAvailableWhenNoMatchExists() {
        when(repository.existsByNameIgnoreCase("Acme")).thenReturn(false);
        assertTrue(service.nameAvailable(" Acme "));
    }
}
