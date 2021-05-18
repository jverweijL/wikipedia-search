package wikipedia.search.portlet;


import com.fasterxml.jackson.databind.JsonNode;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.wiki.constants.WikiPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import wikipedia.search.constants.WikipediaSearchPortletKeys;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author jverweij
 *
 */
@Component(
	immediate = true,
	property = {
			"javax.portlet.name="+ WikipediaSearchPortletKeys.WIKIPEDIASEARCH
	},
	service =  TemplateHandler.class
)
public class WikipediaPortletDisplayTemplateHandler extends BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {
		return WikipediaSearchPortlet.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", locale, getClass());

		String portletTitle = _portal.getPortletTitle(
				WikipediaSearchPortletKeys.WIKIPEDIASEARCH, resourceBundle);

		return portletTitle.concat(StringPool.SPACE).concat(
				LanguageUtil.get(locale, "template"));
	}

	@Override
	public String getResourceName() {
		return WikipediaSearchPortletKeys.WIKIPEDIASEARCH;
	}

	@Override
	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
			long classPK, String language, Locale locale)
			throws Exception {

		Map<String, TemplateVariableGroup> templateVariableGroups =
				super.getTemplateVariableGroups(classPK, language, locale);

		TemplateVariableGroup fieldsTemplateVariableGroup =
				templateVariableGroups.get("fields");

		//fieldsTemplateVariableGroup.empty();

		/*fieldsTemplateVariableGroup.addVariable(
				"wiki-page-content", String.class, "formattedContent");*/

		//TODO implement see : https://github.com/liferay/liferay-portal/blob/7.0.6-ga7/modules/apps/collaboration/wiki/wiki-web/src/main/java/com/liferay/wiki/web/internal/portlet/template/WikiPortletDisplayTemplateHandler.java

		return templateVariableGroups;
	}

	@Reference
	private Portal _portal;
}