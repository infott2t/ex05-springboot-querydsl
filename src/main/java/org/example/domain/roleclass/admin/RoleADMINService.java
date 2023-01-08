package org.example.domain.roleclass.admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleADMINService {

    private final RoleADMINRepository roleADMINRepository;
    
    @Transactional(readOnly = true)
    public List<RoleADMINApiDto> searchFindAllDesc() {
        return  roleADMINRepository.searchFindAllDesc();
    }

    @Transactional(readOnly = true)
    public RoleADMIN findById(Long id) {
        return roleADMINRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void save(RoleADMIN roleADMIN) {
         roleADMINRepository.save(roleADMIN);
    }
}