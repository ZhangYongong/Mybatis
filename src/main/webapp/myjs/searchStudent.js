/**
 * 
 */

$(function(){
	initTable();
	$("#search").click(function(){
		
	});
});
var _table=$("#table");
var columns=[
	{
        field: 'studentNo',
        title: '学生学号'
    },
    {
        field: 'studentName',
        title: '学生姓名'
    },
    {
        field: 'phone',
        title: '学生电话'
    },
    {
        field: 'address',
        title: '学生地址'
    },
    {
        field: 'bornDate',
        title: '学生生日',
        width: 120,
        align: 'center',
        valign: 'middle',
        formatter: formatterDate,
    },
    {
        field: '',
        title: '操作',
        width: 120,
        align: 'center',
        valign: 'middle',
        formatter: actionFormatter,
    }
];
//格式化
function formatterDate(){
	
}
//格式化
function formatterDate(){
	var id = value;
    var result = "";
    result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"EditViewById('" + id + "', view='view')\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"DeleteByIds('" + id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}
function initTable(){
	_table.bootstrapTable({  
        url: "../student?doString=search",  
        method: 'get',
        pagination: true,  //表格底部显示分页条
        sidePagination: "server",
        escape:false, //启动转义字符
        pageSize: 10, //每页显示多少条数据
        pageNumber: 1, //初始化翻页的页码
        pageList: [10, 25, 50, 100],
        queryParamsType:'',//设置请求参数格式
        queryParams:function queryParams(params) {   //设自定义查询参数
            var param = {
            	pageSize: params.pageSize,   //每页多少条数据
            	pageIndex: params.pageNumber, // 页码
            	studentNo: $("#studentNo").val(),//学号
            	studentName: $("#studentName").val(), //学生姓名
            	phone: $("#phone").val(),//电话
            	address: $("#address").val() //地址
            };
            return param;
        }
    });
}