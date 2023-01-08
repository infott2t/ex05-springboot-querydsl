package org.example.domain.roleclass.user;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleUSERService {

    private final RoleUSERRepository roleUSERRepository;
    
    @Transactional(readOnly = true)
    public List<RoleUSERApiDto> searchFindAllDesc() {
        return  roleUSERRepository.searchFindAllDesc();
    }

    @Transactional(readOnly = true)
    public RoleUSER findById(Long id) {
        return roleUSERRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void save(RoleUSER roleUSER) {
        roleUSERRepository.save(roleUSER);
    }
}