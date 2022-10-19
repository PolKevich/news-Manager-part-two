<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--! use presentetion with GoToNewsList --%>>
<c:if test="${presentation eq 'newsList' }">  
	<c:import url="/WEB-INF/view/newsList.jsp" />
</c:if>


<c:if test="${presentation eq 'viewNews' }">
	<c:import url="/WEB-INF/view/viewNews.jsp" />
</c:if>