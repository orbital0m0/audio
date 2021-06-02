<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUpPage</title>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<style>
p, h1{
	font-family : cursive;
}

div p:first-child{
	margin: 30px;
	font-size: 30px;
}
#classHeader{
	background-color: #528dfa;
	color: white;
}
#classbody{
	background-color: #f6f2f7;

}

#classbody > div:first-child{
	width: 500px;
	border-style: double;
	background:white;
	margin-top: 30px;
	margin-bottom: 30px;

}

form{
	top:10%;
	left:20%;
	margin:10px;
	
}


input{
	margin: 5px;
	float:right;
}

table{
	margin:auto;
	text-align: center;
}


</style>
</head>
<body>

	<div class="container text-center">
		<div class="container" id="classHeader"><p> 로그인 페이지입니다 :) </p></div>
		
		<div class="container" id="classbody">
			<div class="container">
				<form action="signIn" method="POST" id="signin_form">
				
					<table>
						<tr>
							<th>Id : </th>
							<td><input type="text" name="id" id="id" class="unpassed"></td>
						<tr>
							<th>Password : </th>
							<td><input type="password" name="pwd" id="pwd" class="passed"></td>
						</tr>
						<tr id="realarm"> 
							
						</tr>
						
						<tr>
							<th colspan="2"><input type="submit" value="로그인"></th>
						</tr>
					</table>

				</form>		
			</div>
		</div>
		
	</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){

	
	if("${id}" !== ''){
		$('#id').val("${id}");
		
		if("${pwd}" !== ''){
			$('#pwd').val("${pwd}");
		}
		
		$('#realarm').append('<td colspan="2" style="color:red;">아이디 혹은 비밀번호를 다시 확인해주세요</td>');
	}
	
		
});




</script>

</body>
</html>