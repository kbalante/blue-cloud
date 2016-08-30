<!DOCTYPE html>
<html lang="en">

<#include "/common/head.ftl">

<body ng-app="blueCloud" ng-controller="mainController">

<#include "/common/nav.ftl">

<div class="container">
    <h6>Project</h6>
    ${project.name}<br/>
    <ul class="list-group">
        <li class="list-group-item">
            <#list project.tasks as task>
            ${task.summary}<br/>
            </#list>
        </li>
    </ul>
</div>

<#include "/common/footer.ftl">

</body>
</html>