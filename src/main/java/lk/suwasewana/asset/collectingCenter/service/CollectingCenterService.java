package lk.suwasewana.asset.collectingCenter.service;

import lk.suwasewana.asset.collectingCenter.dao.CollectingCenterDao;
import lk.suwasewana.asset.collectingCenter.entity.CollectingCenter;
import lk.suwasewana.asset.collectingCenter.entity.Enum.CollectingCenterStatus;
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
public class CollectingCenterService implements AbstractService<CollectingCenter, Integer> {
    private final CollectingCenterDao collectingCenterDao;

    @Autowired
    public CollectingCenterService(CollectingCenterDao collectingCenterDao) {
        this.collectingCenterDao = collectingCenterDao;
    }


    @Cacheable(value = "collectingCenter")
    public List<CollectingCenter> findAll() {
        return collectingCenterDao.findAll();
    }

    @Cacheable(value = "collectingCenter")
    public CollectingCenter findById(Integer id) {
        return collectingCenterDao.getOne(id);
    }

    @CachePut(value = "collectingCenter")
    @Transactional
    public CollectingCenter persist(CollectingCenter collectingCenter) {
        return collectingCenterDao.save(collectingCenter);
    }

    @CacheEvict(value = "collectingCenter")
    public boolean delete(Integer id) {
        collectingCenterDao.deleteById(id);
        return false;
    }

    @CachePut(value = "collectingCenter")
    public List<CollectingCenter> search(CollectingCenter collectingCenter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<CollectingCenter> collectingCenterExample = Example.of(collectingCenter, matcher);
        return collectingCenterDao.findAll(collectingCenterExample);
    }
/*    @Transactional
    public boolean isPresentCollectingCenter(CollectingCenter collectingCenter){
        return collectingCenterDao.equals(collectingCenter);
    }*/

    @Cacheable(value = "collectingCenter")
    public List<CollectingCenter> openCollectingCenter(CollectingCenterStatus val) {
        return collectingCenterDao.findByCollectingCenterStatus(val);
    }

    @Cacheable(value = "collectingCenter")
    public CollectingCenter firstCollectingCenter() {
        return collectingCenterDao.findFirstByOrderByIdAsc();
    }
}
