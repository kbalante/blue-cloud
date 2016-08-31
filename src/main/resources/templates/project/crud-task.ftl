<div class="container ng-cloak" id="crud-task-view">
    <div class="panel panel-warning" ng-show="error">
        <div class="panel-heading">
            <h3 class="panel-title">Warning</h3>
        </div>
        <div class="panel-body">
            {{error}}
        </div>
    </div>
    <form name="form" action="/project-submit" method="post" novalidate>
        <fieldset>
            <legend>Project</legend>
            <div class="form-group">
                <label for="inputName" class="col-lg-2 control-label">Name</label>
                <div class="col-lg-10">
                    <input class="form-control" type="text" ng-model="project.name" name="name" required="" />
                    <div ng-show="form.$submitted || form.name.$touched">
                        <span ng-show="form.name.$error.required">Please enter your name.</span>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="inputName" class="col-lg-2 control-label">Visibility</label>
                <div class="col-lg-10">
                    <select class="form-control" id="select">
                        <option>Private</option>
                        <option>Public</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <button type="submit" class="btn btn-primary" ng-disabled="form.$invalid">Create</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>