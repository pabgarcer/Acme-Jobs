
package acme.features.administrator.announcement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcements.Announcement;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorAnnouncementShowService implements AbstractShowService<Administrator, Announcement> {

	@Autowired
	AdministratorAnnouncementRepository repository;


	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "link", "description", "moment");

	}

	@Override
	public Announcement findOne(final Request<Announcement> request) {
		assert request != null;
		Announcement result;
		result = this.repository.findOneById(request.getModel().getInteger("id"));
		return result;
	}

}
