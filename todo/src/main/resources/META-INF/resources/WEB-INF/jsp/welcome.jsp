<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1>Welcome, ${name}.</h1>
            <hr>
            <br>
            <h2><a href="list-todos">Manage</a> your todos</h2>
            <a href="http://localhost:8090/">
                <button type="button" class="btn btn-warning btn-sm mt-3">Home</button>
            </a>
        </div>
        <%@ include file="common/footer.jspf" %>