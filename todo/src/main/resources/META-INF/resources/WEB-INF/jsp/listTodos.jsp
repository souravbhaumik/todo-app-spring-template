<%@ taglib prefix="c" uri="jakarta.tags.core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
        <title>Document</title>
    </head>

    <body>
        <div class="container">
            Welcome to the application, ${name}.
            <hr>
            <br><br>
            <h1>Your Todos are</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Done?</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.description}</td>
                            <td>${todo.date}</td>
                            <td>${todo.done}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <button type="button" class="btn btn-link"><a href="add-todo">Add Todo</a></button>
            <br>
            <a href="http://localhost:8090/">Home</a>
        </div>
        <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>

    </html>