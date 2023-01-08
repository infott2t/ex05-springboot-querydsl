package org.example.domain.roleclass.company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleCOMPANYRepository extends JpaRepository<RoleCOMPANY, Long>,
        QuerydslPredicateExecutor<RoleCOMPANY>, RoleCOMPANYRepositoryCustom {


}