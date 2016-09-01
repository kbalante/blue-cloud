<div class="container ng-cloak" id="project-view">
    <h7><a href="#" ng-click="showProjects()">Home</a> | Project</h7>
    <h6>{{project.name}}</h6>
    <ul class="list-group">
        <li class="list-group-item" ng-repeat="task in project.tasks">
            <span class="badge"></span>
            <a href="#" ng-click="getTask(task.id, project.id)">{{task.summary}}</a>
        </li>
    </ul>
    <a class="btn btn-primary" href="#">New Task</a>
</div>