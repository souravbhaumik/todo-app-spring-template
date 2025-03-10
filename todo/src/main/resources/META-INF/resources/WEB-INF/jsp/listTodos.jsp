<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1> Welcome to the application, ${name}.</h1>
            <hr>
            <br><br>
            <h1>Your Todos are</h1>
            <c:choose>
                <c:when test="${not empty todos}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>Description</th>
                                <th>Target Date</th>
                                <th>Done?</th>
                                <th>Delete</th>
                                <th>Edit</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${todos}" var="todo">
                                <tr>
                                    <td>${todo.id}</td>
                                    <td>${todo.description}</td>
                                    <td>${todo.date}</td>
                                    <td>${todo.done}</td>
                                    <td>
                                        <a href="delete-todo?id=${todo.id}" class="fa fa-trash">
                                        </a>
                                    </td>
                                    <td>
                                        <a href="update-todo?id=${todo.id}" class="fa fa-edit" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <p>You don't have any todos.</p>
                </c:otherwise>
            </c:choose>
            <br>
            <a href="add-todo">
                <button type="button" style="color: green;" class="btn btn-outline-success">
                    <span class="glyphicon glyphicon-plus"></span>
                    <span style="font-family: Arial, Helvetica, sans-serif;">Add Todo</span>
                </button>
            </a>
            <br>
            <a href="http://localhost:8090/">
                <button type="button" class="btn btn-warning btn-sm mt-3">Home</button>
            </a>
        </div>
        <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js" />
        <script src="/webjars/jquery/3.6.0/jquery.min.js" />
        <script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js" />
        </body>

        </html>