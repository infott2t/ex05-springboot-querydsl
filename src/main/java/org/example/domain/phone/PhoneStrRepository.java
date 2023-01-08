package org.example.domain.phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneStrRepository extends JpaRepository<PhoneStr, Long>,
        QuerydslPredicateExecutor<PhoneStr>, PhoneStrRepositoryCustom {


}