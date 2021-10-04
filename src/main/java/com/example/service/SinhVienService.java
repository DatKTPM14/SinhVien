package com.example.service;

import com.example.VO.Khoa;
import com.example.VO.ResponseTemplateVO;
import com.example.entity.SinhVien;
import com.example.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private RestTemplate restTemplate;

    public SinhVien saveSinhVien(SinhVien sinhVien) {
        return sinhVienRepository.save(sinhVien);
    }
    public ResponseTemplateVO getUserWithKhoa(Long sinhVienId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        SinhVien sinhVien = sinhVienRepository.findById(sinhVienId).get();
        vo.setSinhVien(sinhVien);
        Khoa khoa =
                restTemplate.getForObject("http://localhost:8080/khoa/"
                                + sinhVien.getKhoaId(),
                        Khoa.class);

        vo.setKhoa(khoa);

        return vo;
    }
}
