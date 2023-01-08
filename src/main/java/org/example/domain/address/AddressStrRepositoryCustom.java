package org.example.domain.address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressStrRepositoryCustom {

    Page<AddressStrApiDto> searchAllV2(AddressStrSearchCondition condition, Pageable pageable);

  List<AddressStrApiDto> searchFindAllDesc();


}