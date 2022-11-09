<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<style>
    .spacing {
        width: 100%;
        padding-top: 50px;
    }
</style>

<body class="bg-light">
<div class="spacing">
    <div class="container">
        <div class="row g-5">
            <div class="col-md-7 col-lg-8">
                <h4 class="mb-3">Dane ogłoszenia</h4>
                <form:form method="post" modelAttribute="advertising">
                <form:hidden path="id"/>
                <div class="row g-3">
                    <div class="col-sm-12">
                        <form:label cssClass="form-label" path="title">Tytuł ogłoszenia</form:label>
                        <form:input cssClass="form-control" path="title"/>
                        <form:errors path="title" cssStyle="color: red"/>
                    </div>

                    <div class="col-12">
                        <form:label cssClass="form-label" path="description">Opis ogłoszenia</form:label>
                        <form:textarea cssClass="form-control" path="description"/>
                        <form:errors path="description" cssStyle="color: red"/>

                    </div>

                    <div class="col-6">
                        <form:label cssClass="form-label" path="mileage">Przebieg pojazdu <span
                                class="text-muted">(km)</span></form:label>
                        <form:input cssClass="form-control" path="mileage"/>
                        <form:errors path="mileage" cssStyle="color: red"/>
                    </div>

                    <div class="col-6">
                        <form:label cssClass="form-label" path="price">Cena <span
                                class="text-muted">(zł)</span></form:label>
                        <form:input cssClass="form-control" path="price"/>
                        <form:errors path="price" cssStyle="color: red"/>
                    </div>

                    <div class="col-6">
                        <form:label cssClass="form-label" path="year_of_production">Rok produkcji pojazdu</form:label>
                        <form:input cssClass="form-control" path="year_of_production"/>
                        <form:errors path="year_of_production" cssStyle="color: red"/>
                    </div>

                    <div class="col-6">
                        <form:label cssClass="form-label" path="phone_number">Nr telefonu właściciela</form:label>
                        <form:input cssClass="form-control" path="phone_number"/>
                        <form:errors path="phone_number" cssStyle="color: red"/>
                    </div>

                    <div class="col-md-5">
                        <form:label cssClass="form-label" path="category.id">Kategoria</form:label>
                        <form:select cssClass="form-select" path="category.id" items="${category}" itemLabel="name"
                                     itemValue="id"/>
                        <form:errors path="category.id" cssStyle="color: red"/>
                    </div>

                    <div class="col-md-4">
                        <form:label cssClass="form-label" path="brand.id">Marka</form:label>
                        <form:select cssClass="form-select" path="brand.id" items="${brand}" itemLabel="name"
                                     itemValue="id"/>
                        <form:errors path="brand.id" cssStyle="color: red"/>
                    </div>
                    <hr class="my-4">
                    <form:button class="w-100 btn btn-primary btn-lg">Zapisz</form:button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

<jsp:include page="footer.jsp"/>