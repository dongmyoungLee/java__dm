package com.dm.springboot.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.dm.springboot.model.mapper")
public class MapperConfig {

}
