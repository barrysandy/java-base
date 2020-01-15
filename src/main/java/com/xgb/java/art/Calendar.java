package com.xgb.java.art;

public class Calendar {
	<!DOCTYPE html>
	<html>
	  <head>
	  <meta charset="UTF-8">
	    <title></title>
	    <style>
	        table{text-align: center;border-collapse:collapse;}
	        .active{color:deeppink;}
	    </style>
	  </head>
	<body>
	
	</body>
	<script type="text/javascript">
	    //获取时间
	    var date = new Date();
	    var y = date.getFullYear();
	    var _m = date.getMonth();
	    var d = date.getDate();
	    var monthArr = [31,getFubuary(),31,30,31,30,31,31,30,31,30,31];
	
	    //console.log(y,_m,d,monthArr);
	
	    //生成日历
	    loadcalendar(document.body);
	
	    function loadcalendar(dom,month,year){
	    dom.innerHTML = '';
	    var tab = document.createElement("table");
	    tab.className = "calendar";
	    var date = new Date();
	    var y = year || date.getFullYear();
	    var m = month || _m;
	
	    //console.log(m);
	    var firstDay = new Date(y,m,1).getDay();
	    var numRow = Math.ceil((firstDay + monthArr[m]) / 7);
	    tab.setAttribute("border","1");
	    var calendarStr = "",dayID;
	    for(var i = 0;i < numRow;i++){
	        calendarStr += "<tr>";
	        for(var j = 0;j < 7;j++){
	            dayID = 7*i + j -firstDay + 1;
	            if(dayID <= 0 || dayID > monthArr[m]){dayID=''};
	                dayID == d && m == date.getMonth()?calendarStr += "<td class='active'>" + dayID + "</td>":calendarStr += "<td>" + dayID + "</td>";
	            };
	        calendarStr += "</tr>";
	    }
	        //console.log(calendarStr);
	        tab.innerHTML = "<caption><button id='reduce2' style='float:left;border:0;background:0;'>--</button><button id='reduce' style='float:left;border:0;background:0;'>-</button><button id='add2' style='float:right;border:0;background:0;'>++</button><button id='add' style='float:right;border:0;background:0;'>+</button>" + y + "年" + (parseInt(m) + parseInt(1)) + "月" +  "</caption><th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th>" + calendarStr;
	        //将日历加入body中
	        dom.appendChild(tab);
	    };
	
	        //判断是否是闰年
	        function getFubuary(year){
	            if(year % 4){
	                return 28;
	            }else{
	            if(year % 100){
	                return 29
	            }else{
	                return 28;
	            }
	           }
	    }
	
	    //增加减少月份功能实现
	    document.body.addEventListener("click",function(e){
	        var m = _m;
	        var _year = y;
	        var e = e || window.event;
	        if(e.target.id == "reduce"){
	            //console.log(0)
	            if(_m > 0){
	                _m -= 1;
	            }else{
	                _m = 12;
	                _year -= 1;
	            }
	            m = _m;
	            loadcalendar(document.body,m,_year);
	        };
	        if(e.target.id == "reduce2"){
	            if(y > 0){
	                y -= 1;
	            }
	            console.log(y)
	            _year = y;
	            loadcalendar(document.body,m,_year);
	        };
	        if(e.target.id == "add"){
	            //console.log(1)
	            if(_m < 11){
	                _m += 1;
	            }else{
	                _m = 1;
	                y += 1;
	            }
	            m = _m;
	            loadcalendar(document.body,m,_year);
	        }
	        if(e.target.id == "add2"){
	            if(y < 10000){
	                y += 1;
	            }
	            console.log(y)
	            _year = y;
	            loadcalendar(document.body,m,_year);
	        }
	    });
	</script>
	</html>
}

