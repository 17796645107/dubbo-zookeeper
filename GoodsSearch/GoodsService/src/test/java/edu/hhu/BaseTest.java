package edu.hhu;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-context.xml","classpath:config/spring-mybatis.xml"})
public class BaseTest {

}
