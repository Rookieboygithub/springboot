package com.springboot.config;

import com.springboot.interceptor.InterceptorByinterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 通过继承WebMvcConfigurerAdapter，配置springMVC
 */
@Configuration
public class WebCofigByClass extends WebMvcConfigurerAdapter {
	/**
	 * 注册前端控制器
	 *
	 * @return
	 */
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		WebCofigByClass adapter = new WebCofigByClass();
		return adapter;
	}

	/**
	 * 配置视图
	 *
	 * @param registry
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
		registry.viewResolver(resourceViewResolver());
	}

	/**
	 * 配置视图映射
	 *
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver resourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		//请求视图文件的前缀地址
		internalResourceViewResolver.setPrefix("/templates/");
		//请求视图文件的后缀
		internalResourceViewResolver.setSuffix(".html");
		return internalResourceViewResolver;
	}

	/**
	 * 重写addViewControllers:跳转指定页面
	 *
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("/login").setViewName("login");
	}

	/**
	 * 重写addCorsMappings：跨域设置
	 *
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		super.addCorsMappings(registry);
		registry.addMapping("/cors/**")
				.allowedHeaders("*")
				.allowedMethods("POST", "GET")
				.allowedOrigins("*");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(new InterceptorByinterface());
	}

	/**
	 * 配置静态资源
	 *
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/").addResourceLocations("/templates/");
	}
}
