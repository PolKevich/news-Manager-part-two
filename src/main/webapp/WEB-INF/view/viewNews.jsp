<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="body-title">
	<a href="newsList">news >> </a> view news
</div>

<div class="add-table-margin">
	<table class="news_text_format">
		<tr>
			<td class="space_around_title_text"> news title </td>

			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${news.title}" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text"> news date </td>

			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${news.newsDate}" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text"> news brief </td>
			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${news.brief}" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text"> news content </td>
			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${news.content}" />
				</div></td>
		</tr>
	</table>
</div>


<c:if test="${role eq 'admin'}">

<div class="left">
		<c:url var="editNewsLink" value="editNews">
		 <c:param name="newsId" value="${news.id}" />
			</c:url>
			  <a href="${editNewsLink}">edit </a>
							
</div>
 <br>
<div class="left">
		<c:url var="deleteNewsLink" value="deleteNews">
		 <c:param name="newsId" value="${news.id}" />
			</c:url>
			  <a href="${deleteNewsLink}">delete </a>
			  
</div>
</c:if>
