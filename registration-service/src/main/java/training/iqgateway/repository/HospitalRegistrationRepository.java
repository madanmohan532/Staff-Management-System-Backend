package training.iqgateway.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import training.iqgateway.entity.HospitalRegistrationEntity;

@Repository
public interface HospitalRegistrationRepository extends MongoRepository<HospitalRegistrationEntity, String> {

}
