<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1>Welcome to the Login page.</h1>
            <br><br>
            <pre style="color: red;">${errorMessage}</pre>
            <br><br>
            <form method="POST">
                Name: <input type="text" name="name">
                Password: <input type="password" name="password">
                <input type="submit">
            </form>
            <br>
            <a href="http://localhost:8090/">
                <button type="button" class="btn btn-warning btn-sm mt-3">Home</button>
            </a>

            <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
            <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
        </div>
        <%@ include file="common/footer.jspf" %>