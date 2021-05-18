<%@ page import="wikipedia.search.portlet.configuration.WikipediaPortletConfiguration" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="wikipedia.search.portlet.WikipediaSearchPortlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    WikipediaPortletConfiguration portletInstanceConfiguration = portletDisplay.getPortletInstanceConfiguration(WikipediaPortletConfiguration.class);
    String basedir = portletInstanceConfiguration.basedir();
    pageContext.setAttribute("basedir",basedir);

    String displayStyle = portletInstanceConfiguration.displayStyle();
    Long displayStyleGroupId = portletInstanceConfiguration.displayStyleGroupId();

%>