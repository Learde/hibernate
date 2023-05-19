<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients</title>
</head>
<body>
<h1>Clients</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <% for (Client client : clients) { %>
    <tr>
        <td><%= client.getId() %></td>
        <td><%= client.getName() %></td>
        <td><%= client.getPhone() %></td>
        <td><%= client.getEmail() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
