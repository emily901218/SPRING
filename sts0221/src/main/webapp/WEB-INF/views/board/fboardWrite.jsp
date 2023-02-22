<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>자유게시판 글쓰기</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style type="text/css">
			table, th, td{border:1px solid black; border-collapse: collapse;}
			h2{text-align: center;}
			table{width:920px; margin:0 auto; text-align: center;}
			th,td{ height:40px;}
			td{text-align: left; padding-left:30px; }
			input{width:575px; height:30px}
			div{width:400px; height:60px; margin:12px auto 0;}
			button {display: inline-block; width:120px; height:40px;}
			#content{height:300px;}
		</style>
		<script type="text/javascript">
			function fboardBtn(){
				if($("#btitle").val().length<2){
					alert("제목을 두글자 이상 입력하셔야 합니다.");
					$("#btitle").focus();
					return ;
				}
				if(confirm("글쓰기를 저장하시겠습니까?")){
					 return fboardFrm.submit();
					
				}
				
			}//fboardBtn
			
			function cancleBtn(){
				if(confirm("글쓰기를 취소하시겠습니까?")){
					location.href="/";
				}
			}//cancelBtn
		</script>
	</head>
	<body>
		<h2>자유게시판 글쓰기</h2>
	 	<form action="fboardWrite" method="post" name="fboardFrm" enctype="multipart/form-data"><!-- 파일첨부 할때 필요 --><!--/는 root directory에서 ~ /안붙이면 현재폴더에서 주소를 덧붙여줘 ./와 같아   ../상위폴더에서 찾아라-->
			<table>
				<colgroup>
					<col width="30%">
					<col width="70%">
				</colgroup>
				<script>
					console.log("log page : "+${param.page});
				</script>
				<tr>
					<th>제목</th>
					<th><input type="text" name="btitle" id="btitle" ></th>
				</tr>
				<tr>
					<th>작성자</th>
					<th><input type="text" name="id" id="id" ></th>
				</tr>
<!-- 				<tr> -->
<!-- 					<th>날짜</th> -->
<!-- 					<th><input type="text" name="bdate" id="bdate" ></th> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<th>조회수</th> -->
<!-- 					<th><input type="text" name="bhit" id="bhit" ></th> -->
<!-- 				</tr> -->
				<tr id="content">
					<td >내용</td>
					<td><textarea rows="20" cols="80" name="bcontent" id="bcontent"></textarea></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td><input type="file" name="file" id="bfile"></td>
				</tr>
				
			</table>
			<div>
				<button type="button" onclick="fboardBtn()">글쓰기</button>
				<button type="button" onclick="cancleBtn()">취소</button>
			</div>
	 	</form>
	</body>
</html>