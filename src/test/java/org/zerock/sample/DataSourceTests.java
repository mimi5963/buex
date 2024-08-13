package org.zerock.sample;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
//spring container 호출 방법  context 와 root-context.xml 가져와야함.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	
	@Autowired
	private TimeMapper timeMapper;

	@Test
	public void test() {
		log.info(timeMapper.getTime2());
	}

}
