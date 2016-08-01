<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<form:form action="user/register" method="post" commandname="user">
		<table>
			<tr>
				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="id" pattern=".{4,15}" required="true"
						title="id should contain a minimum of 4 characters" /></td>
			</tr>

			<tr>
				<td><form:label path="name">
						<spring:message text="User Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>

			<tr>
				<td><form:label path="password">
						<spring:message text="Password" />
					</form:label></td>
				<td><form:input path="password" pattern=".{6,25}"
						required="true"
						title="password should contain atleast 6 characters" /></td>
			</tr>

			<tr>
				<td><form:label path="mobileno">
						<spring:message text="Mobile no" />
					</form:label></td>
				<td><form:input path="mobileno"
						pattern="[9|8|7][d]{9} required="
						true" title="enter 10 digit mobileno" /></td>
			</tr>

			<tr>
				<td><form:label path="email">
						<spring:message text="Email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td><form:label path="address">
						<spring:message text="Address" />
					</form:label></td>
				<td><form:input path="address" /></td>
			</tr>

			<tr>
				<td><input type="submit"
					value="<spring:message text = "Register"/>" /></td>
				<td><input type="reset"
					value="<spring:message text = "Reset"/>" /></td>
			</tr>





		</table>
	</form:form>
</body>