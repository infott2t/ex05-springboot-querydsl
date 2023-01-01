package org.example.domain.serv.workplan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkPlanService {

    private final WorkPlanRepository workPlanRepository;
    
    @Transactional(readOnly = true)
    public List<WorkPlanApiDto> searchFindAllDesc() {
        return  workPlanRepository.searchFindAllDesc();
    }

    @Transactional
    public void save(WorkPlan workPlan) {
        workPlanRepository.save(workPlan);
    }
}