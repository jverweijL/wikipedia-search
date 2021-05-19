package wikipedia.search.portlet.action;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;
import wikipedia.search.constants.WikipediaSearchPortletKeys;

import javax.portlet.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + WikipediaSearchPortletKeys.WIKIPEDIASEARCH,
                "mvc.command.name=" + WikipediaSearchPortletKeys.SEARCH_COMMAND
        },
        service = MVCActionCommand.class
)
public class WikipediaSearchMVCActionCommand extends BaseMVCActionCommand {
    // //https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&utf8=1&srsearch=Nelson%20Mandela&sroffset=0

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        _log.debug("the search is on...");

        String query = URLEncoder.encode(ParamUtil.getString(actionRequest, "srsearch"),"UTF-8");
        int offset = 0;

        ObjectMapper mapper = new ObjectMapper();

        HttpUriRequest request = RequestBuilder
                .get("https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&utf8=1&srsearch=" + query + "&sroffset="+offset)
                .build();

        try {

            List<JsonNode> entries = new ArrayList<>();

            JsonNode jsonResult = mapper.readTree(getRequest(request));
            JsonNode results = jsonResult.get("query").get("search");

            _log.debug("results is array: " + results.isArray());

            if (results.isArray()) {
                for (final JsonNode objNode : results) {
                    entries.add(objNode);
                }
            }

            _log.debug("# of entries: " + entries.size());

            actionRequest.setAttribute("entries",entries);

            _log.debug("the result is " + jsonResult);
        } catch (IOException e) {
            e.printStackTrace();
        }

        _log.debug("the search is done");

        hideDefaultSuccessMessage(actionRequest);
    }

    private String getRequest(HttpUriRequest request) {
        HttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = null;
        try {
            response = client.execute(request);
            HttpEntity entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(entity, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    private static final Log _log = LogFactoryUtil.getLog(WikipediaSearchMVCActionCommand.class);
}