function changeCompleted(taskName) {
    // var form = document.getElementById("sendCompleteForm");
    // var hiddenInput = document.createElement("input");
    // hiddenInput.type = "hidden";
    // hiddenInput.name = "actionName";
    // hiddenInput.value = taskName;
    // form.appendChild(hiddenInput);
    // form.submit();

    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        // if (request.status == 200) {
        //     alert("e ok")
        // }
    };
    request.open("put", "add-new?actionName=" + taskName, true);
    request.send();

}