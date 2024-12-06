<%-- 
    Document   : errorPage
    Created on : 4 déc. 2024, 21:02:38
    Author     : HP
--%>
<!-- Message de succès -->
            <c:if test="${not empty param.successMessage}">
                <div class="alert alert-success d-flex justify-content-between" role="alert">
                    <%--<%= request.getParameter("successMessage") %>--%>
                    ${param.successMessage}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
