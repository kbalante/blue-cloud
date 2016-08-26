angular.module('blueCloud', [])
    .controller('reminderController', function($scope) {

        var reminders = [
            {summary:'Angular to add item to reminders list', priority: 'High' ,date: '', done:false}];
        $scope.reminders = reminders;

        var yesterdayReminders = [
            {summary:'Schedules: get schedules for sports teams', priority: 'High' , date: '', done:false},
            {summary:'A reminder is a task is an event. They are all the same thing.', date: '', priority: 'High' , done:false},
            {summary:'Project, email, document management tool', priority: 'High' , date: '', done:false},
            {summary:'Upgrade: Smart mode automatically creates reminders for you e.g. pay your taxes, file business taxes, renew car registration. Would be cool if it knew to tell you to pay for parking fines and so on.', priority: 'High' , date: '', done:false},
            {summary:'Promote will feature reminders that you need to work on or are in progress', priority: 'High' , date: '', done:false},
            {summary:'7 healthy habits quadrants breakdown -- create 4 lists', priority: 'High' , date: '', done:false},
            {summary:'add motivation through badges or titles', priority: 'High' , date: '', done:false},
            {summary:'Need a 10 second tutorial on how to use app', priority: 'High' ,date: '', done:false}];
        $scope.yesterdayReminders = yesterdayReminders;


        $scope.addReminder = function () {
            var reminder = {summary:this.reminder.summary, priority:this.reminder.priority, date:this.reminder.date, done:false}
            $scope.reminders.unshift(reminder);
        };

        $scope.clearReminder = function () {
            $scope.reminder = {summary:"", priority:"", date:"", done:false};
        };

        $scope.setReminder = function (reminder) {
            $scope.reminder = {summary:reminder.summary, priority:reminder.priority, date:reminder.date, done:reminder.done};
        };
    });