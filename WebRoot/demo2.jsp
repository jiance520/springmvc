<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'demo2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/themes/icon.css">
	<style type="text/css">
		
	</style>
  </head>
  
  <body>
    <h2>DataGrid</h2>
	
	<div style="margin:20px 0;"></div>
	
	<table id="dg" class="easyui-datagrid" title="Demo 数据展示" style="width:700px;height:250px"
			data-options="singleSelect:false,collapsible:true,url:'allDemo2',method:'post'">
		
	</table>

  </body>
</html>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.easyui.min.js"></script>
<script type="text/javascript">
//时间格式为字符串
function myformatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
//字符串解析为时间  07/24/2018
function myparser(s){
    if (!s) return new Date();
    var ss = (s.split('-'));
    var y = parseInt(ss[0],10);
    var m = parseInt(ss[1],10);
    var d = parseInt(ss[2],10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
        return new Date(y,m-1,d);
    } else {
        return new Date();
    }
}

      $(function(){
        	//alert(0);
    	  var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
	      pager.pagination({
	            displayMsg:'显示第 {from} 到 {to} 条记录，共 {total} 条记录'
	      });
      })

      //绑定数据
      $('#dg').datagrid({
    	  columns:[[
    		        {field:'ck',checkbox:true},
    		        {field:'did',title:'编号',width:60,sortable:true},
    		        {field:'title',title:'标题',width:100,editor:'text'},
    		        {field:'dtime',title:'时间',width:100,editor:'datetimebox',
    		        	formatter:function(value,row,index){
    		        		var dt = new Date(row.dtime);//转 js 的时间
    		        		var ds = myformatter(dt);
    		        		return ds;
    		        	}
    		        },
    		        {field:'action',title:'操作',width:70,align:'center',
    		            formatter:function(value,row,index){ // value ：当前值，row:行对象，index:行下标
    		                if (row.editing){ // row.editing 是否被编辑
    		                    var s = '<a href="javascript:void(0)" onclick="saverow('+index+')">Save</a> ';
    		                    var c = '<a href="javascript:void(0)" onclick="cancelrow('+index+')">Cancel</a>';
    		                    return s+c;
    		                } else {
    		                    var e = '<a href="javascript:void(0)" onclick="editrow('+index+')">Edit</a> ';
    		                    var d = '<a href="javascript:void(0)" onclick="deleterow('+index+')">Delete</a>';
    		                    return e+d;
    		                }
    		            }
    		        }
              ]] ,
            onBeforeEdit:function(index,row){
  		        row.editing = true;
  		        //重新刷新行
  		        $('#dg').datagrid('refreshRow', index);
  		    },
  		    onAfterEdit:function(index,row){
  		        row.editing = false;
  		        //alert(row.productid);
  		        //alert(row);
  		        var jstr = JSON.stringify(row);//对象转 json string
  		        alert(jstr);
  		        var sobj = JSON.parse(jstr); //json string 转 对象 
  		        //alert(typeof(sobj.dtime));
  		        var dt = sobj.dtime;
  		        //alert(dt.split(" ")[0]);
  		        var dt2 = dt.split(" ")[0];
  		            dt2 = dt2.split("/");
  		        //alert(dt2);
  		        var times = dt2[2]+"-"+dt2[0]+"-"+dt2[1];//转换后的时间
  		        //alert(times);
  		        sobj.dtime = times ;
  		        // 可以发 ajax
  		       $.post('updateDemo',sobj,function(data){
  		        	 if(data == 'true'){
  		        	   $('#dg').datagrid('refreshRow', index);
  		        	 }
  		        }); 
  		        //重新刷新行
  		        //$('#dg').datagrid('refreshRow', index);
  		    },
  		    onCancelEdit:function(index,row){
  		        row.editing = false;
  		        $('#dg').datagrid('refreshRow', index);
  		    } ,
		    pagination:true,
		    pageSize:2,
		    pageList:[2,4,6] 
      }) ;
      
      //-----
        function editrow(index){
		    // 开始编辑，发送命令
		    $('#dg').datagrid('beginEdit', index);
		}
		function deleterow(index){
		    $.messager.confirm('Confirm','Are you sure?',function(r){
		        if (r){
		           // 得到所有行
		           var rows = $('#dg').datagrid('getRows');
		           //alert(rows.length);
		           // 根据下标拿当前行的数据
		           var did2 = rows[index].did ;
		           // 发送ajax
		           $.post('delDemo',{did:did2},function(data){
		                alert(data);
		                if(data == 'true'){
			                // 删除1行，发命令 
			                $('#dg').datagrid('deleteRow', index);
			                $('#dg').datagrid('refreshRow', index);
		                }
		           });
		           
		        }
		    });
		}
		function saverow(index){
		   // 结束编辑 
		    $('#dg').datagrid('endEdit', index);
		}
		function cancelrow(index){
		    $('#dg').datagrid('cancelEdit', index);
		}
		//----
</script>


