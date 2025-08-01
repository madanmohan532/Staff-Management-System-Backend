package training.iqgateway.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import training.iqgateway.admin.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Admin getAdminById(String id) {
		// Logic to fetch admin by ID
		return adminRepository.findById(id).orElse(null);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public Admin findByEmail(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("contactDetails.email").is(email));
		return mongoTemplate.findOne(query, Admin.class);
	}

	@Override
	public Admin updateAdminById(String adminId, String nurseId) {
		// TODO Auto-generated method stub
		
	
		
		Admin admin = findByEmail(adminId);
		
		List<String> approvedRegistrationIds = admin.getApprovedRegistrationIds();
		
		approvedRegistrationIds.add(nurseId);
		
		admin.setApprovedRegistrationIds(approvedRegistrationIds);
		
		adminRepository.save(admin);
		
		
		
		return admin;
	}

	// Additional methods can be implemented here as needed

}