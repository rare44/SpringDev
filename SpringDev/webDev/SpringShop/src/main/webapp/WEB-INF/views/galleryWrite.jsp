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
	<form action="/gallery/writeGo" method="post" enctype="multipart/form-data">
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
				 <input type="text" class="form-control" id="gi_title" name="gi_title" value="${one[0].gi_title }">
			</div>
			<div class="col-12">
				<label for="content" class="form-label">본문</label>
				 <textarea class="form-control" id="gi_content" name="gi_content">${one[0].gi_content }</textarea>
			</div>
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-1 g-3">
					<c:forEach var="img" items="${one }" varStatus="status">
						<span id="img${status.count }">
						<img src="/resources/file/${one[status.count-1].saved_file_name }" 
						width='50%'  alt="${one[status.count-1].file_name }"
						onclick="imgDown('${one[status.count-1].file_name }','${one[status.count-1].saved_file_name }')"
						onmouseover="imgView('${one[status.count-1].file_name}')" oncontextmenu="alert('오른쪽클릭ㄴㄴ')">
						
							<c:choose>
								<c:when test="${loginMember.mi_id eq one[0].gi_writer}">
										<span width='200px' height='130px'>
											<a href="/gallery/deleteImg?saved_file_name=${one[status.count-1].saved_file_name }" class="w-49 btn btn-lg btn-primary">삭제</a>
										</span>
								</c:when>
							</c:choose>
							
						</span>
					</c:forEach>	
			</div>	
			<div class="col-12">
			<c:choose>
				<c:when test="${one ne null }">
					<input type="text" class="form-control" id="file_name_view" value="imgName" width="50px" readonly>
					<label for="writer" class="form-label">작성자</label>
					<input type="text" class="form-control" id="gi_writer" name="gi_writer" value="${one[0].gi_writer }" readonly>
				</c:when>
				<c:otherwise>
					<label for="writer" class="form-label">작성자</label>
					<input type="text" class="form-control" id="gi_writer" name="gi_writer" value="${loginMember.mi_id}" readonly>
				</c:otherwise>
				
			
			</c:choose>
				 
			</div>
			<input type="file" name="files" multiple="multiple">
			
			<div class="col-12">
			<c:if test="${one ne null }">
				<input type="hidden" name="gi_no" value="${one[0].gi_no }">
				<div class="col-12">
					<label for="writer" class="form-label">작성일시</label>
				 	<input type="text" class="form-control" id="gi_writer" value="${one[0].gi_insdate }" readonly>
				</div>
			</c:if>
		</div>
		
		<c:if test="${loginMember ne null }">
		<c:choose>
			<c:when test="${loginMember.mi_id eq one[0].gi_writer}">
					<button class="w-49 btn btn-lg btn-primary" type="submit" id="up">수정</button>
					<a href="/gallery/delete?gi_no=${one[0].gi_no }" class="w-49 btn btn-lg btn-primary">삭제</a>
			</c:when>
			<c:otherwise>
					<button class="w-49 btn btn-lg btn-primary" type="submit" id="up">글쓰기 </button>
			</c:otherwise>
		</c:choose>
		</c:if>
		
	</form>

</div>

<script>
	$(document).ready(function(){
		
		noread();
		
		
	})

	function noread(){
		
		if(!document.getElementById('up')){
			$('#gi_title').attr('readonly', true);
			$('#gi_content').attr('readonly', true);
		}else{
			
		}
	}

	function imgDown(fileName, savedFileName){
		location.href="/notice/fileDownload?file_name=" + encodeURI(fileName) + "&saved_file_name=" + encodeURI(savedFileName);
	}
	function imgView(value){
		var target = document.getElementById('file_name_view');
	    target.setAttribute('value', value);
		
	}

	
</script>
