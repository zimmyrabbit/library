<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="container" style="margin-top : 30px;">
<div class="row container-board-padding" style="display: flex; justify-content: center;">
<div class="col-sm-12 col-md-12 col-lg-12  col-xl-9 table-responsive wow fadeIn row "> 

<form action="/bookReview/reviewWrite" method="post">
		
		<div style="font-size: 1.5em; margin : 40px 0px;">
			제목 : ${map.title}
		</div>
		
		<table style="margin : 40px 0px;">
			<tr>
			<td width="130px;"><img src="${map.bookImg }" style="height:173px;"/></td>
			<td>${map.bookIntro }<td>
			</tr>
		</table>
		
		<div style="text-align: center;">
		<textarea rows="10" cols="80" id="bookRev" name="bookRev" class="form-input form-control-has-validation form-control-last-child"></textarea>
		</div>
		
		<input type="hidden" value="${map.isbn }" id="isbn" name="isbn" />
		<input type="hidden" value="${map.bookUrl }" id="bookUrl" name="bookUrl" />
		<input type="hidden" value="${map.bookImg }" id="bookImg" name="bookImg" />
		
		<input type="submit" id="subBtn" value="쓰기" class="button button-primary button-winona" style="margin-bottom: 40px;"/>
</form>


</div>
</div>
</div>
		
		
		
<script>

</script>		

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>