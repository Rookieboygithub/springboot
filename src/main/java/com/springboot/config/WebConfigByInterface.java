package com.springboot.config;

import com.springboot.factory.EnumConverterFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * 通过实现webMvcConfiguer配置springMVC
 */
public class WebConfigByInterface implements WebMvcConfigurer {
	/**
	 * 设置路径是否匹配（.）和（/）
	 *
	 * @param configurer
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false).setUseTrailingSlashMatch(true);
	}

	/**
	 * 配置内容裁决
	 *
	 * @param configurer
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true)//是否通过url的扩展名来决定media type
				.ignoreAcceptHeader(true)  //不检查Accept请求头
				.parameterName("mediaType")
				.defaultContentType(MediaType.TEXT_HTML) //设置默认的media type
				.mediaType("html", MediaType.TEXT_HTML) //请求以.html结尾的会被当成MediaType.TEXT_HTML
				.mediaType("json", MediaType.APPLICATION_JSON);//请求以.json结尾的会被当成MediaType.APPLICATION_JSON
	}

	/**
	 * 配置异步请求
	 * @param configurer
	 */
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

	}

	/**
	 * 映射/*，如果没有合适的handler处理，使用DefaultServletHandlerConfigurer处理
	 *
	 * @param configurer
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * 注册自定义的Formatter和Convert,例如, 对于日期类型,枚举类型的转化.
	 * 不过对于日期类型,使用更多的是使用
	 * @DateTimeFormat(pattern = "yyyy-MM-dd")
	 * private Date createTime;
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		WebMvcConfigurer.super.addFormatters(registry);
		registry.addConverterFactory(new EnumConverterFactory());
	}

	/**
	 * 添加自定义拦截器
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

	}

	/**
	 * 添加静态资源处理器
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/").addResourceLocations("/templates/");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {

	}

	/**
	 * 实现请求到视图的映射
	 *
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//开启内容裁决
		registry.enableContentNegotiation();
		//对jsp文件进行解析
		registry.jsp("/jsp/", ".jsp");
		//将视图名解析成Bean，容器中有返回bean
		registry.beanName();
		//registry.viewResolver();注册视图
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

	}

	@Override
	public Validator getValidator() {
		return null;
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		return null;
	}

}
