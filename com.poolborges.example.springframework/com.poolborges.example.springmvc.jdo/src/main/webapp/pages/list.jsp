<%@ page import="java.util.List" %>
<%@ page import="com.mkyong.model.Customer" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<html>
<body>
	<h1>GAE + Spring 3 MVC REST + CRUD Example with JDO</h1>

	Function : <a href="add">Add Customer</a>
	<hr />

	<h2>All Customers</h2>
	<table border="1">
		<thead>
			<tr>
				<td>Name</td>
				<td>Email</td>
				<td>Created Date</td>
				<td>Action</td>
			</tr>
		</thead>
		
		<%
			
			if(request.getAttribute("customerList")!=null){
				
				List<Customer> customers = (List<Customer>)request.getAttribute("customerList");
				
				if(!customers.isEmpty()){
					 for(Customer c : customers){
						 
		%>
					<tr>
					  <td><%=c.getName() %></td>
					  <td><%=c.getEmail() %></td>
					  <td><%=c.getDate() %></td>
					  <td><a href="update/<%=c.getName()%>">Update</a> 
		                   | <a href="delete/<%=KeyFactory.keyToString(c.getKey()) %>">Delete</a></td>
					</tr>
		<%	
			
					}
		    
				}
			
		   	}
		%>
         
        </tr>
     
	</table>

</body>
</html>