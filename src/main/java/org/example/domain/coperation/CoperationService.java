package org.example.domain.coperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoperationService {

    private final CoperationRepository coperationRepository;
    
    @Transactional(readOnly = true)
    public List<CoperationApiDto> searchFindAllDesc() {
        return  coperationRepository.searchFindAllDesc();
    }
}