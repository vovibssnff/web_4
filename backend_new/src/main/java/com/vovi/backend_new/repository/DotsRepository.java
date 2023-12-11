package com.vovi.backend_new.repository;

import com.vovi.backend_new.entity.DotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DotsRepository extends JpaRepository<DotEntity, Long> {
}
