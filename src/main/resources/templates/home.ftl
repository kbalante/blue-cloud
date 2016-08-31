<!DOCTYPE html>
<html lang="en">

<#include "/common/head.ftl">

<body ng-app="blueCloud" ng-controller="mainController">

<#include "/common/nav.ftl">

<div class="container" id="projects-view">
    <h7>Home</h7>
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
    <h7>Home | Project</h7>
    <h6>{{project.name}}</h6>
    <ul class="list-group">
        <li class="list-group-item" ng-repeat="task in project.tasks">
            <span class="badge"></span>
            <a href="#" ng-click="getTask(task.id)">{{task.summary}}</a>
        </li>
    </ul>
</div>

<div class="container ng-cloak" id="task-view">
    <h7>Home | Project | Task</h7>
    <h6>{{task.summary}}</h6>
</div>

<#include "/common/footer.ftl">

</body>
</html>