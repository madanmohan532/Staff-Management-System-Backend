package training.iqgateway.admin.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import training.iqgateway.admin.entity.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {

}
