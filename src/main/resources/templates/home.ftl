<!DOCTYPE html>
<html lang="en">

<#include "/common/head.ftl">

<body ng-app="blueCloud" ng-controller="mainController">

<#include "/common/nav.ftl">

<div class="container" id="projects-view">
    <h6>Projects</h6>
    <ul class="list-group">

        <#list projects as project>
            <li class="list-group-item">
                <span class="badge"></span>
                <a href="#" ng-click="getProject(${project.id})">${project.name}</a>
            </li>
        </#list>

    </ul>
</div>

<div class="container ng-cloak" id="project-view">
    <h6>{{project.name}}</h6>
</div>

<div class="container ng-cloak" id="task-view">
    <h6>{{task.summary}}</h6>
</div>

<#include "/common/footer.ftl">

</body>
</html>