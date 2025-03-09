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
        Welcome to the Login page.
        <br><br>
        <pre style="color: red;">${errorMessage}</pre>
        <br><br>
        <form method="POST">
            Name: <input type="text" name="name">
            Password: <input type="password" name="password">
            <input type="submit">
        </form>
        <br>
        <a href="http://localhost:8090/">Home</a>

        <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    </div>

</body>

</html>