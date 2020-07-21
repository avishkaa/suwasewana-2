package lk.suwasewana.asset.labTestParameter.dao;


import lk.suwasewana.asset.invoice.entity.InvoiceHasLabTest;
import lk.suwasewana.asset.labTestParameter.entity.ResultTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultTableDao extends JpaRepository<ResultTable, Integer> {
    ResultTable findFirstByOrderByIdDesc();

    List<ResultTable> findByInvoiceHasLabTest(InvoiceHasLabTest invoiceHasLabTest);

}
