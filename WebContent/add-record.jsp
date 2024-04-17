<%@ include file="navbar.jsp" %>
<%@ include file="conn.jsp" %>
<html>
 <body  onload="makeActive('add')">
  <div class='dv'>
    <%
    PreparedStatement ps=cn.prepareStatement("insert into employeeinfo values(?,?,?,?,?,?)");
    ps.setString(1,request.getParameter("eid"));
    ps.setString(2,request.getParameter("firstname"));
    ps.setString(3,request.getParameter("lastname"));
    ps.setString(4,request.getParameter("phone"));
    ps.setString(5,request.getParameter("department"));
    ps.setString(6,request.getParameter("salary"));
    ps.executeUpdate();
    %>
  	<label class='lamsg' style='color:green'>Employee has been added successfully</label>
  </div>
 </body>
</html>