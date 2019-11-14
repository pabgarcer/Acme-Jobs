
package acme.features.administrator.investorRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorRecords.InvestorRecords;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorInvestorRecordsRepository extends AbstractRepository {

	@Query("select p from InvestorRecords p where p.id = ?1")
	InvestorRecords findOneById(int id);

	@Query("select ua from InvestorRecords ua")
	Collection<InvestorRecords> findManyAll();

}
