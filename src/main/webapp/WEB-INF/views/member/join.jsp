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
                        <h1 class="fw-bolder">Member Join Page</h1>
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
                            
                            <form:form id="contactForm" data-sb-form-api-token="API_TOKEN" modelAttribute="memberVO" action="./join" method="post">
                                <!-- userName input-->
                                <div class="form-floating mb-3">
                                    <form:input path="username" cssClass="form-control" id="username"/>
                                    <form:label path="username">user Name</form:label>
                                    <form:errors path="username" cssStyle="color:red;"></form:errors>
                                    </div>
                                <!-- password input-->
                                <div class="form-floating mb-3">
                                    <form:password path="password" cssClass="form-control" id="password"/>
                                    <form:label path="password">password</form:label>
                                    <form:errors path="password" cssStyle="color:red;"></form:errors>
                                    </div>
                                <!-- passwordCheck input-->
                                <div class="form-floating mb-3">
                                    <form:password cssClass="form-control" id="passwordCheck" path="passwordCheck"/>
                                    <label for="passwordCheck">passwordCheck</label>
                                    <form:errors path="passwordCheck" cssStyle="color:red;"></form:errors>
                                <!-- name input-->
                                <div class="form-floating mb-3">
                                	<form:input path="name" cssClass="form-control" id="name"/>
                                    <form:label path="name">name</form:label>
                                    <form:errors path="name" cssStyle="color:red;"></form:errors>
                                    </div>
                                <!-- email input-->
                                <div class="form-floating mb-3">
                                	<form:input path="email" cssClass="form-control" id="email"/>
                                    <form:label path="email">Email</form:label>
                                    <form:errors path="email" cssStyle="color:red;"></form:errors>
                                    </div>
                                
                                <!-- birth input-->
                                <div class="form-floating mb-3">
                                	<input class="form-control" id="birth" name="birth" type="date" placeholder="Enter your userName..." data-sb-validations="required" />
                                    <label for="email">Birth</label>
                                    <form:errors path="birth"></form:errors>
                                </div>
                                
                                <input type="hidden" name="roleName" value="ROLE_MEMBER">
                               
                               <!-- Submit Button-->
                                <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button></div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <!-- Footer 적용 -->
	<c:import url="../temp/footer.jsp"></c:import>
	<!-- Footer 끝 -->
    <script src="../js/joinFormCheck.js"></script>
</body>
</html>