<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20/12/2022
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<main>
    <div class="container">
        <section>
            <h1>Alta</h1>
            <!--  JSP -->
            <form method="post"
                  action="<%=request.getContextPath()%>/CreateController">
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">id_persona</label>
                    <input name="id_persona"  type="number" class="form-control" id="exampleFormControlInput1" placeholder="id_persona">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Nombre</label>
                    <input name="Nombre" type="text" class="form-control" placeholder= "Nombre" id="exampleFormControlTextarea1" maxlength="50">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Apellido</label>
                    <input name="Apellido" type="text" class="form-control" id="exampleFormControlTextarea1" placeholder= "Apellido" maxlength="50">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Edad</label>
                    <input name="Edad" type="number" class="form-control" id="exampleFormControlTextarea1" maxlength="7">
                </div>
                <button class="btn btn-primary">
                    Dar de alta
                </button>
            </form>
        </section>
    </div>
</main>
</body>
</html>
