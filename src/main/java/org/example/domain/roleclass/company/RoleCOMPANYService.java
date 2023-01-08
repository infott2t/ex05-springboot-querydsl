package org.example.domain.roleclass.company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleCOMPANYService {

    private final RoleCOMPANYRepository roleCOMPANYRepository;
    
    @Transactional(readOnly = true)
    public List<RoleCOMPANYApiDto> searchFindAllDesc() {
        return  roleCOMPANYRepository.searchFindAllDesc();
    }
    @Transactional(readOnly = true)
    public RoleCOMPANY findById(Long id) {
        return roleCOMPANYRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void save(RoleCOMPANY roleCOMPANY) {
        roleCOMPANYRepository.save(roleCOMPANY);
    }
}