package com.zhang.student.biz;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zhang.student.entity.Student;

public interface StudentService {
	/**
	 * 增加学生
	 * @param student
	 * @return
	 */
	public boolean add(Student student);
	/**
	 * 根据ID查找学生对象
	 * @param id
	 * @return
	 */
	public Student getStudent(long id) throws SQLException;
	
	/**
	 * 根据条件查询所有学生
	 * @param mapCondition
	 * @return
	 */
	List<Student> getStudents(Map<String, Object> mapCondition);
}
