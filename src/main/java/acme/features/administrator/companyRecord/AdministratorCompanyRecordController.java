
package acme.features.administrator.companyRecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.companyRecords.CompanyRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("administrator/company-record/")
public class AdministratorCompanyRecordController extends AbstractController<Administrator, CompanyRecord> {

	@Autowired
	AdministratorCompanyRecordListService	listService;

	@Autowired
	AdministratorCompanyRecordShowService	showService;

	@Autowired
	AdministratorCompanyRecordCreateService	createService;

	@Autowired
	AdministratorCompanyRecordUpdateService	updateService;

	@Autowired
	AdministratorCompanyRecordDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);

	}

}
