<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testchart2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath %>js/jquery-1.12.4.js"></script>
    <!-- ECharts单文件引入 -->
    <script type="text/javascript" src="<%=basePath %>build/dist/echarts-all.js"></script>
    <script type="text/javascript">
    var names = [];
    var year11 = [];
    var year12 = [];
    $(function(){
    	//alert(0);
    	//发ajax
    	/*
    	$.post('/springmvc/chart1',{type:'柱状图'},function(data){
    		//alert(data);
    		names = data.names;
    		year11 = data.year11;
    		year12 = data.year12;
    	
    		// 显示图表
        	showchart();
    	},'json');
    	*/
    	$.ajax({
	    	  type: "POST",
	    	  url: "/springmvc/chart1",
	    	  data: "type=柱状图",
	    	  dataType: "json",
	    	  async: false,
	    	  success: function(data){
	    		names = data.names;
	      		year11 = data.year11;
	      		year12 = data.year12;
	    	  }
	    }) ;
    	
    	// 显示图表
    	showchart();
    	
    })
    
    // 显示图表
    function showchart(){
	    // 基于准备好的dom，初始化echarts图表
	    var myChart = echarts.init(document.getElementById('main')); 
	    
	    var option = {
	    	    title : {
	    	        text: '世界人口总量',
	    	        subtext: '数据来自网络'
	    	    },
	    	    tooltip : {
	    	        trigger: 'axis'
	    	    },
	    	    legend: {
	    	        data:['2011年', '2012年']
	    	    },
	    	    toolbox: {
	    	        show : true,
	    	        feature : {
	    	            mark : {show: true},
	    	            dataView : {show: true, readOnly: false},
	    	            magicType: {show: true, type: ['line', 'bar']},
	    	            restore : {show: true},
	    	            saveAsImage : {show: true}
	    	        }
	    	    },
	    	    calculable : true,
	    	    xAxis : [
	    	        {
	    	            type : 'value',
	    	            boundaryGap : [0, 0.01]
	    	        }
	    	    ],
	    	    yAxis : [
	    	        {
	    	            type : 'category',
	    	            data : names
	    	        }
	    	    ],
	    	    series : [
	    	        {
	    	            name:'2011年',
	    	            type:'bar',
	    	            data:year11
	    	        },
	    	        {
	    	            name:'2012年',
	    	            type:'bar',
	    	            data:year12
	    	        }
	    	    ]
	    	};
	    	                    
	    // 为echarts对象加载数据 
	    myChart.setOption(option); 
    }
    </script>
  </head>
  
  <body>
    <h1>Echart 测试2</h1>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:400px"></div>
  </body>
</html>
