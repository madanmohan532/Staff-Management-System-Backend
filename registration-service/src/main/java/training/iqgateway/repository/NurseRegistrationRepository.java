package training.iqgateway.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import training.iqgateway.entity.NurseRegistrationEntity;

@Repository
public interface NurseRegistrationRepository extends MongoRepository<NurseRegistrationEntity, String> {

}
