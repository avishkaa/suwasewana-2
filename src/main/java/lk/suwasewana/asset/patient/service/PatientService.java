package lk.suwasewana.asset.patient.service;

import lk.suwasewana.asset.patient.dao.PatientDao;
import lk.suwasewana.asset.patient.entity.Patient;
import lk.suwasewana.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements AbstractService<Patient, Integer> {
    private final PatientDao patientDao;

    @Autowired
    public PatientService(PatientDao patientDao) {
        this.patientDao = patientDao;
    }


    public List<Patient> findAll() {
        return patientDao.findAll();
    }


    public Patient findById(Integer id) {
        return patientDao.getOne(id);
    }


    public Patient persist(Patient patient) {
        return patientDao.save(patient);
    }

    @CacheEvict(value = "patient", allEntries = true)
    public boolean delete(Integer id) {
        patientDao.deleteById(id);
        return false;
    }


    public List<Patient> search(Patient patient) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Patient> patientExample = Example.of(patient, matcher);
        return patientDao.findAll(patientExample);
    }

    public Patient lastPatient() {
        return patientDao.findFirstByOrderByIdDesc();
    }

}
