https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&utf8=1&srsearch=Nelson%20Mandela&sroffset=0

Example adt
```
<#if entries?has_content>
	<#list entries as curEntry>
	<div class="mb-3">
	    <h3>${curEntry.title?remove_beginning("\"")?remove_ending("\"")}</h3>
	    ${curEntry.snippet?remove_beginning("\"")?remove_ending("\"")}... 
		<a href="http://en.wikipedia.org/?curid=${curEntry.pageid}" target="_blank">Wikipedia</a>.
	</div>
	</#list>
</#if>
```