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

       $scope.getTags = function() {
              if ($scope.tags == null) {
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
              } else {
                  console.log("Tags already on the UI");
              }
       }

       $scope.getLanguages = function() {
              if($scope.languages == null){
                 console.log("About to get languages");
                 $http.get("/language.json")
                           .then(
                           function successCallback(response) {
                               console.log(response.data);
                               console.log("getting languages");
                               $scope.languages = response.data;
                           },
                           function errorCallback(response) {
                           console.log("Unable to get languages")
                           });
              } else {
                  console.log("Languages are already in the UI")

              }

       }
       $scope.addNote = function() {
       var tagsToAdd = [];
       var languagesToAdd = [];

       for(count = 0; count<$scope.tags.length; count++){
            if($scope.tags[count].isSelected == true) {
                console.log(count);
                var tag = $scope.tags[count];
                tagsToAdd.push(tag)
            }
       }

       for(count=0; count<$scope.languages.length; count++){
            if($scope.languages[count].isSelected == true) {
                console.log(count);
                var language = $scope.languages[count];
                languagesToAdd.push(language);
            }
       }
       $scope.newNote.tags = tagsToAdd;
       $scope.newNote.languages = languagesToAdd;
       console.log("About to add the following user to our note: " + JSON.stringify($scope.newUser));
       console.log("About to add the following tags to our note: " + JSON.stringify(tagsToAdd));
       console.log("About to add the following languages to our note: " + JSON.stringify(languagesToAdd));
       console.log("About to add the following title to our note: " + JSON.stringify($scope.newNote.noteTitle));
       console.log("About to add the following code to our note: " + JSON.stringify($scope.newNote.noteCode));
       console.log("About to add the following text/comment to our note: " + JSON.stringify($scope.newNote.noteText));
       alert("just want to see the output ...");
       console.log("About to add the following note " + JSON.stringify($scope.newNote));
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

       $scope.deleteNoteModal = function(noteID) {
       console.log("About to delete the following note " + noteID);
       $scope.noteToDelete = noteID;

       }

       $scope.editNote = function(note) {
       console.log("About to edit the following note: " + note);
       console.log("note title: " + note.noteTitle);
       console.log("Note id: " + note.id);
       console.log("Note text: " + note.noteText);
       $scope.noteToEdit = note;
       }

//
//       $scope.(document).on("click", ".open-deleteNote", function () {
//            var noteToDelete = $(this).data('note.id');
//            $(".modal-body #noteId").val(noteToDelete);
//            // As pointed out in comments,
//            // it is superfluous to i to manually call the modal.
//            // $('#addBookDialog').modal('show');
//       }

       $scope.toggleTopic = function(tag) {
        console.log(tag);
        tag.isSelected = !tag.isSelected;
       }

       $scope.toggleLanguage = function(language) {
        console.log(language);
        language.isSelected = !language.isSelected;
       }




        console.log("SampleController ...");
        $scope.name = "James";
        $scope.newNote = {};
    });

