<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../fragments/header.jsp"/>

<style>
    .album {
        min-width: 75%;
    }

    .spacing {
        width: 100%;
        padding-top: 50px;
        overflow: auto;
    }
</style>

<div class="spacing">
<div class="container">
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <c:forEach items="${items}" var="item">
            <div class="col">
                <div class="card shadow-sm">
                    <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                         xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                         preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                        <rect width="100%" height="100%" fill="#55595c"/>
                        <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                    </svg>

                    <div class="card-body">
                        <h3>${item.title} • ${item.price} zł</h3>
                        <p class="card-text">${item.brand.name} • Rok produkcji: ${item.year_of_production}</p>
                        <p class="card-text">Przebieg: ${item.mileage} km</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <a href="<c:url value="/advertising/details/${item.id}"/>"
                                   class="btn btn-sm btn-outline-secondary">Szczegóły</a>
                                <a href="<c:url value="/advertising/update/${item.id}"/>"
                                   class="btn btn-sm btn-outline-secondary">Edytuj</a>
                                <a href="<c:url value="/advertising/remove/${item.id}"/>"
                                   class="btn btn-sm btn-outline-secondary">Usuń</a>
                            </div>
                                <%--                                <small class="text-muted">9 mins</small>--%>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</div>

<jsp:include page="../fragments/footer.jsp"/>