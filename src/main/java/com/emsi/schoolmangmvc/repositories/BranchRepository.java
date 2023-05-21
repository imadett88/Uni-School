package com.emsi.schoolmangmvc.repositories;

import com.emsi.schoolmangmvc.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch,Long> {
}
