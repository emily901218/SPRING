<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>자유게시판 답글달기</title>
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
					location.href="fboardList?page=${page}&searchTitle=${searchTitle}&searchWord=${searchWord}";
				}
			}//cancelBtn
		</script>
	</head>
	<body>
		<h2>자유게시판 답글달기</h2>
	 	<form action="fboardReply" method="post" name="fboardFrm" enctype="multipart/form-data"><!-- 파일첨부 할때 필요 -->
		 	<input type="hidden" name ="bgroup" value="${boardVo.bgroup}">
		 	<input type="hidden" name ="id" value="${boardVo.id}">
		 	<input type="hidden" name ="bstep" value="${boardVo.bstep}">
		 	<input type="hidden" name ="bindent" value="${boardVo.bindent}">
		 	<input type="hidden" name="page" id="${page}" >
			<input type="hidden" name="searchWord" id="${searchWord}" >
			<input type="hidden" name="searchTitle" id="${searchWord}" >
			<table>
				<colgroup>
					<col width="30%">
					<col width="70%">
				</colgroup>
				<tr>
					<th>제목</th>
					<th><input type="text" name="btitle" id="btitle" value="[답글]${boardVo.btitle }"></th>
				</tr>
				<tr>
					<th>작성자</th>
					<th>${boardVo.id }</th>
				</tr>
				<tr id="content">
					<td >내용</td>
					<td><textarea rows="20" cols="80" name="bcontent" id="bcontent">
					
					
					
					
---------------------------------------------
[답글]
${boardVo.bcontent }</textarea></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td><input type="file" name="file" id="bfile"></td>
				</tr>
				
			</table>
			<div>
				<button type="button" onclick="fboardBtn()">답글달기</button>
				<button type="button" onclick="cancleBtn()">취소</button>
			</div>
	 	</form>
	</body>
</html>