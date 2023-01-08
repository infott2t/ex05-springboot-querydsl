package org.example.domain.roleclass.guest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleGUESTRepositoryCustom {

    Page<RoleGUESTApiDto> searchAllV2(RoleGUESTSearchCondition condition, Pageable pageable);

  List<RoleGUESTApiDto> searchFindAllDesc();


}