package lk.suwasewana.asset.doctor.service;

import lk.suwasewana.asset.doctor.dao.DoctorDao;
import lk.suwasewana.asset.doctor.entity.Doctor;
import lk.suwasewana.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorService implements AbstractService<Doctor, Integer> {

    private final DoctorDao doctorDao;

    @Autowired
    public DoctorService(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }


    @Cacheable(value = "doctor")
    public List<Doctor> findAll() {
        return doctorDao.findAll();
    }

    @CachePut(value = "doctor")
    public Doctor findById(Integer id) {
        return doctorDao.getOne(id);
    }

    @CachePut(value = "doctor")
    @Transactional
    public Doctor persist(Doctor doctor) {
        return doctorDao.save(doctor);
    }

    @CacheEvict(value = "doctor")
    public boolean delete(Integer id) {
        doctorDao.deleteById(id);
        return false;
    }

    @CachePut(value = "doctor")
    public List<Doctor> search(Doctor doctor) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Doctor> doctorExample = Example.of(doctor, matcher);
        return doctorDao.findAll(doctorExample);
    }
}
