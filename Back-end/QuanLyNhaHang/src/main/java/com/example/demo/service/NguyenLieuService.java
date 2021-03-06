package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NguyenLieu;
 
 
@Repository
public interface NguyenLieuService extends JpaRepository<NguyenLieu, Long>{
	@Query("FROM NguyenLieu WHERE NGUYENLIEU_NAME LIKE %:keyword%")
	public List<NguyenLieu> TimNguyenLieuTheoTen(@Param("keyword") String keyword);
}
