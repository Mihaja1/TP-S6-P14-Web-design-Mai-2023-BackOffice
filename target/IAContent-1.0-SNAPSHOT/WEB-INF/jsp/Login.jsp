<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Cache" %>
<%@ page import="com.project.iacontent.model.Categorie" %><%--
  Created by IntelliJ IDEA.
  User: mihaja
  Date: 2023-05-06
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String error = (String) request.getAttribute("error"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="apple-touch-icon" sizes="76x76" href="<%= request.getContextPath() %>/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="<%= request.getContextPath() %>/assets/img/favicon.png">
    <title>
        Intélligence artificielle | Infos
    </title>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
    <!-- Nucleo Icons -->
    <link href="<%= request.getContextPath() %>/assets/css/nucleo-icons.css" rel="stylesheet" />
    <link href="<%= request.getContextPath() %>/assets/css/nucleo-svg.css" rel="stylesheet" />
    <!-- Font Awesome Icons -->
    <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
    <link href="<%= request.getContextPath() %>/assets/css/nucleo-svg.css" rel="stylesheet" />
    <!-- CSS Files -->
    <link id="pagestyle" href="<%= request.getContextPath() %>/assets/css/soft-ui-dashboard.css?v=1.0.3" rel="stylesheet" />
</head>

<body class="">
<main class="main-content  mt-0">
    <section>
        <div class="page-header min-vh-75">
            <div class="container">
                <div class="row">
                    <div class="col-xl-4 col-lg-5 col-md-6 d-flex flex-column mx-auto">
                        <div class="card card-plain mt-11">
                            <div class="card-header pb-0 text-left bg-transparent">
                                <h3 class="font-weight-bolder text-info text-gradient">Administrateur</h3>
                                <p class="mb-0">Login</p>
                            </div>
                            <div class="card-body">
                                <form role="form" action="<%= request.getContextPath() %>/loginAdmin" method="post">
                                    <label>Email</label>
                                    <div class="mb-3">
                                        <input type="email" class="form-control" value="admin@gmail.com" name="mail" placeholder="Email" aria-label="Email" aria-describedby="email-addon" required>
                                    </div>
                                    <label>Mot de passe</label>
                                    <div class="mb-3">
                                        <input type="password" class="form-control" value="Admin" name="motDePasse" placeholder="Mot de passe" aria-label="Password" aria-describedby="password-addon" required>
                                    </div>
                                    <div class="text-center">
                                        <button type="submit" class="btn bg-gradient-info w-100 mt-4 mb-0">Se connecter</button>
                                    </div>
                                </form>
                                <% if(error != null) {%>
                                    <p style="color: red"><%= error %></p>
                                <% } %>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="oblique position-absolute top-0 h-100 d-md-block d-none me-n8">
                            <div class="oblique-image bg-cover position-absolute fixed-top ms-auto h-100 z-index-0 ms-n6" style="background-image:url('${pageContext.request.contextPath}/assets/img/curved-images/curved6.jpg')"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<!--   Core JS Files   -->
<script src="<%= request.getContextPath() %>/assets/js/core/popper.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/core/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/plugins/perfect-scrollbar.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/plugins/smooth-scrollbar.min.js"></script>
<script async defer src="https://buttons.github.io/buttons.js"></script>
<!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<script src="<%= request.getContextPath() %>/assets/js/soft-ui-dashboard.min.js?v=1.0.3"></script>
</body>
</html>
