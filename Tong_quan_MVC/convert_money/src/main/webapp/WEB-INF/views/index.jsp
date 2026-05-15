<%--
  Created by IntelliJ IDEA.
  User: ntlong
  Date: 15/05/2026
  Time: 09:02 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Currency Converter Form</title>
</head>
<body>
<form action="/result" method="post">
  <label>Chọn loại chuyển đổi:</label>
  <select name="type">
    <option value="usdToVnd">USD sang VND</option>
    <option value="vndToUsd">VND sang USD</option>
  </select>
  <br><br>

  <input type="number" step="any" name="rate" placeholder="Nhập tỉ giá" required>
  <input type="number" step="any" name="amount" placeholder="Nhập số tiền" required>

  <button type="submit">Chuyển đổi ngay</button>
</form>
</body>
</html>
