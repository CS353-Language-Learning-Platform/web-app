
function showDiv(id) {
  // Tüm div'leri gizle
  document.getElementById('sessions').style.display = 'none';
  document.getElementById('notifications').style.display = 'none';
  document.getElementById('sources').style.display = 'none';
  document.getElementById('announcement-container').style.display = 'none';

  // Seçilen div'i göster
  document.getElementById(id).style.display = 'block';
}// Get the modal
var modal = document.getElementById("feedbackModal");

// Get the button that opens the modal
var btns = document.getElementsByClassName("feedback-button");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal 
for (let btn of btns) {
    btn.onclick = function() {
        modal.style.display = "block";
    }
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

// Handle the feedback submission
document.getElementById("feedbackForm").onsubmit = function(event) {
    event.preventDefault(); // Prevent the form from submitting through the browser
    var feedback = document.getElementById("feedbackText").value;
    console.log("Feedback submitted: " + feedback);
    // Here you would typically send the feedback to the server
    modal.style.display = "none";
    // Optionally clear the textarea or give the user a message of success
}
