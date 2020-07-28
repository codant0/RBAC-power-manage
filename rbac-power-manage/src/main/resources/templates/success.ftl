<#--
  Created by 黄杰峰.
  User: Ant
  Date: 2020/7/27 0027
  Time: 16:06
-->
<!DOCTYPE html>
<html lang="en"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<head>
    <meta charset="UTF-8">
    <title>success</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h3>Welcome!</h3>
<span sec:authorize="hasAuthority('menu1')">
    <button id="menu1Btn" type="button" onclick="sendAjax('/menu1')">菜单1</button>
</span>

<span sec:authorize="hasAuthority('menu2')">
    <button id="menu2Btn" type="button" onclick="sendAjax('/menu2')">菜单2</button>
</span>

<span sec:authorize="hasAuthority('menu3')">
    <button id="menu3Btn" type="button" onclick="sendAjax('/menu3')">菜单3</button>
</span>

<script type="text/javascript">

    function sendAjax(url) {
        $.ajax({
            type: "GET",
            url: url,
            dataType: "text",
            success: function (data) {
                console.log(data);
            }
        });
    }
</script>
</body>
</html>