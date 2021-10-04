package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.SinhVien;
@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long>{

}
