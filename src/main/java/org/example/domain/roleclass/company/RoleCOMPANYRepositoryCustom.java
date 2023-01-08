package org.example.domain.roleclass.company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleCOMPANYRepositoryCustom {

    Page<RoleCOMPANYApiDto> searchAllV2(RoleCOMPANYSearchCondition condition, Pageable pageable);

  List<RoleCOMPANYApiDto> searchFindAllDesc();


}