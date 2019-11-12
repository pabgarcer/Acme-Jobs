
package acme.features.administrator.challenges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorChallengeShowService implements AbstractShowService<Administrator, Challenge> {

	@Autowired
	AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;
		boolean res = false;
		if (request.getPrincipal().hasRole(Authenticated.class)) {
			res = true;
		}
		return res;
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "goalGOLD", "goalSILVER", "goalBRONZE", "rewardGOLD", "rewardSILVER", "rewardBRONZE");

	}

	@Override
	public Challenge findOne(final Request<Challenge> request) {
		assert request != null;

		Challenge res;
		res = this.repository.findOneById(request.getModel().getInteger("id"));
		return res;
	}

}
