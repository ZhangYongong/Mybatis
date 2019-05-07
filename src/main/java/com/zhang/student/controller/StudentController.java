package com.zhang.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhang.student.biz.StudentService;
import com.zhang.student.biz.impl.StudentServiceImpl;
import com.zhang.student.entity.Student;
import com.zhang.student.utils.StringUtils;


@WebServlet(urlPatterns= {"/student"})
public class StudentController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6037748740949965040L;
	
	
	/**
	 * 定义业务层对象
	 */
    private StudentService studentService=new StudentServiceImpl();
	 

	
	/**
	 * Post请求
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//请求字符集
		req.setCharacterEncoding("utf-8");
		
		//设置响应的字符
		resp.setCharacterEncoding("utf-8");
		//设置响应的文件格式
		resp.setContentType("text/json;charset=utf-8");
		
		//响应输出
		PrintWriter out=resp.getWriter();
		boolean res=false;
		String jsonStr=null;
		//业务处理
		switch (req.getParameter("doString")) {
		//增加
		case "add":
			res =addService(req);
				//拼接json数据
			jsonStr = "{\"result\":\""+res+"\"}";
				out.write(jsonStr);
			break;
			//查詢
		case "find":
			List<Student> list=findService(req);
			//查询成功
			if(list!=null&& list.size()>0)
			{
				//将查询的结果列表转换为json对象
				JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
				out.write(array.toJSONString());
			}else {
				out.write("");
			}
			break;
		case "delete":
			
			break;
			
		case "update":
			break;	
			
		default:
			String idSting=req.getParameter("id");
			Student student=findStudent(Long.parseLong(idSting));
			if (student!=null) {
				out.write(JSON.toJSONString(student));
			}else {
				out.write("");
			}
			break;
		}
		
		out.flush();
		
	}

	/**
	 * Get请求
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	
	/**
	 * 处理请求的增加的学生对象
	 * @param req
	 * @return
	 */
	private Student getStudent(HttpServletRequest req) {
		//学号
		String studentNo=req.getParameter("studentNo");
		String studentName=req.getParameter("studentName");
		String loginPwd=req.getParameter("loginPwd");
		String sex=req.getParameter("sex");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String identityCard=req.getParameter("identityCard");
		
		//数据分装
		Student student= new Student(); 
		student.setStudentNo(studentNo);
		student.setStudentName(studentName);
		student.setLoginPwd(loginPwd);
		student.setSex(sex);
		student.setAddress(address);
		student.setEmail(email);
		student.setIdentityCard(identityCard);
		return student;
	}
	/**
	 * 查询条件对象
	 * @param req
	 * @return
	 */
	private Map<String, Object> getMapCondition(HttpServletRequest req) {
		//数据分装
		Map<String, Object> map= new HashMap<String, Object>();
		
		String idString=req.getParameter("id");
		if (StringUtils.isNotEmpty(idString)) {
			map.put("id", idString);
			return map;
		}
		//学号
		String studentNo=req.getParameter("studentNo");
		String studentName=req.getParameter("studentName");
		String loginPwd=req.getParameter("loginPwd");
		String sex=req.getParameter("sex");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String identityCard=req.getParameter("identityCard");
		String phone=req.getParameter("phone");
		String gradeId=req.getParameter("gradeId");
		String bornDate=req.getParameter("bornDate");
		
		if(StringUtils.isNotEmpty(studentNo))
		{
			map.put("studentNo", studentNo.trim());
		}
		if(StringUtils.isNotEmpty(studentName)) {
			
			map.put("studentName", studentName.trim());
		}
		if (StringUtils.isNotEmpty(loginPwd)) {
			map.put("loginPwd", loginPwd.trim());
		}
		if (StringUtils.isNotEmpty(phone)) {
			map.put("phone", phone.trim());
		}
		if (StringUtils.isNotEmpty(gradeId)) {
			map.put("gradeId", gradeId);
		}
		if (StringUtils.isNotEmpty(bornDate)) {
			map.put("bornDate", bornDate.trim());
		}
		if (StringUtils.isNotEmpty(sex)) {
			map.put("sex", sex.trim());
		}
		if (StringUtils.isNotEmpty(address)) {
			map.put("address", address.trim());
		}
		if (StringUtils.isNotEmpty(email)) {
			map.put("email", email.trim());
		}
		if (StringUtils.isNotEmpty(identityCard)) {
			map.put("identityCard", identityCard.trim());
		}
		return map;
	}
	/**
	 * 新增的动作
	 * @param reqest
	 * @return
	 */
	private boolean addService(HttpServletRequest reqest) {
		return studentService.add(getStudent(reqest));
	}
	/**
	 * 查询
	 * @param reqest
	 * @return
	 */
	private List<Student> findService(HttpServletRequest reqest){
		Map<String, Object> mapCondition=getMapCondition(reqest);
		return studentService.getStudents(mapCondition);
	}
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	private Student findStudent(long id) {
		try {
			return studentService.getStudent(id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
