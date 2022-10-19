<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="body-title">
	<a href="">news >> </a> news list
</div>

<body>
<form:form action="deleteNews" modelAttribute="news" method="GET">

	<c:forEach var="news" items="${news}">

		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}" />
				</div>

				<div class="news-content">
					<c:out value="${news.brief}" />
				</div>
				<div class="news-link-to-wrapper">

					<div class="link-position">
						<c:if test="${role eq 'admin'}">

							<c:url var="editNewsLink" value="editNews">
								<c:param name="newsId" value="${news.id}" />
							</c:url>
							<a href="${editNewsLink}">edit </a>&nbsp;

						</c:if> 

						<c:url var="viewNewsLink" value="viewNews">
							<c:param name="newsId" value="${news.id}" />
						</c:url>
						<a href="${viewNewsLink}">view </a>&nbsp;

						<c:if test="${role eq 'admin'}">
						
							<input type="checkbox" name="newsId" value="${news.id}" />
							
						</c:if>
					</div>
				</div>

			</div>
		</div>

	</c:forEach>
	
	<c:if test="${role eq 'admin'}">
		<br />
		<div align="right">
            	<input type="submit" value="Delete" class="delete" />&nbsp;&nbsp;&nbsp;
		</div>
	</c:if>
</form:form>
	<div class="no-news">
		<c:if test="${news eq null}">
        No news
	</c:if>
	</div>

	<br />
	<div align="center">
		<c:if test="${requestScope.pageCount.size()>1}">
			<c:forEach var="pageNumber" items="${requestScope.pageCount}">
				<a
					href="controller?command=go_to_news_list&pageNumber=${pageNumber}">${pageNumber}&nbsp
				</a>
			</c:forEach>
		</c:if>
	</div>

</body>