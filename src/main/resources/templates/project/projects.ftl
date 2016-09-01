<div class="container ng-cloak" id="projects-view">
    <h7><a href="#" ng-click="showProjects()">Home</a>
    <h6>Projects</h6>
    <ul class="list-group">
        <li class="list-group-item" ng-repeat="project in projects">
            <span class="badge"></span>
            <a href="#" ng-click="getProject(project.id)">{{project.name}}</a>
        </li>
    </ul>

    <a class="btn btn-primary" href="#" ng-click="showProjectForm()">New Project</a>

</div>