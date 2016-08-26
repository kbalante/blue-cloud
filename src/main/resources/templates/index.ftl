<!DOCTYPE html>
<html lang="en" ng-app="blueCloud">

<#include "/common/head.ftl">

<body ng-controller="reminderController">

<#include "/common/nav.ftl">

<div class="container">

    <h6>Today</h6>
    <ul class="list-group">
        <li class="list-group-item" ng-repeat="reminder in reminders">
            <span class="badge">{{ reminder.priority }}</span>
            {{ reminder.summary }}
        </li>
    </ul>

    <ul class="list-group">
        <li class="list-group-item">
            <span class="badge">Low</span>
            <a href="#" class="md-trigger" data-modal="modal-16">test</a>
        </li>
    </ul>

    <h6>Yesterday</h6>
    <ul class="list-group">
        <li class="list-group-item" ng-repeat="reminder in yesterdayReminders">
            <span class="badge">{{ reminder.priority }}</span>
            {{ reminder.summary }}
        </li>
    </ul>

</div>


<div class="bs-component md-modal md-effect-16" id="modal-16">
    <div class="md-content">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="bs-component">
                        <form class="form-horizontal">
                            <fieldset>
                                <div class="form-group">
                                    <label for="inputSummary" class="col-lg-2 control-label">Reminder</label>
                                    <div class="col-lg-10">
                                        <input type="text" class="form-control" id="inputSummary" placeholder="Remember to ..." ng-model="reminder.summary" autofocus>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputDate" class="col-lg-2 control-label">Date/Time</label>
                                    <div class="col-lg-10">
                                        <input type="text" class="form-control" id="inputDate" placeholder="6/18/2016 or Today" ng-model="reminder.date">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPriority" class="col-lg-2 control-label">Priority</label>
                                    <div class="col-lg-10">
                                        <input type="text" class="form-control" id="inputPriority" placeholder="Medium" ng-model="reminder.priority">
                                    </div>
                                </div>
                                <br/>
                                <button type="button" class="btn btn-primary md-close" data-dismiss="modal" ng-click="addReminder()">Create Reminder</button>
                            </fieldset>
                        </form>

                        <div id="source-button" class="btn btn-primary btn-xs" style="display: none;">&lt; &gt;</div></div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="md-overlay"></div><!-- the overlay element -->

<#include "/common/footer.ftl">

</body>
</html>