package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-redis.xml")
public class TestList {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	/*
	 * ��ѹջ : ����ӵ�Ԫ�����ں��
	 */
	@Test
	public void testSetValue1(){
		redisTemplate.boundListOps("namelist1").rightPush("����");
		redisTemplate.boundListOps("namelist1").rightPush("����");
		redisTemplate.boundListOps("namelist1").rightPush("�ŷ�");
	}
	
	/**
	 * ��ʾ��ѹջ��ֵ
	 */
	@Test
	public void testGetValue1(){
		List list = redisTemplate.boundListOps("namelist1").range(0, 10);
		System.out.println(list);
	}
	
	@Test
	public void delete(){
		redisTemplate.delete("namelist1");
	}
	
	/**
	 * ��ѹջ
	 */
	@Test
	public void testSetValue2(){
		redisTemplate.boundListOps("namelist2").leftPush("����");
		redisTemplate.boundListOps("namelist2").leftPush("����");
		redisTemplate.boundListOps("namelist2").leftPush("�ŷ�");
	}
	
	/**
	 * ��ʾ��ѹջ��ֵ
	 */
	@Test
	public void testGetValue2(){
		List list = redisTemplate.boundListOps("namelist2").range(0, 10);
		System.out.println(list);
	}
	
	/**
	 * ɾ��ֵ
	 */
	@Test
	public void removeValue(){
		redisTemplate.boundListOps("namelist1").remove(0, "����");
	}

}
