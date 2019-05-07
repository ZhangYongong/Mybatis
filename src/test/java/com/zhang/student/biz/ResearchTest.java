package com.zhang.student.biz;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhang.student.dao.impl.StudentDaoImpl;
import com.zhang.student.entity.Student;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application.xml")
public class ResearchTest {
	
	@Resource
	private StudentDaoImpl studentDao;

	@Test
	public void testGetStudent() {
		try {
			Student su = studentDao.getStudent(10);
			System.out.println(su);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
