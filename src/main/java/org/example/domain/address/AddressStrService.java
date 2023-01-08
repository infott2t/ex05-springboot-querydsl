package org.example.domain.address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressStrService {

    private final AddressStrRepository addressStrRepository;
    
    @Transactional(readOnly = true)
    public List<AddressStrApiDto> searchFindAllDesc() {
        return  addressStrRepository.searchFindAllDesc();
    }

    @Transactional
    public void save(AddressStr addressStr0) {
        addressStrRepository.save(addressStr0);
    }
}