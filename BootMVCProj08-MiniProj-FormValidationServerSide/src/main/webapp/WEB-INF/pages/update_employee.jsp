<%@ page isELIgnored="false" %>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>


<h1 style="text-align: center; color: brown">Update an employee</h1>
<%-- for this type of form method is post and action is same url and request made --%>
<frm:form modelAttribute="emp">
    <table border="1" bgcolor="#ffebcd">

        <tr>
            <td>Employee id : </td>
            <td><frm:input path="empno" readonly="true"/></td>
        </tr>

        <tr>
            <td>Employee name : </td>
            <td><frm:input path="ename"/></td>
        </tr>

        <tr>
            <td>Employee designation : </td>
            <td><frm:input path="job"/></td>
        </tr>

        <tr>
            <td>Employee salary : </td>
            <td><frm:input path="sal"/></td>
        </tr>

        <tr>
            <td>Employee department no :</td>
            <td><frm:input path="deptno"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Update Employee"></td>
            <td><input type="reset" value="cancel"></td>
        </tr>

    </table>


</frm:form>