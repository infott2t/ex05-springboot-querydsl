package org.example.domain.roleclass.guest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleGUESTService {

    private final RoleGUESTRepository roleGUESTRepository;
    
    @Transactional(readOnly = true)
    public List<RoleGUESTApiDto> searchFindAllDesc() {
        return  roleGUESTRepository.searchFindAllDesc();
    }
}