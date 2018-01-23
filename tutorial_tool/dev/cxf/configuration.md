#### 使用Spring和Tomcat发布CXF REST WebService
1. 在 web.xml 中配置 CXFServlet

```
    <!-- Apache CXF Service (SOAP) -->
    <servlet>
        <servlet-name>CXFServlet</servlet-name>
        <servlet-class>org.apache.cxf.transport.servlet.CXFServlet</servlet-class>
        <init-param>
            <param-name>com.sun.jersey.api.json.POJOMappingFeature</param-name>
            <param-value>true</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>CXFServlet</servlet-name>
        <!-- <url-pattern>/services/*</url-pattern> -->
        <url-pattern>/*</url-pattern>
    </servlet-mapping>
```

2. 在 Spring 配置文件中加入以下内容：

```
xmlns:jaxrs="http://cxf.apache.org/jaxrs"
http://cxf.apache.org/jaxrs http://cxf.apache.org/schemas/jaxrs.xsd

<!-- 发布RESTful Services -->
<!-- <jaxrs:server id="restServiceContainer" address="/rest"> -->
<jaxrs:server id="restServiceContainer" address="/">
	<jaxrs:serviceBeans>
		<!-- 爬虫原始数据 -->
		<ref bean="crawlerStandardImpl" />
		<!-- SDK原始数据 -->
		<ref bean="sdkStandardImpl" />
		<!-- 爬虫统计数据 -->
		<ref bean="sdkStatisticsImpl" />
	</jaxrs:serviceBeans>

	<jaxrs:extensionMappings>
		<entry key="json" value="application/json" />
		<entry key="xml" value="application/xml" />
	</jaxrs:extensionMappings>
	<jaxrs:languageMappings>
		<entry key="en" value="en-gb" />
	</jaxrs:languageMappings>
	<jaxrs:providers>
		<bean class="com.rrx360.credit.dsu.backend.provider.JacksonJsonpProvider" />
	</jaxrs:providers>
	<jaxrs:features>
		<cxf:logging />
	</jaxrs:features>
</jaxrs:server>
```

3. 实现类的注解
```
@WebService
@Path("/crawler")
public interface CrawlerStandard {

  @Path("/v1")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  ServiceResponse<JSONObject> getCrawlerStandardResult(CrawlerStandardRequest c_stand_request);

}
```

