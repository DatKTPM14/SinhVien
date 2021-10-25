package com.example.service;

import com.example.VO.Khoa;
import com.example.VO.ResponseTemplateVO;
import com.example.entity.SinhVien;
import com.example.repository.SinhVienRepository;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//    @Retry(name="basic")
//    @Retry(name="exception")
    @RateLimiter(name="basic")
    public ResponseTemplateVO getUserWithKhoa(Long sinhVienId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        SinhVien sinhVien = sinhVienRepository.findById(sinhVienId).get();
        vo.setSinhVien(sinhVien);
        Khoa khoa =
                restTemplate.getForObject("http://localhost:9001/khoa/"
                                + sinhVien.getKhoaId(),
                        Khoa.class);

        vo.setKhoa(khoa);
        System.out.println(sinhVien);
        return vo;
    }
    public ResponseEntity<String> orderFallback(Exception e){
        return
                new ResponseEntity<String>("Item service is down!", HttpStatus.OK);
    }
}
