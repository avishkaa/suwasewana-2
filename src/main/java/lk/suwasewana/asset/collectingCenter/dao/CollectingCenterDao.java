package lk.suwasewana.asset.collectingCenter.dao;
import lk.suwasewana.asset.collectingCenter.entity.CollectingCenter;
import lk.suwasewana.asset.collectingCenter.entity.Enum.CollectingCenterStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CollectingCenterDao extends JpaRepository<CollectingCenter, Integer> {

    List<CollectingCenter> findByCollectingCenterStatus(CollectingCenterStatus val);

    CollectingCenter findFirstByOrderByIdAsc();


}
