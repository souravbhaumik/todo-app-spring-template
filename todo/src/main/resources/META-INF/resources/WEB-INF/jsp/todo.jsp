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
            Please enter TODO details below:
            <form method="post">
                Description: <input type="text" name="description">

                <br>
                <input class="btn btn-success" type="submit">
            </form>

            <br>
            <a href="http://localhost:8090/">Home</a>
        </div>
        <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>

    </html>