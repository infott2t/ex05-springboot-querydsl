package org.example.domain.coperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CoperationRepositoryCustom {

    Page<CoperationApiDto> searchAllV2(CoperationSearchCondition condition, Pageable pageable);

  List<CoperationApiDto> searchFindAllDesc();


}