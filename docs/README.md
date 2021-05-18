# Wikipedia Search

Based upon the Wikipedia api this widget allows you to search Wikipedia and display results using an Widget Template (ADT).

Inspired by a prospect that needed this for background investigation and a search workshop to the many options you have with search in Liferay.

Example Wikipedia API call `https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&utf8=1&srsearch=Nelson%20Mandela&sroffset=0`

Developed to run on the following versions of Liferay: `Liferay DXP 7.3`

Built with [Liferay Workspace](https://help.liferay.com/hc/en-us/articles/360029147471-Liferay-Workspace) and [Blade CLI](https://help.liferay.com/hc/en-us/articles/360029147071-Blade-CLI).

*Example result using Wikipedia Search Widget*

![screenshot](img01.png)

## How to Build and Deploy to Liferay

Follow the steps below to build and deploy or copy the modules from the [releases](../../releases/latest) page to your Liferay's deploy folder.

In order to build or deploy this module you will need to [install Blade CLI](https://help.liferay.com/hc/en-us/articles/360028833852-Installing-Blade-CLI).

### To Build

`$ blade gw build`

You can find the built modules at `modules/{module-name}/build/libs/{module-name}.jar`.

### To Deploy

In `gradle-local.properties` add the following line to point towards the Liferay instance you want to deploy to:
```
liferay.workspace.home.dir=/path/to/liferay/home
```

`$ blade gw deploy`

## Usage

[Adding Widgets to a Page.](https://learn.liferay.com/dxp/7.x/en/site-building/creating-pages/using-widget-pages/adding-widgets-to-a-page.html)


1. Create a Widget Template
1. Configure the Widget Template in the configuration settings of the widget

Very basic example Widget Template (a.k.a. ADT)
```
<#if entries?has_content>
	<#list entries as curEntry>
		<div class="mb-3">
		${curEntry.title}
		</div>
	</#list>
</#if>
```

Example Widget Template (a.k.a. ADT)
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

### Features

* Search Wikipedia
* Widget Template supported
* Configuration


## Issues & Questions Welcome