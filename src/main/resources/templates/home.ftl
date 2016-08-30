<!DOCTYPE html>
<html lang="en">

<#include "/common/head.ftl">

<body ng-app="blueCloud" ng-controller="mainController">

<#include "/common/nav.ftl">

<div class="container">
    <h6>Projects</h6>
    <ul class="list-group">

        <#list projects as project>
            <li class="list-group-item">
                <span class="badge"></span>
                ${project.name}<br/>

                <#list project.tasks as task>
                ${task.summary}<br/>
                </#list>

            </li>
        </#list>

    </ul>
</div>

<#include "/common/footer.ftl">

</body>
</html>