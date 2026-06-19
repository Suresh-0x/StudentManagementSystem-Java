document.getElementById("studentForm")
.addEventListener("submit", function(e) {

    e.preventDefault();

    let name = document.getElementById("name").value;

    if(name.length < 3){
        alert("Name must be at least 3 characters");
        return;
    }

    alert("Form Submitted Successfully");
});