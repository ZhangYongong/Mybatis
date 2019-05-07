package com.zhang.student.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.zhang.student.dao.StudentDao;
import com.zhang.student.dao.dbutils.DbConnection;
import com.zhang.student.entity.Student;
import com.zhang.student.utils.StringUtils;

public class StudentDaoImpl implements StudentDao {
	//使用第三方插件
		private	QueryRunner queryRunner = new QueryRunner(DbConnection.getDataSource());
		@Override
		public boolean add(Student student) throws SQLException {
			//参数列表
			List<Object> list=new ArrayList<Object>();
			//执行的SQL
			String sql="insert into tb_student (studentNo,studentName,loginPwd,sex,address,email,identityCard";
			//添加属性
			list.add(student.getStudentNo());
			list.add(student.getStudentName());
			list.add(student.getLoginPwd());
			list.add(student.getSex());
			list.add(student.getAddress());
			list.add(student.getEmail());
			list.add(student.getIdentityCard());
			
			//执行的SQL处理
			StringBuilder sbSQL= new StringBuilder(sql);
			StringBuilder sqlBuilder=new StringBuilder();
			//判断学生对象的年级不为空
			if(StringUtils.isNotEmpty(student.getGradeId()))
			{
				sbSQL.append(",gradeId");
				list.add(student.getGradeId());
				sqlBuilder.append(",?");
			}
			//电话
			if(StringUtils.isNotEmpty(student.getPhone()))
			{
				sbSQL.append(",phone");
				list.add(student.getPhone());
				sqlBuilder.append(",?");
			}
			//生日
			if(StringUtils.isNotEmpty(student.getPhone()))
			{
				sbSQL.append(",bornDate");
				list.add(student.getBornDate());
				sqlBuilder.append(",?");
			}
			sbSQL.append(") values(?,?,?,?,?,?,?");
			sbSQL.append(sqlBuilder);
			sbSQL.append(")");
			
			Object[] params=list.toArray();
			
			//调用第三方插入方法
			Student su=queryRunner.insert(sbSQL.toString(), new ResultSetHandler<Student>() {

				@Override
				public Student handle(ResultSet rs) throws SQLException {
					Student suStudent;
					if(rs.next())
					{
						suStudent=new Student();
						suStudent.setId(rs.getLong(1));
						return suStudent;
					}
					return null;
				}
				
			}, params);
			if(su!=null&&su.getId()>0)
			{
				return true;
			}
			return false;
		}

		@Override
		public boolean delete(long id) {
			String sql = "delete from tb_student where id=?";
			Object[] params = new Object[1];
			params[0] = id;
			return false;
		}

		@Override
		public Student update(Student student) {
			
			return null;
		}

		@Override
		public Student getStudent(long id) throws SQLException {
			//查询语句
			String sql="select * from tb_student where id=?";
			//查询ID参数
			Object[] params=new Object[1];
			params[0]=id;
			//查询
			Student student=queryRunner.query(sql,  new ResultSetHandler<Student>() {

				@Override
				public Student handle(ResultSet rs) throws SQLException {
					Student student=new Student();
					if(rs.next())
					{
						return doStudent(rs, student);
					}
					return null;
				}
				
			}, params);
			return student;
		}

		@Override
		public List<Student> getStudent(Map<String, Object> conditionMap) {
			// TODO Auto-generated method stub
			return null;
		}
		
		/**
		 * 合并产生学生对象
		 * @param rs
		 * @param student
		 * @return
		 * @throws SQLException
		 */
		private Student doStudent(ResultSet rs, Student student) throws SQLException {
			//设定ID
			student.setId(rs.getLong(1));
			//学号
			student.setStudentNo(rs.getString("studentNo"));
			//姓名
			student.setStudentName(rs.getString("setStudentName"));
			//密码
			student.setLoginPwd(rs.getString("loginPwd"));
			//年级ID
			student.setGradeId(rs.getString("gradeId"));
			//电话
			student.setPhone(rs.getString("phone"));
			//生日
			student.setBornDate(rs.getDate("bornDate"));
			//学号
			student.setStudentNo(rs.getString("studentNo"));
			//性别
			student.setSex(rs.getString("sex"));
			//地址
			student.setAddress(rs.getString("address"));
			//邮箱
			student.setEmail(rs.getString("email"));
			//身份证
			student.setIdentityCard(rs.getString("identityCard"));
			return student;
		}
}
