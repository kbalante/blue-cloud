<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#/">BlueCloud</a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <#-- <li><a href="#" class="md-trigger" data-modal="modal-16" ng-click="clearReminder()">New Reminder<span class="sr-only">(current)</span></a></li>-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="true">View <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/registration" class="md-trigger" data-modal="modal-16">Registration</a></li>
                        <li><a href="/login">Login</a></li>
                        <li><a href="#"></a></li>
                        <li class="divider"></li>
                        <li><a href="#"></a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
            </form>
            <ul class="nav navbar-nav navbar-left">
                <li><a href="#">Help</a></li>
            </ul>
        </div>
    </div>
</nav>