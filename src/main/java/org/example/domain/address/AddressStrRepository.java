package org.example.domain.address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressStrRepository extends JpaRepository<AddressStr, Long>,
        QuerydslPredicateExecutor<AddressStr>, AddressStrRepositoryCustom {


}