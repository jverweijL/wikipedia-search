package wikipedia.search.portlet;

import wikipedia.search.constants.WikipediaSearchPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jverweij
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=WikipediaSearch",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/result.jsp",
		"javax.portlet.name=" + WikipediaSearchPortletKeys.WIKIPEDIASEARCH,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class WikipediaSearchPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
					   RenderResponse renderResponse) throws PortletException, IOException {

		Map<String, Object> contextObjects = new HashMap<>();

		renderRequest.setAttribute("contextObjects", contextObjects);

		super.render(renderRequest, renderResponse);
	}
}