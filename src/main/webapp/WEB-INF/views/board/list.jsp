<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Modern Business - Start Bootstrap Template</title>
    <!-- css favicon -->
    <c:import url="../temp/style.jsp"></c:import>
    <!-- css favicon -->
</head>
<body>
	<body class="d-flex flex-column h-100">
    <main class="flex-shrink-0">
    	<!-- Navigation-->
    	<c:import url="../temp/header.jsp"></c:import>
    	<!-- Header-->
    	<section class="bg-light py-5">
            <div class="container px-5 my-5">
                <div class="text-center mb-5">
                    <h1 class="fw-bolder">${board} List</h1>
                    <p class="lead fw-normal text-muted mb-0">With our no hassle pricing plans</p>
                    
                    <div>
                    	<table class="table table-hover">
                    		<thead>
                    			<tr>
                    				<th>Num</th>
                    				<th>Title</th>
                    				<th>Writer</th>
                    				<th>Date</th>
                    				<th>Hit</th>
                    			</tr>
                    		</thead>
                    		<tbody>
                    			<c:forEach items="${list}" var="boardVO">
                    				<tr>
                    					<td>${boardVO.num}</td>
                    					<td>
                    					<a href="./detail?num=${boardVO.num}">${boardVO.title}</td>
                    					</a>
                    					<td>${boardVO.writer}</td>
                    					<td>${boardVO.regDate}</td>
                    					<td>${boardVO.hit}</td>
                    				</tr>
                    			</c:forEach>
                    		</tbody>
                    	</table>
                    </div>
                    <!-- paging -->
					<div class="col-2 mx-auto">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item">
					    			<a class="page-link" href="./list?page=1&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
					    			    <span aria-hidden="true">&laquo;</span>
					    			</a>
					    		</li>
								<li class="page-item ${pager.pre? 'disabled':''}">
									<a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
					    		    	<span aria-hidden="true">&lsaquo;</span>
					    			</a>
					    		</li>
					    		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					    			<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					    		</c:forEach>
					    		<li class="page-item ${pager.next? 'disabled' : ''}">
					    			<a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"  aria-label="Next">
					        			<span aria-hidden="true">&rsaquo;</span>
					      			</a>
					    		</li>
					    		<li class="page-item">
					    			<a class="page-link" href="./list?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}"  aria-label="Next">
					        			<span aria-hidden="true">&raquo;</span>
					    			</a>
					    		</li>
					 		</ul>
						</nav>
					</div>
					<!-- 검색 -->
					<div class="col-md-7 mx-auto">
						<form class="row g-3" action="./list" method="GET">
							<div class="col-auto">
								<label for="kind" class="visually-hidden">Kind</label>
								<select class="nice-select" name="kind" id="kind" aria-label="Default select example">
									<option value="title">글제목</option>
									<option value="contents">글내용</option>
									<option value="writer">작성자</option>
								</select>
							</div>
							<div class="col-auto">
								<label for="search" class="visually-hidden">Search</label>
								<input type="text" class="form-control" name="search" id="search" placeholder="검색어를 입력하세요">
							</div>
							<div class="col-auto">
								<button type="submit">검색</button>
							</div>
						</form>
					</div>
                </div>
            </div>
        </section>
        <sec:authorize access="hasRole('ADMIN')">		
        	<a href="./add">WRITE</a>
        </sec:authorize>
    </main>
    <!-- Footer 적용 -->
	<c:import url="../temp/footer.jsp"></c:import>
	<!-- Footer 끝 -->
</body>
</html>