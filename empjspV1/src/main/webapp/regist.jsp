<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<link rel="stylesheet" type="text/css" href="css/style.css" />
	    <script src="script/script.js"></script>
	
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p id=nowtime>
								2009/11/20
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1 style="margin:5px;">
						注册 
					</h1>
					<h3 style="color: red; margin: 5px:">${param.msg}</h3>
					<form action="${pageContext.request.contextPath}/user/register" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									ユーザー名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username"  />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									名前:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="realname"  />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri"  name="gender" value="1"/>
									女
									<input type="radio" class="inputgri" name="gender"  value="0" checked="checked"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									検証:
									<img id="num" src="${pageContext.request.contextPath}/user/generateImageCode">
								</td>
								<td valign="middle" align="left">
									<input type="text" name="code" class="inputgri" />
								</td>
								<td>
									
									<a href="javascript:;" onclick="document.getElementById('num').src=
									'${pageContext.request.contextPath}/user/generateImageCode?'+(new Date()).getTime()">换一张</a>
									
								</td>
							</tr>
						</table>
						<p>
							<input type="submit"  class="button" value="提出 &raquo;" />
						</p>
					</form>
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