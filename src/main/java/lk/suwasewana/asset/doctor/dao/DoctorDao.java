package lk.suwasewana.asset.doctor.dao;

import lk.suwasewana.asset.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository

public interface DoctorDao extends JpaRepository<Doctor, Integer> {
}
