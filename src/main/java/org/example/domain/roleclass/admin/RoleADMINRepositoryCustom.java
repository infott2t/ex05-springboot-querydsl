package org.example.domain.roleclass.admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleADMINRepositoryCustom {

    Page<RoleADMINApiDto> searchAllV2(RoleADMINSearchCondition condition, Pageable pageable);

  List<RoleADMINApiDto> searchFindAllDesc();


}