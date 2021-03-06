<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	textarea{
		resize: none;
		height: 200px;
	}
	

</style>
<script>
	

</script>
<div class="container">
	<form action="/notice/writeGo" method="post" enctype="multipart/form-data">
	<c:choose>
		<c:when test="${one ne null }">
			<input type="hidden" name="MODE" value="MOD">
		</c:when>
		<c:otherwise>
			<input type="hidden" name="MODE" value="ADD">
		</c:otherwise>
	</c:choose>
		
		<div class="row g-3">
			<div class="col-12">
				<label for="title" class="form-label">제목</label>
				 <input type="text" class="form-control" id="ni_title" name="ni_title" value="${one.ni_title }">
			</div>
			<div class="col-12">
				<label for="content" class="form-label">본문</label>
				 <textarea class="form-control" id="ni_content" name="ni_content">${one.ni_content }</textarea>
			</div>
			<div class="col-12">
				<label for="writer" class="form-label">작성자</label>
				 <input type="text" class="form-control" id="ni_writer" name="ni_writer" value="${loginMember.mi_id }" readonly>
			</div>
			<input type="file" name="file">
			<div class="col-12">
				<label for="writer" class="form-label">파일</label>
				<p class="file_List" onclick="doFileDownload('${one.file_name }','${one.saved_file_name }')">${one.file_name }</p>
			</div>
			
			<c:if test="${one ne null }">
				<input type="hidden" name="ni_no" value="${one.ni_no }">
				<div class="col-12">
					<label for="writer" class="form-label">작성일시</label>
				 	<input type="text" class="form-control" id="ni_writer" value="${one.ni_insdate }" readonly>
				</div>
			
			</c:if>
		</div>
		
		<c:choose>
			<c:when test="${loginMember.mi_id eq one.ni_writer}">
					<button class="w-49 btn btn-lg btn-primary" type="submit">수정</button>
					<a href="/notice/delete?ni_no=${one.ni_no }" class="w-49 btn btn-lg btn-primary">삭제</a>
			</c:when>
			<c:otherwise>
				<button class="w-49 btn btn-lg btn-primary" type="submit">글쓰기</button>
			</c:otherwise>
		</c:choose>
	</form>

</div>
<script>
	$(document).ready(function(){
		
	})
	
	function doFileDownload(fileName, savedFileName){	
		console.log(fileName);
		console.log(savedFileName);
		location.href="/notice/fileDownload?file_name=" + encodeURI(fileName) + "&saved_file_name=" + encodeURI(savedFileName);
		
	}
</script>