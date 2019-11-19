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
	<acme:form-textbox code="administrator.non-commercial-banner.form.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.non-commercial-banner.form.label.link" path="link"/>
	<acme:form-textbox code="administrator.non-commercial-banner.form.label.jingle" path="jingle"/>
	<acme:form-url code="administrator.commercial-banner.form.label.picture" path="picture"/>
	<jstl:if test="${command != 'create'}">
	<img src="${picture}" vspace="20" height="200" width="300">
	<acme:menu-separator/>
	</jstl:if>
	
	
	<acme:form-submit test="${command == 'show'}"
		code="administrator.non-commercial-banner.form.button.update"
		action="/administrator/non-commercial-banner/update"/>
	<acme:form-submit test="${command == 'show'}"
		code="administrator.non-commercial-banner.form.button.delete"
		action="/administrator/non-commercial-banner/delete"/>
	<acme:form-submit test="${command == 'create'}"
		code="administrator.non-commercial-banner.form.button.create"
		action="/administrator/non-commercial-banner/create"/>
	<acme:form-submit test="${command == 'update'}"
		code="administrator.non-commercial-banner.form.button.update"
		action="/administrator/non-commercial-banner/update"/>
	<acme:form-submit test="${command == 'delete'}"
		code="administrator.non-commercial-banner.form.button.delete"
		action="/administrator/non-commercial-banner/delete"/>
  	<acme:form-return 
  		code="administrator.non-commercial-banner.form.button.return"/>
</acme:form>
