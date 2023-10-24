

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ page isELIgnored="false" %>

<div>
    <b style="text-align: center">Student Registration</b>
</div>
<div style="text-align: center">

    <frm:form action="register" method="post" modelAttribute="stud" >
        <table>

            <tr>
                <td>Student id : </td>
                <td><frm:input path="id"/></td>
            </tr>

            <tr>
                <td>Student name : </td>
                <td><frm:input path="name"/></td>
            </tr>

            <tr>
                <td>Student address : </td>
                <td><frm:input path="address"/></td>
            </tr>

            <tr>
                <td>Student average : </td>
                <td><frm:input path="average"/></td>
            </tr>

            <tr>
                <td><input type="submit" value="Register" /></td>
                <td><input type="reset" value="cancel" /></td>
            </tr>

        </table>
    </frm:form>

</div>