package wikipedia.search.portlet.action;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import org.osgi.service.component.annotations.Component;
import wikipedia.search.constants.WikipediaSearchPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + WikipediaSearchPortletKeys.WIKIPEDIASEARCH
        },
        service = ConfigurationAction.class
)
public class WikipediaPortletConfigurationAction extends DefaultConfigurationAction {
    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception
    {
        super.processAction(portletConfig,actionRequest,actionResponse);
    }
}
