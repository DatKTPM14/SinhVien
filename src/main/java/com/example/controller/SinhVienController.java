package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VO.ResponseTemplateVO;
import com.example.entity.SinhVien;
import com.example.service.SinhVienService;

@RestController
@RequestMapping("/sinhvien")
public class SinhVienController {
	 @Autowired
	    private SinhVienService sinhVienService;
	private int i;

	    @PostMapping("/")
	    public SinhVien saveSinhVien(@RequestBody SinhVien sinhVien){

	        return sinhVienService.saveSinhVien(sinhVien);
	    }

	    @GetMapping("/{id}")
	    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id")
	                                                                Long sinhVienId){
	        return sinhVienService.getUserWithKhoa(sinhVienId);
	    }
	    @GetMapping("/rate/{id}")
		    public ResponseTemplateVO getahi(@PathVariable("id")
			        Long sinhVienId){
	    	for(i =0 ; i <10 ;i++) {
	    		System.out.println(sinhVienService.getUserWithKhoa(sinhVienId));
	    	}
			return sinhVienService.getUserWithKhoa(sinhVienId);
			}
	    @GetMapping("/")
	    public String helloWorld(){
	        return "Hello Nguyễn Thế Đạt!";
	    }

}
