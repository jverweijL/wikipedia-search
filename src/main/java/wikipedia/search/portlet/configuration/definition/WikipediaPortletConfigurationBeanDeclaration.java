package wikipedia.search.portlet.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import wikipedia.search.portlet.configuration.WikipediaPortletConfiguration;


public class WikipediaPortletConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {
    @Override
    public Class<?> getConfigurationBeanClass()
    {
        return WikipediaPortletConfiguration.class;
    }
}
