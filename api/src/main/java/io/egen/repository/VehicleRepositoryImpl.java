package io.egen.repository;

import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Joel on 6/28/17.
 */
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Vehicle findByVin(String vin) {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findByVin",Vehicle.class);
        query.setParameter("paramVin",vin);

        List<Vehicle> resultList = query.getResultList();
        if(resultList != null && resultList.size() == 1){
            return resultList.get(0);
        }else
        {
            return  null;
        }
    }
    public Vehicle create(Vehicle veh) {
        entityManager.persist(veh);
        return veh;
    }
    public Vehicle update(Vehicle veh) {
        return entityManager.merge(veh);
    }
}
