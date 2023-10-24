
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<c:choose>
    <c:when test="${!empty empList}">
        <h1 style="color: brown; text-align: center">Employees Report</h1>
        <table border="1" align="center" bgcolor="#ffebcd">
            <tr style="color: brown">
                <th>empno</th>
                <th>emp name</th>
                <th>Job</th>
                <th>Salary</th>
                <th>Dept no</th>
            </tr>
            <c:forEach var="emp" items="${empList}">
                <tr style="color:black">
                    <td>${emp.empno}</td>
                    <td>${emp.ename}</td>
                    <td>${emp.job}</td>
                    <td>${emp.sal}</td>
                    <td>${emp.deptno}</td>
                    <td><a href="emp_edit?no=${emp.empno}"><img src="images/edit.jpg" width="30px" height="30px"/></a></td>
                    <td><a href="emp_delete?no=${emp.empno}" onclick="return confirm('Do you want to delete the employee?')"><img src="images/delete.png" width="30px" height="30px"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h1 style="color: red">Employees not found.</h1>
    </c:otherwise>
</c:choose>
<br><br>
<center>
    <a href="add_emp"><img src="images/add_emp.jpg" width="50px" height="50px"/> Add Employee</a> &nbsp;
    <a href="/Employee-CURDOperation"><img src="images/home.png" width="50px" height="50px" /> Home</a>

</center>

<h2 style="color: darkgreen; text-align: center">${resultMsg}</h2>

<h2 style="color: darkgreen; text-align: center">${updateMsg}</h2>

<h2 style="color: red; text-align: center">${deleteMsg}</h2>


