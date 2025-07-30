package training.iqgateway.staff.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import training.iqgateway.staff.entity.Nurse;

@Repository
public interface NurseRepository extends MongoRepository<Nurse, String>{

}
