package com.alpha.hospital.service;

import com.alpha.hospital.model.dto.HospitalData;
import com.alpha.hospital.model.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;


@Service
public class HospitalService {


    HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public Mono<Integer> getTotalBedsNumber() {
        return hospitalRepository.find("hospitalData").map(HospitalData::getTotalBedsNumber);
    }

    public Mono setHospitalData(HospitalData hospitalData) {
        System.out.println("saving : "+hospitalData.getOccupiedBedsNumber());
        return hospitalRepository.save("hospitalData",hospitalData);
    }


    public Mono<Integer> getOccupiedBedsNumber() {
        return hospitalRepository.find("hospitalData").map(HospitalData::getOccupiedBedsNumber);
    }

    public Mono<HospitalData> getHospitalData() {
        return hospitalRepository.find("hospitalData");
    }

    public void handlePatient() {
        System.out.println("handlPatient5");
        hospitalRepository.find("hospitalData")
                .map(d ->  {
                    HospitalData dd = new HospitalData(d.getTotalBedsNumber(), d.getOccupiedBedsNumber()+1, 5);
                            System.out.println("handlPatient5 "+ dd.getOccupiedBedsNumber());
                            return dd;
                }
                )
                .map(this::setHospitalData);

    }
}
