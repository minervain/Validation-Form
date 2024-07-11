package com.aou.Full_stack_validation.repository;

import com.aou.Full_stack_validation.model.UserEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntities,Long> {
}
