package lk.suwasewana.asset.labTest.dao;

import lk.suwasewana.asset.labTestParameter.entity.LabTestParameter;
import lk.suwasewana.asset.labTest.entity.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface LabTestDao extends JpaRepository<LabTest, Integer> {

    LabTest findByCode(String code);


    List<LabTest> findByLabTestParameters(LabTestParameter labTestParameter);

}
