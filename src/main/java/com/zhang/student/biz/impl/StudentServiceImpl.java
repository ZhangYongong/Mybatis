package com.zhang.student.biz.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zhang.student.biz.StudentService;
import com.zhang.student.dao.StudentDao;
import com.zhang.student.dao.impl.StudentDaoImpl;
import com.zhang.student.entity.Student;
import com.zhang.student.utils.StringUtils;

public class StudentServiceImpl implements StudentService{
	/**
	 * 数据持久层
	 */
	private StudentDao studentDao=new StudentDaoImpl();

	/**
	 * 增加学生
	 */
	@Override
	public boolean add(Student student) {
		//业务判断
		if(check(student))
		{
			try {
				return studentDao.add(student);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * 业务层面的逻辑检查
	 * @param student
	 * @return
	 */
	public  boolean  check(Student student) {
		//判断学生学号不可以为空
		if(StringUtils.isEmpty(student.getStudentNo()))
		{
			return false;
		}
		//判断学生学号的长度
		if(student.getStudentNo().length()>6)
		{
			return false;
		}
		
		//省略。。。。。。
		
		
		return true;
	}
	/**
	 * 根据ID查询单条记录
	 */
	@Override
	public Student getStudent(long id) throws SQLException {
		
		return studentDao.getStudent(id);
	}

	/**
	 * 根据条件查询
	 */
	@Override
	public List<Student> getStudents(Map<String, Object> mapCondition) {
		
		// TODO Auto-generated method stub
		return studentDao.getStudent(mapCondition);
	}
}
