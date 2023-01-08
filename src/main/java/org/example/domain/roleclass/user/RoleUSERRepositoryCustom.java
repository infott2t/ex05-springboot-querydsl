package org.example.domain.roleclass.user;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleUSERRepositoryCustom {

    Page<RoleUSERApiDto> searchAllV2(RoleUSERSearchCondition condition, Pageable pageable);

  List<RoleUSERApiDto> searchFindAllDesc();


}