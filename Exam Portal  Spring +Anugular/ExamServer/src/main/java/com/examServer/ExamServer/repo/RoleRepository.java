package com.examServer.ExamServer.repo;

import com.examServer.ExamServer.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
