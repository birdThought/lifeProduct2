package com.lifeshs;

//import com.lifeshs.product.api.controller.util.JwtUtil;
import com.github.pagehelper.PageHelper;
import com.lifeshs.product.api.util.JwtUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
@MapperScan("com.lifeshs.product.api.dao")
public class ProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

	/**
	 * 初始化密码加密工具
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * 初始化工具
	 *
	 * @return
	 */
	@Bean
	public JwtUtil jwtUtil() {
		return new JwtUtil();
	}


//	//配置mybatis的分页插件pageHelper
//      @Bean
//      public PageHelper pageHelper(){
//		         PageHelper pageHelper = new PageHelper();
//		         Properties properties = new Properties();
//		         properties.setProperty("offsetAsPageNum","true");
//		         properties.setProperty("rowBoundsWithCount","true");
//		         properties.setProperty("reasonable","true");
//		        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
//		        pageHelper.setProperties(properties);
//		        return pageHelper;
//		}



}
