
package acme.features.provider.requests;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Requests;
import acme.entities.roles.Provider;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class ProviderRequestListService implements AbstractListService<Provider, Requests> {

	@Autowired
	ProviderRequestRepository repository;


	@Override
	public boolean authorise(final Request<Requests> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Requests> request, final Requests entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline");

	}

	@Override
	public Collection<Requests> findMany(final Request<Requests> request) {
		assert request != null;

		Collection<Requests> result;

		result = this.repository.findManyAll();

		return result;

	}
}
