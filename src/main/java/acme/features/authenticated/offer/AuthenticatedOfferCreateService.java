
package acme.features.authenticated.offer;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedOfferCreateService implements AbstractCreateService<Authenticated, Offer> {

	@Autowired
	AuthenticatedOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("accept", "false");

		request.unbind(entity, model, "title", "deadline", "text", "ticker", "maxMoney", "minMoney");
	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		assert request != null;

		Offer res = new Offer();

		return res;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isAccepted = request.getModel().getBoolean("accept");
		errors.state(request, isAccepted, "accept", "authenticated.offer.error.must-accept");

		if (!errors.hasErrors("deadline")) {
			Date dateNow = Date.from(Instant.now());
			boolean deadlineAfterNow = entity.getDeadline().after(dateNow);
			errors.state(request, deadlineAfterNow, "deadline", "authenticated.offer.error.deadline");
		}

		boolean isDuplicateTicker = this.repository.findTickers(entity.getTicker()) != null;
		errors.state(request, !isDuplicateTicker, "ticker", "authenticated.offer.error.duplicated");

		if (!errors.hasErrors("maxMoney") && !errors.hasErrors("minMoney")) {
			boolean correctRange = entity.getMaxMoney().getAmount() > entity.getMinMoney().getAmount();
			errors.state(request, correctRange, "maxMoney", "authenticated.offer.error.range-money");
		}
	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {
		assert request != null;
		assert entity != null;

		Date moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
