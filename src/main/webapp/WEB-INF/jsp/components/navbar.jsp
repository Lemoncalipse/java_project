<!-- Navbar -->

<nav class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand" href="<c:url value='/' />">Sportsbetting</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">
                        <spring:message code="navbar.home"/>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">
                        <spring:message code="navbar.events"/>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <spring:message code="navbar.language"/>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="?lang=en">
                            <spring:message code="navbar.language.english"/>
                        </a>
                        <a class="dropdown-item" href="?lang=hu">
                            <spring:message code="navbar.language.hungarian"/>
                        </a>
                    </div>
                </li>
            </ul>
            <form  action="<c:url value='/logout' />" method="POST">
                <input class="btn btn-outline-primary my-2 my-sm-0" type="submit" value='<spring:message code="navbar.button.logout"/>'/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>
</nav>