function changeCompleted(taskName) {
    var form = document.getElementById("sendCompleteForm");
    var hiddenInput = document.createElement("input");
    hiddenInput.type = "hidden";
    hiddenInput.name = "taskName";
    hiddenInput.value = taskName;
    form.appendChild(hiddenInput);
    form.submit();
}