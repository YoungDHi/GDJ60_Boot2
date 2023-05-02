<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <h1 class="fw-bolder">Member Login Page</h1>
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
                            
                            <c:if test="${not empty param.errorMessage}">
                            	<h1>${param.errorMessage}</h1>
                            </c:if>
                            
                            <form id="contactForm" data-sb-form-api-token="API_TOKEN" action="./login" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                <!-- userName input-->
                                <div class="form-floating mb-3">
                                    <input class="form-control" id="username" name="username" value="${cookie.remember.value}" type="text" placeholder="Enter your userName..." data-sb-validations="required" />
                                    <label for="username">user Name</label>
                                    <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
                                </div>
                                <div class="form-floating mb-3">
                                    <input class="form-control" id="password" name="password" type="password" data-sb-validations="required,email" />
                                    <label for="password">password</label>
                                </div>
                                <!-- password input-->
                                <div class="form-floating mb-3">
                                    <input id="remember" name="remember" value="remember" type="checkbox" data-sb-validations="required,email" />
                                    <label for="remember">ID 기억하기</label>
                                </div>
                               
                               <!-- Submit Button-->
                                <div class="d-grid">
                                	<button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button>
                                </div>
                            </form>
                            <a href="./findPassword">비밀번호 찾기</a>
                            <a href="/oauth2/authorization/kakao">카카오로 로그인</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <!-- Footer 적용 -->
	<c:import url="../temp/footer.jsp"></c:import>
	<!-- Footer 끝 -->
	<script>
		history.replaceState({}, null, location.pathname)
	</script>
</body>
</html>