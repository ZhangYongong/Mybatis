package com.zhang.student.entity;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//数据库ID
		private long id;
		//学生学号
		private String studentNo;
		//学生姓名
		private String studentName;
		//登录密码
		private String loginPwd;
		//年级ID
		private String gradeId;
		//电话
		private String phone;


		//出生日期
		private Date bornDate;
		//性别
		private String sex;
		//地址
		private String address;
		//邮箱
		private String email;
		//身份证
		private String identityCard;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getStudentNo() {
			return studentNo;
		}
		public void setStudentNo(String studentNo) {
			this.studentNo = studentNo;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public String getLoginPwd() {
			return loginPwd;
		}
		public void setLoginPwd(String loginPwd) {
			this.loginPwd = loginPwd;
		}
		public String getGradeId() {
			return gradeId;
		}
		public void setGradeId(String gradeId) {
			this.gradeId = gradeId;
		}
	 	public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public Date getBornDate() {
			return bornDate;
		}
		public void setBornDate(Date bornDate) {
			this.bornDate = bornDate;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getIdentityCard() {
			return identityCard;
		}
		public void setIdentityCard(String identityCard) {
			this.identityCard = identityCard;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", studentNo=" + studentNo + ", studentName=" + studentName + ", loginPwd="
					+ loginPwd + ", gradeId=" + gradeId + ", phone=" + phone + ", bornDate=" + bornDate + ", sex=" + sex
					+ ", address=" + address + ", email=" + email + ", identityCard=" + identityCard + "]";
		}
		
		
}
