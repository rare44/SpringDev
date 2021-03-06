<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
a {
	text-decoration: none;
	color: black;
}

#pageNav {
	font-size: 50px;
}
</style>
<main class="container">
		<section class="py-5 text-center container">
			<div class="row py-lg-5">
				<div class="col-lg-6 col-md-8 mx-auto">
					<h1 class="fw-light">Album example</h1>
					<p class="lead text-muted">Something short and leading about
						the collection below—its contents, the creator, etc. Make it short
						and sweet, but not too short so folks don’t simply skip over it
						entirely.</p>
					<p>
						<a href="#" class="btn btn-primary my-2">Main call to action</a> <a
							href="#" class="btn btn-secondary my-2">Secondary action</a>
					</p>
				</div>
			</div>
		</section>

		<div class="album py-5 bg-light">
			<div class="container">
				<select id="searchType">
					<option value="all">전체</option>
					<option value="gi_title">제목</option>
					<option value="gi_content">내용</option>
					<option value="gi_writer">작성자</option>
				</select> <input type="text" name="keyword" id="keyword">
				<button class="w-49 btn btn-lg btn-primary" id="doSearch">검색</button>
				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3" id="list">
					
				</div>
			</div>
		</div>
	<div id="pageNav" class='btn btn-sm btn-outline-secondary' style=''>pageNav</div>
<c:choose>
	<c:when test="${loginMember.mi_id ne null}">
		<a href="/gallery/writeGallery" class="btn btn-primary my-2"
			type="button">글쓰기</a>
	</c:when>
</c:choose>
</main>

<script>
	$(document).ready(function(){
		search(1);
		$("#doSearch").click(function() {
			search(1);
		})
	})

	function goPage(selPage) {
		search(selPage);
	}

	function search(selPage) {
		var data = {};
		data.pagePerCnt = 9;
		data.curPage = selPage;
		data.keyword = $("#keyword").val();
		data.searchType = $("#searchType").val();
		console.log(data);
		
		$
				.ajax({
					type : 'POST',
					url : "/getGalleryList",
					data : data,
					error : function(error) {
						alert('Error!');
					},
					success : function(value) {
						console.log(value);
						var html = "";
						var list = "";

						$('#list').children().remove();
						if (value.list.length > 0) {
							for (var i = 0; i < value.list.length; i++) {
								list = value.list[i];
								html += "<div class='col'>";
								html += "<img src='/resources/file/"+list.saved_file_name+"' class='bd-placeholder-img card-img-top' width='100%' height='180' alt='Thumbnail'>";
								html += "<div class='card-body'>";
								html += "<p class='card-text'><a href='/gallery/writeGallery?gi_no=" + list.gi_no + "'>"+ list.gi_title + "</a></p>";
								html += "<div class='d-flex justify-content-between align-items-center'>";
								html += "<div class='btn-group'>";
							//	html += "<button type='button' class='btn btn-sm btn-outline-secondary'><a href='/gallery/writeGallery?gi_no=" + list.gi_no + "''>수정</a></button>";
							//	html += "<button type='button' class='btn btn-sm btn-outline-secondary'><a href='/gallery/delete?gi_no=" + list.gi_no + "'>삭제</a></button>";
								html += "</div>";
								html += "<small class='text-muted'>" + list.gi_writer + "</small>";
								html += "</div>";
								html += "</div>";
								html += "</div>";
								html += "</div>";
							}
						} else {
							html += "<div>검색결과가 없습니다</div>";
						}
						console.log(html);
						$("#list").append(html);
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