
package acme.features.authenticated.requests;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requests.Requests;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedRequestRepository extends AbstractRepository {

	@Query("Select a from Requests a where a.id = ?1")
	Requests findOneById(int id);

	@Query("select a from Requests a where now()<=a.deadline")
	Collection<Requests> findManyAll();
}
