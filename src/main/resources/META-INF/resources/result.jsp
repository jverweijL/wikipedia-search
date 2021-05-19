<%@ taglib prefix="liferay-ddm" uri="http://liferay.com/tld/ddm" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL name="/wikipedia/search" var="search" />

<div class=wikipedia-searchbar">
	<aui:form action="<%= search %>" method="post" name="fm">
		<aui:fieldset cssClass="search-bar mb-3">
			<div class="input-group search-bar-simple">
				<div class="input-group-item search-bar-keywords-input-wrapper">
					<input class="form-control input-group-inset input-group-inset-after search-bar-keywords-input"
						   name="<portlet:namespace/>srsearch"
						   id="<portlet:namespace/>srsearch"
						   placeholder="Search Wikipedia..."
						   title="Search"
						   type="text"
					/>
					<div class="input-group-inset-item input-group-inset-item-after">
						<clay:button
								aria-label='Submit'
								displayType="unstyled"
								icon="search"
								type="submit"
						/>
					</div>
				</div>
			</div>
		</aui:fieldset>
	</aui:form>
</div>
<div class="wikipedia-searchresults">
	<liferay-ddm:template-renderer
			className="<%= WikipediaSearchPortlet.class.getName() %>"
			contextObjects="${contextObjects}"
			displayStyle="<%= displayStyle %>"
			displayStyleGroupId="<%= displayStyleGroupId %>"
			entries="${entries}"
	>
		<clay:alert
				message="Please select a widget template using the configuration settings"
				title="Info"
		/>

	</liferay-ddm:template-renderer>
</div>