package com.squad13.UPA_digital.repository;

import com.squad13.UPA_digital.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
