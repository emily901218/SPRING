<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>자유게시판 수정</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style type="text/css">
			table, th, td{border:1px solid black; border-collapse: collapse;}
			h2{text-align: center;}
			table{width:920px; margin:0 auto; text-align: center;}
			th,td{ height:40px;}
			td{text-align: left; padding-left:30px; }
			input{width:575px; height:30px}
			div{width:400px; height:60px; margin:12px auto;}
			button {display: inline-block; width:120px; height:40px;}
			#content{height:300px;}
			img{width:200px;}
		</style>
		<script type="text/javascript">
		
			function cancelBtn(){
				if(confirm("수정을 취소하시겠습니까?")) location.href="fboardList?page=${page}&searchTitle=${searchTitle}&searchWord=${searchWord}";
			}
			function fboardBtn(){
				if($("#btitle").val().length<2){
					alert("제목은 2글자 이상이어야 수정이 가능합니다.");
					$("#btitle").focus();
					return;
				}
				fboardFrm.submit();
			}
		
		</script>
	</head>
	<body>
		<h2>자유게시판 수정</h2>
<!-- 		enctype="multipart/form-data" 이게 없으면 파일첨부가 되지 않음 -->
	 	<form action="fboardUpdate" method="post" name="fboardFrm" enctype="multipart/form-data"> 
			<table>
				<colgroup>
					<col width="30%">
					<col width="70%">
				</colgroup>
				<input type="hidden" name="bno" value="${boardVo.bno }">
				<input type="hidden" name="bfile" value="${boardVo.bfile}">
				<input type="hidden" name="page" value="${page}">
				<input type="hidden" name="searchTitle" value="${searchTitle}">
				<input type="hidden" name="searchWord" value="${searchWord}">
				
				<tr>
					<th>제목</th>
					<td><input type="text" name="btitle" id="btitle" value="${boardVo.btitle }" ></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${boardVo.id }</td>
				</tr>
				<tr id="content">
					<td >내용</td>
					<td><textarea rows="20" cols="80" name="bcontent" id="bcontent">${boardVo.bcontent }</textarea></td>
				</tr>
				<tr>
					<td>기존첨부파일</td>
					<td>${boardVo.bfile}</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><img src="/upload/${boardVo.bfile }"></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td><input type="file" name="file" id="bfile"></td>
				</tr>
			</table>
			<div>

				<button type="button" onclick="fboardBtn()">수정</button>
				<button type="button" onclick="cancelBtn()">취소</button>

			</div>
	 	</form>
	</body>
</html>