<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

			 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/resources/validation.js"></script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/newsStyle.css"/>" />

</head>
<body>
	<div class="page">
	
		<div class="header">
							
				    <c:import url="/WEB-INF/view/header.jsp" />
		</div>
		
		<div class="base-layout-wrapper">
					<div class="menu">

				<c:if test="${user eq 'notActive'}">
				    Welcome!
					
				</c:if>
				
				<c:if test="${user eq 'active'}">
					<c:import url="/WEB-INF/view/menu.jsp" />
					
				</c:if>
			</div>
			
				<div class="content">

				<c:if test="${user eq 'notActive'}">
					<c:import url="/WEB-INF/view/guestInfo.jsp" />
					
				</c:if>
				
				<c:if test="${user eq 'active'}">
					<c:import url="/WEB-INF/view/body.jsp" />
					
				</c:if>
				
				<c:if test="${news eq 'addNews'}">
					<c:import url="/WEB-INF/view/addNews.jsp" />
					
				</c:if>
				
				
				
				<c:if test="${editnews eq 'active'}">
					<c:import url="/WEB-INF/view/editNews.jsp" />
							
				</c:if>
				
				
				<c:if test="${news eq 'error'}">
					<c:import url="/WEB-INF/view/error.jsp" />
					
				</c:if>
               
		             <c:if test="${user eq 'registration'}">
				     <c:import url="/WEB-INF/view/registration.jsp" />
				    
				     </c:if> <br />
				   						     	
			</div>
			</div>
			

		<div class="footer">

			<c:import url="/WEB-INF/view/footer.jsp" />
		</div>
		</div>

</body>
</html>