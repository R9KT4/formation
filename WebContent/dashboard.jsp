<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp" />

<div class="container-fluid">
  <div class="row">
  	<div class="col-md-12">
	<h1 id="homeTitle">456 Computers found</h1>
	</div>
  </div>
	<div class="row" id="actions">
		<div class="col-md-10">
		<form action="" method="GET" class="form-inline" role="form">
			<input type="search" id="searchbox" name="search" class="form-control"
				value="" placeholder="Search name">
			<input type="submit" id="searchsubmit"
				value="Filter by name"
				class="btn btn-primary">
		</form>
		</div>
		<div class="col-md-2">
		<a id="add" href="addComputer.jsp" role="button" class="btn btn-success pull-right">Add Computer</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		<table>
		  <c:forEach items="${computers}" var="computer">
		    <tr>
		      <th><c:out value="${computer.name}" /></th>
		    </tr>
		  </c:forEach>
		</table>


		</div>
		</div>
</div>

<jsp:include page="include/footer.jsp" />
