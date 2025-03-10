<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h2> Please enter TODO details below:</h2>
            <form:form method="post" modelAttribute="todo">
                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input path="Description" type="text" required="true" />
                    <form:errors path="Description" cssClass="text-warning" />
                </fieldset>
                <fieldset class="mb-3">
                    <form:label path="date">Target Date</form:label>
                    <form:input path="date" type="text" required="true" />
                    <form:errors path="date" cssClass="text-warning" />
                </fieldset>
                <form:input type="hidden" path="id" />
                <form:input type="hidden" path="done" />
                <br>
                <input class="btn btn-success" type="submit">
            </form:form>

            <br>
            <a href="http://localhost:8090/">
                <button type="button" class="btn btn-warning btn-sm mt-3">Home</button>
            </a>
        </div>
        <%@ include file="common/footer.jspf" %>
            <script type="text/javascript">
                $('#date').datepicker({
                    format: 'yyyy-mm-dd'
                });