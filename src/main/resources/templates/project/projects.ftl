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

    <a class="btn btn-primary" href="#" ng-click="viewProjectForm()">New Project</a>

</div>