<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib prefix="liferay-ddm" uri="http://liferay.com/tld/ddm" %>

<%@ include file="/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="<%=true%>" var="configurationActionURL"/>
<liferay-portlet:renderURL portletConfiguration="<%=true%>" var="configurationRenderURL"/>

<aui:form action="<%=configurationActionURL%>" method="post" name="fm" class="form">
    <aui:input name="<%= Constants.CMD%>" type="hidden" value="<%= Constants.UPDATE%>"/>
    <aui:input name="redirect" type="hidden" value="<%=configurationRenderURL%>"/>

    <div class="portlet-configuration-body-content">
        <div class="container-fluid">
            <%--<p>Do whatever you want todo here.</p>
            <aui:fieldset  markupView="lexicon">
                <aui:input name="preferences--basedir--" label="Define basedir" value="${basedir}"></aui:input>
            </aui:fieldset>--%>
            <aui:fieldset markupView="lexicon">
                <div class="display-template">
                    <liferay-ddm:template-selector
                            className="<%= WikipediaSearchPortlet.class.getName() %>"
                            displayStyle="<%= displayStyle %>"
                            displayStyleGroupId="<%= displayStyleGroupId %>"
                            refreshURL="<%= PortalUtil.getCurrentURL(request) %>"
                            showEmptyOption="<%= true %>"
                    />
                </div>
            </aui:fieldset>

        </div>
    </div>

    <aui:button-row>
        <aui:button cssClass="btn-lg" type="submit"/>
    </aui:button-row>
</aui:form>

<!-- https://www.masteringliferay.com/members/learning-portal/videos/lesson/-/play/making-your-portlets-configurable -->