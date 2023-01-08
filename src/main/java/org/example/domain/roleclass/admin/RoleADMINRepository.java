package org.example.domain.roleclass.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleADMINRepository extends JpaRepository<RoleADMIN, Long>,
        QuerydslPredicateExecutor<RoleADMIN>, RoleADMINRepositoryCustom {


}