<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    	<section class="py-5">
            <div class="container px-5">
                <!-- Contact form-->
                <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
                    <div class="text-center mb-5">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                        <h1 class="fw-bolder">Get in touch</h1>
                        <p class="lead fw-normal text-muted mb-0">We'd love to hear from you</p>
                    </div>
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <!-- * * * * * * * * * * * * * * *-->
                            <!-- * * SB Forms Contact Form * *-->
                            <!-- * * * * * * * * * * * * * * *-->
                            <!-- This form is pre-integrated with SB Forms.-->
                            <!-- To make this form functional, sign up at-->
                            <!-- https://startbootstrap.com/solution/contact-forms-->
                            <!-- to get an API token!-->
                            <form:form id="contactForm" data-sb-form-api-token="API_TOKEN" modelAttribute="boardVO" action="./add" method="post" enctype="multipart/form-data">
                                <!-- title input-->
                                <div class="form-floating mb-3">
                                    <form:input path="title" id="title" cssClass="form-control"/>
                                    <label for="title">Title</label>
                                	<form:errors path="title"></form:errors>   
                                </div>
                                <!-- writer input-->
                                <div class="form-floating mb-3">
                                    <form:input path="writer" id="writer" cssClass="form-control"/>
                                    <label for="writer">Writer</label>
                                    <form:errors path="writer"></form:errors>
                                </div>
                                
                                <div class="form-floating mb-3">
                                    <form:input path="names" id="writer" cssClass="form-control"/>
                                    <label for="writer">names</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <form:input path="names" id="writer" cssClass="form-control"/>
                                    <label for="writer">names</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <form:input path="names" id="writer" cssClass="form-control"/>
                                    <label for="writer">names</label>
                                </div>
                                
                                <div class="form-floating mb-3">
                                    <form:input path="boardFileVOs[0].fileName" id="writer" cssClass="form-control"/>
                                    <label for="writer">boardFileName</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <form:input path="boardFileVOs[1].fileName" id="writer" cssClass="form-control"/>
                                    <label for="writer">boardFileName</label>
                                </div>
                                
                                <div class="form-floating mb-3">
                                    <form:input path="subVO.subName" id="writer" cssClass="form-control"/>
                                    <label for="writer">SubName</label>
                                </div>
                               
                                <!-- Message input-->
                                <div class="form-floating mb-3">
                                    <textarea class="form-control" id="contents" name="contents" type="text" placeholder="Enter your message here..." style="height: 10rem" data-sb-validations="required"></textarea>
                                    <label for="contents">Contents</label>
                                    <div class="invalid-feedback" data-sb-feedback="message:required">A message is required.</div>
                                </div>
								<!-- 청부 파일 -->
                                <div id="fileAdd">
									<input type="file" name="boardFiles">
                                </div>
								<div class="form-floating mb-3">
									<button type="button" id="fileAddBtn">첨부파일 추가</button>
								</div>
                                <!-- Submit Button-->
                                <div class="d-grid">
                                <button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                <!-- Contact cards-->
                <div class="row gx-5 row-cols-2 row-cols-lg-4 py-5">
                    <div class="col">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-chat-dots"></i></div>
                        <div class="h5 mb-2">Chat with us</div>
                        <p class="text-muted mb-0">Chat live with one of our support specialists.</p>
                    </div>
                    <div class="col">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-people"></i></div>
                        <div class="h5">Ask the community</div>
                        <p class="text-muted mb-0">Explore our community forums and communicate with other users.</p>
                    </div>
                    <div class="col">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-question-circle"></i></div>
                        <div class="h5">Support center</div>
                        <p class="text-muted mb-0">Browse FAQ's and support articles to find solutions.</p>
                    </div>
                    <div class="col">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-telephone"></i></div>
                        <div class="h5">Call us</div>
                        <p class="text-muted mb-0">Call us during normal business hours at (555) 892-9403.</p>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <!-- Footer 적용 -->
	<c:import url="../temp/footer.jsp"></c:import>
	<!-- Footer 끝 -->
	<!-- <script type="text/javascript" src="../js/boardform.js"></script> -->
    <script src="../js/fileManager.js"></script>
</body>
</html>