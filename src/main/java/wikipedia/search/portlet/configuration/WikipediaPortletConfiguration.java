package wikipedia.search.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
        category = "liferay-custom",
        scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
@Meta.OCD(
        id = "wikipedia.search.portlet.configuration.WikipediaPortletConfiguration"
)
public interface WikipediaPortletConfiguration {
    @Meta.AD(deflt = "", required = false)
    String basedir();

    @Meta.AD(deflt = "", name = "display-style", required = false)
    public String displayStyle();

    @Meta.AD(deflt = "0", name = "display-style-group-id", required = false)
    public long displayStyleGroupId();
}
