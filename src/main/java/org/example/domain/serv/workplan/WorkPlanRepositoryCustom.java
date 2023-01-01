package org.example.domain.serv.workplan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WorkPlanRepositoryCustom {

    Page<WorkPlanApiDto> searchAllV2(WorkPlanSearchCondition condition, Pageable pageable);

    List<WorkPlanApiDto> searchFindAllDesc();


}