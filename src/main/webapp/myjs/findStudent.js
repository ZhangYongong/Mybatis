/**
 * 学生查询
 */
//文档加载后执行
$(function(){
	//绑定事件
	$('#find').click(function(){
		var url="../student?doString=find";
		var data={
				studentNo:$("#studentNo").val(),
				studentName:$("#studentName").val(),
				phone:$("#phone").val(),
				address:$("#address").val(),	
		};
		
		$.post(url,data,function(jsonData){
			console.log(jsonData);
			//判断对象
			if(jsonData)
			{
				$(".table").append("<caption>学生信息</caption>");
				$(".table").append("<thead><tr><th>学生学号</th><th>学生姓名</th><th>学生电话</th><th>学生地址</th></tr></thead>");
				var info="";
				
				for(var i=0;i<jsonData.length;i++)
				{
					if((i+1)%4==1)
					{
						info+="<tr class='active'>";
					}else if((i+1)%4==2)
					{
						info+="<tr class='success'>";
					}else if((i+1)%4==3)
					{
						info+="<tr class='warning'>";
					}else {
						info+="<tr class='danger'>";
					}
					
					info+="<td>"+jsonData[i]["studentNo"]+"</td>";	
					info+="<td>"+jsonData[i]["studentName"]+"</td>";	
					info+="<td>"+jsonData[i]["phone"]+"</td>";	
					info+="<td>"+jsonData[i]["address"]+"</td>";	
					info+="</tr>";
				}
				$(".table").append(info);
				
			}
		});
	});
});


