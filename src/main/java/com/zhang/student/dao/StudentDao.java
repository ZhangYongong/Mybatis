package com.zhang.student.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zhang.student.entity.Student;


public interface StudentDao {
	/**
	 * 学生增加
	 * @param student
	 * @return
	 */
	boolean add(Student student) throws SQLException;
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	boolean delete(long id);
	/**
	 * 修改学生
	 * @param student
	 * @return
	 */
	Student update(Student student);
	/**
	 * 根据ID查找学生对象
	 * @param id
	 * @return
	 */
	Student getStudent(long id) throws SQLException;
	/**
	 * 根据条件查询所有学生
	 * @param conditionMap
	 * @return
	 */
	List<Student> getStudent(Map<String, Object> conditionMap);
	
}
