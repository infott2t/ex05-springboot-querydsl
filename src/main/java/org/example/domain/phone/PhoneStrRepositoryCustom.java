package org.example.domain.phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhoneStrRepositoryCustom {

    Page<PhoneStrApiDto> searchAllV2(PhoneStrSearchCondition condition, Pageable pageable);

  List<PhoneStrApiDto> searchFindAllDesc();


}