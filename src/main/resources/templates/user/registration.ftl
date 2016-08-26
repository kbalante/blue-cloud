<!DOCTYPE html>
<html lang="en">

<#include "/common/head.ftl">

<body ng-app="blueCloud" ng-controller="mainController">

<#include "/common/nav.ftl">

<div class="container">

    <#if error??>
        <div class="panel panel-warning">
            <div class="panel-heading">
                <h3 class="panel-title">Warning</h3>
            </div>
            <div class="panel-body">
                ${error}
            </div>
        </div>
    </#if>

    <form name="form" action="/registration-submit" method="post" novalidate>
        <fieldset>
            <legend>Registration</legend>
            <div class="form-group">
                <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                <div class="col-lg-10">
                    <input class="form-control" type="email" ng-model="user.email" name="email" required="" />
                    <div ng-show="form.$submitted || form.email.$touched">
                        <span ng-show="form.email.$error.required">Please enter your email.</span>
                        <span ng-show="form.email.$error.email">Please enter a valid email.</span>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                <div class="col-lg-10">
                    <input class="form-control" name="password" type="password" ng-model="user.password" required=""/>
                    <div ng-show="form.$submitted || form.password.$touched">
                        <span ng-show="form.password.$error.required">Please enter your password.</span>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <button type="submit" class="btn btn-primary" ng-disabled="form.$invalid">Register</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>

<#include "/common/footer.ftl">

</body>
</html>