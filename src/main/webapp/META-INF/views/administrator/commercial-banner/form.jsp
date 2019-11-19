<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.commercial-banner.form.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.commercial-banner.form.label.link" path="link"/>
	<acme:form-textbox code="administrator.commercial-banner.form.label.credit-card" path="creditCard" placeholder="1234 5678 9012 3456"/>
	<acme:form-url code="administrator.commercial-banner.form.label.picture" path="picture"/>
	<jstl:if test="${command != 'create'}">
	<img src="${picture}" vspace="20" height="200" width="300">
	<acme:menu-separator/>
	</jstl:if>
	
	<acme:form-submit test="${command == 'show'}"
		code="administrator.commercial-banner.form.button.update"
		action="/administrator/commercial-banner/update"/>
	<acme:form-submit test="${command == 'show'}"
		code="administrator.commercial-banner.form.button.delete"
		action="/administrator/commercial-banner/delete"/>
	<acme:form-submit test="${command == 'create'}"
		code="administrator.commercial-banner.form.button.create"
		action="/administrator/commercial-banner/create"/>
	<acme:form-submit test="${command == 'update'}"
		code="administrator.commercial-banner.form.button.update"
		action="/administrator/commercial-banner/update"/>
	<acme:form-submit test="${command == 'delete'}"
		code="administrator.commercial-banner.form.button.delete"
		action="/administrator/commercial-banner/delete"/>
  	<acme:form-return 
  		code="administrator.commercial-banner.form.button.return"/>
</acme:form>
