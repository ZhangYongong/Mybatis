$(function(){
	
	//添加增加学生按钮事件
	$("#add").on("click",function(){
		var data={
			studentNo:$("#studentNo").val(),
			studentName:$("#studentName").val(),
			loginPwd:$("#loginPwd").val(),
			sex:$("[name=studentSex]:checked").val(),
			address:$("#address").val(),
			email:$("#email").val(),
			identityCard:$("#identityCard").val()
		};
		
		$.post("../student?doString=add",data,function(json){
			if(json)
			{
				var res=json["result"];
				if(res=="true")
				{
					alert("新增学生成功。");
				}else{
					alert("新增学生失败。");
				}
			}else{
				alert("新增学生失败。");
			}
			
		});
	});
});