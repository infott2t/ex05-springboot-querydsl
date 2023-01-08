package org.example.domain.phone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneStrService {

    private final PhoneStrRepository phoneStrRepository;
    
    @Transactional(readOnly = true)
    public List<PhoneStrApiDto> searchFindAllDesc() {
        return  phoneStrRepository.searchFindAllDesc();
    }

    @Transactional
    public void save(PhoneStr phoneStr0) {
        phoneStrRepository.save(phoneStr0);
    }
}