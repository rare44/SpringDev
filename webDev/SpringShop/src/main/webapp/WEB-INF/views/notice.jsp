<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	a{
		text-decoration: none;
		color: black;
	}
</style>
<div class="container">
<div>
	<select id="searchType">
		<option value="all">전체</option>
		<option value="ni_title">제목</option>
		<option value="ni_content">내용</option>
		<option value="ni_writer">작성자</option>
	</select>
	<input type="text" name="keyword" id="keyword">
	<button class="w-49 btn btn-lg btn-primary" id="doSearch">검색</button>
</div>
<table class="table">
	<thead>
		<tr>
			<th scope="col">번호</th>
			<th scope="col">제목</th>
			<th scope="col">작성자</th>
			<th scope="col">날짜</th>
		</tr>
	</thead>
	<tbody class="noticeList">
	
	</tbody>
</table>
<div id="pageNav"></div>
<c:if test="${loginMember ne null }">																																																																																																										
	<a href="/notice/write" class="w-49 btn btn-lg btn-primary" type="button">글쓰기</a>
</c:if>

</div>
<script>
	$(document).ready(function(){
		search(1);
		$("#doSearch").click(function(){
			search(1);
		})
	});
	
	function goPage(selPage){
		search(selPage);
	}
	
	
	
	function search(selPage){
		var data = {};
		data.pagePerCnt = 10;
		data.curPage = selPage;
		data.keyword = $("#keyword").val();
		data.searchType = $("#searchType").val();
		console.log(data);
		
		 $.ajax({
	    	    type : 'POST',
	    	    url : "/getNoticeList",
	    	    data : data,
	    	    error : function(error) {
	    	        alert("Error!");
	    	    },
	    	    success : function(value) {
					console.log(value);
					var html = "";
					var list ="";
					$(".noticeList").children().remove();
					if(value.list.length > 0){
						
					
		    	    	for (var i = 0; i < value.list.length; i++) {
		    	    		list = value.list[i];
		    	    		html += "<tr><th scope='row'>" + list.ni_no + "</th>";
		    	    		html += "<td><a href='notice/detail?ni_no=" + list.ni_no + "'>" + list.ni_title + "</a></td>";
		    	    		html += "<td>" + list.ni_writer + "</td>";
		    	    		html += "<td>" + list.ni_insdate + "</td></tr>";
						}
					}else{
						html += "<div>검색결과가 없습니다.</div>";
					}
	    	    	console.log(html);
	    	    	$(".noticeList").append(html);
	    	    	$("#pageNav").paging({
	    	    		pageSize : data.pagePerCnt,
	    	    		PAGE_PER_CNT : data.pagePerCnt,
	    	    		currentPage : value.paging.CUR_PAGE,
	    	    		pageTotal : value.paging.TOTAL_CNT
	    	    	});
	    	    	
	    	    	
	    	    },
	 
	    	});
		
	}

	

</script>



