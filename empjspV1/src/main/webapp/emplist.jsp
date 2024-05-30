<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>
    <script src="../script/script.js"></script>
    
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p id=nowtime>
                    2009/11/20
                    <br/>
                    <a href="javascript:;" @click="logout">安全退出</a>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="/ems_vue/emplist.html">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami" style="padding-top:10px">
            </p>
            <h1>
                ようこそ${sessionScope.user.realname}!
            </h1>
      <div style="margin-bottom: 10px; text-align:right; ">
		 <form action="${pageContext.request.contextPath}/employee/search" method="post" onsubmit="return validOrNot()">
		    
		    名前<input type="text"  name="searchname" style="width: 60px"/>
		    
		    誕生日範囲<input type="text" name="dateBegin" style="width: 70px" placeholder="2000/01/01" />
		    <input type="text" name="dateEnd" style="width: 70px" placeholder="2000/01/01" />まで
		
		    <input type="submit" class="button" value="検索" />
		    <div><span></span><span></span></div>
		 
		  </form>
         </div>   
            <table class="table" style="text-align:center;">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        名前
                    </td>
                    <td>
                        誕生日
                    </td>
                    <td>
                        月給
                    </td>
                    <td>
                        性別
                    </td>
                    <td>
                        操作
                    </td>
                </tr>
                <c:forEach items ="${requestScope.employee}" var="employee" varStatus="sta">
                <tr
                	<c:if test="${sta.index%2==0}">
                		class="row1"
                	</c:if>
                	<c:if test="${sta.index%2==1}">
                		class="row2"
                	</c:if>

                 >
                    <td>
                      ${employee.id} 
                    </td>
                    <td>
                         ${employee.name} 
                    </td>
                    <td>
                    <fmt:formatDate value="${employee.birthday}" pattern="yyyy/MM/dd"/>
                     	 
                    </td>
                    <td>
                    	${employee.salary}
                    </td>
                    <td>
                       ${employee.gender?"男":"女"}
                    </td>
                    <td>
                        <a href="javascript:;" onclick="deleteEmployee(${employee.id})">削除</a>
                        <script>
                        	function deleteEmployee(id){
                            	if(window.confirm("このレコ－ドは削除していいですか？")){
									location.href='${pageContext.request.contextPath}/employee/delete?id='+id
                                }
                            }
                        </script>                  
                              
                                             
                        &nbsp;<a href="${pageContext.request.contextPath}/employee/detail?id=${employee.id}">
                        更新</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <p>
                <input type="button" class="button" value="社員を追加する" onclick="location='${pageContext.request.contextPath}/addEmp.jsp'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
<script>
  
        const nowtime = document.querySelector('#nowtime')

        setInterval(()=>{
            nowtime.innerHTML=gettime()
        },1000)
</script>
<script>    
    var span = document.querySelectorAll('span')
    
    function validOrNot() {
     
      var searchName = searchname.value
      var dateBegin = dateBegin.value
      var dateEnd = idateEnd.value

      /
      if (checkName(searchName) && checkDate(dateBegin, dateEnd)) {
        return true
      } else {
        return false
      }

    }

    function checkName(name) {

      var regxName = /^\w{4,16}$/

      if (name.match(regxName)) {
        "
       	return true;
      } else {
       
        span[0].innerHTML = "誤る名前を入力している。"
        return false;
      }

    }
    
    function checkDate(dateBegin, dateEnd) {
      
      for (let i = 0; i < span.length; i++) {
        span[i].innerHTML = ''
      }

      
      var regxdate = /^(19|20)\d{2}-0[1-9]|1[0-2]-0[1-9]|[12]\d|3[01]$/
    


      if (dateBegin.match(regxdate) && dateEnd.match(regxdate)) {

        return true
      } else if (!dateBegin.match(regxdate)) {

        span[1].innerHTML = "誤る開始日付を入力している。"
        return false
      } else if (!dateEnd.match(regxdate)) {
        span[2].innerHTML = "誤る終了日付を入力している。"
        return false
      } else {
        return false
      }
    } 
  </script>
 