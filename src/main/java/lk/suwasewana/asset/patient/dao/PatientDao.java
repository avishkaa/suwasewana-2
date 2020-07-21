package lk.suwasewana.asset.patient.dao;

import lk.suwasewana.asset.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao extends JpaRepository<Patient, Integer> {
    Patient findFirstByOrderByIdDesc();

}
