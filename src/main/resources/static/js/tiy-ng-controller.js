angular.module('TIYAngularApp', [])
   .controller('SampleController', function($scope, $http) {

       $scope.testNotes = function() {
           console.log("I am the testNotes() function");
           $scope.name = "testNotes() is in charge!";
       };

       $scope.getNotes = function() {
        $http.get("/notes.json")
               .then(
                function successCallback(response) {
                console.log(response.data);
                console.log("Adding data to scope");
                $scope.notes =response.data;
                })
       };

       $scope.getUser = function() {
       console.log("About to get the user");
       $http.post("/getUser.json",$scope.newUser)
                .then(
                function successCallback(response) {
                    console.log(response.data);
                    console.log("getting the user");

                    $scope.newUser = response.data;
                },
                function errorCallback(response) {
                    console.log("Unable to get user")
                });
       }

       $scope.getTags = function() {
              console.log("About to get tags");
              $http.get("/tags.json")
                       .then(
                       function successCallback(response) {
                           console.log(response.data);
                           console.log("getting tags");
                           $scope.tags = response.data;
                       },
                       function errorCallback(response) {
                           console.log("Unable to get tags")
                       });
              }

       $scope.getLanguages = function() {
              console.log("About to get tags");
              $http.get("/languages.json")
                       .then(
                       function successCallback(response) {
                           console.log(response.data);
                           console.log("getting languages");
                           $scope.languages = response.data;
                       },
                       function errorCallback(response) {
                           console.log("Unable to get languages")
                       });
              }

       $scope.addNote = function() {
       console.log("About to add the following note " + JSON.stringify($scope.newNote));
       console.log("About to add the following user to our note" + JSON.stringify($scope.newUser));
       alert("just want to see the output ...");
       $scope.newNote.user = $scope.newUser;
       $http.post("/addNote.json", $scope.newNote)
                .then(
                function successCallback(response) {
                    alert("Got the response!");
                    console.log(response.data);
                    console.log("adding data to scope");
                    alert("setting notes to new notes");
                    $scope.notes = response.data;
                    alert("notes added!");
                },
                function errorCallback(response) {
                    alert("got an error!");
                    console.log("unable to get data")
                });
       }

       $scope.deleteNote = function (noteID) {
       console.log("About to delete the following note " + noteID);

       $http.get("/deleteNote.json?noteID="+noteID)
            .then(
               function success(response){
                   console.log(response.data);
                   console.log("Note deleted");
                   $scope.notes = response.data;
               },
               function error(response) {
                   console.log("unable to delete note");

               });

       }



        console.log("SampleController ...");
        $scope.name = "James";
        $scope.newNote = {};
    });

