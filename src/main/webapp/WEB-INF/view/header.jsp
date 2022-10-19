<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="wrapper">
	<div class="newstitle">News Manager</div>

	<div class="local-link">

		<div align="right">

			<a href=>en</a> &nbsp;&nbsp; 
			<a href=>ru</a> <br /> <br />

		</div>
		<c:if test="${user eq 'notActive'}">
			<div align="right">

				<input type="button" value="sign in"
					onclick="window.location.href='signIn'; return false;"
					class="add-button" />

			</div>

		</c:if>


		<c:if test="${user eq 'active'}">

			<div align="right">

				<input type="button" value="sign out"
					onclick="window.location.href='signOut'; return false;"
					class="add-button" />
			</div>

		</c:if>
	</div>

</div>
