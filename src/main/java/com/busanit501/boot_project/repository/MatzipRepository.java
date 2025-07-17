package com.busanit501.boot_project.repository;

import com.busanit501.boot_project.domain.Matzip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatzipRepository extends JpaRepository<Matzip, Long> {
    Page<Matzip> findByMainTitleContaining(String keyword, Pageable pageable);
    Page<Matzip> findByAddr1Containing(String keyword, Pageable pageable);
    Page<Matzip> findByItemcntntsContaining(String keyword, Pageable pageable);
}
