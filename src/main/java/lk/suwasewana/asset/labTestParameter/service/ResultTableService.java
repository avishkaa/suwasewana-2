package lk.suwasewana.asset.labTestParameter.service;


import lk.suwasewana.asset.invoice.entity.InvoiceHasLabTest;
import lk.suwasewana.asset.labTestParameter.dao.ResultTableDao;
import lk.suwasewana.asset.labTestParameter.entity.ResultTable;
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
public class ResultTableService implements AbstractService<ResultTable, Integer> {

    private final ResultTableDao resultTableDao;

    @Autowired
    public ResultTableService(ResultTableDao resultTableDao) {
        this.resultTableDao = resultTableDao;
    }

    @Cacheable(value = "resultTable")
    public List<ResultTable> findAll() {
        return resultTableDao.findAll();
    }

    @CachePut(value = "resultTable")
    public ResultTable findById(Integer id) {
        return resultTableDao.getOne(id);
    }

    @CachePut(value = "resultTable")
    public ResultTable persist(ResultTable resultTable) {
        return resultTableDao.save(resultTable);
    }

    @CacheEvict(value = "resultTable")
    public boolean delete(Integer id) {
        resultTableDao.deleteById(id);
        return false;
    }


    @CacheEvict(value = "resultTable")
    public void deleteAll(List<ResultTable> resultTables){
        resultTableDao.deleteAll(resultTables);
    }

    @CachePut(value = "resultTable")
    public List<ResultTable> search(ResultTable resultTable) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<ResultTable> resultTableExample = Example.of(resultTable, matcher);
        return resultTableDao.findAll(resultTableExample);
    }

    @Transactional
    public ResultTable findLastResult(){
        return resultTableDao.findFirstByOrderByIdDesc();
    }

    public List<ResultTable> findByInvoiceHasLabTest(InvoiceHasLabTest invoiceHasLabTest) {
        return resultTableDao.findByInvoiceHasLabTest(invoiceHasLabTest);
    }
}
