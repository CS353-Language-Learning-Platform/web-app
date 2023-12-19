
function showDiv(id) {
  // Tüm div'leri gizle
  document.getElementById('sessions').style.display = 'none';
  document.getElementById('notifications').style.display = 'none';
  document.getElementById('sources').style.display = 'none';
  document.getElementById('announcement-container').style.display = 'none';
  document.getElementById('offer-results').style.display = 'none';
  // Seçilen div'i göster
  document.getElementById(id).style.display = 'block';
}// Get the modal
function offerSession(id) {
  document.getElementById('sessions').style.display = 'none';
  document.getElementById('notifications').style.display = 'none';
  document.getElementById('sources').style.display = 'none';
  document.getElementById('announcement-container').style.display = 'none';
  document.getElementById('offer-results').style.display = 'none';
  document.getElementById('studentInfo').style.display = 'none';

  // Seçilen div'i göster
  document.getElementById(id).style.display = 'block';
}
function searchStudentsOnly(id)
{
  document.getElementById(id).style.display = 'block';
  
}
// Declare variables in the global scope
var modal;
var btns;
var span;

window.onload = function() {
  // Initialize the variables
  modal = document.getElementById("feedbackModal");
  btns = document.getElementsByClassName("feedback-button");
  span = document.getElementsByClassName("close")[0];

  // Add event listeners to the buttons
  for (let btn of btns) {
    btn.onclick = function() {
      modal.style.display = "block";
    }
  }
  span.onclick = function() {
    modal.style.display = "none";
}


document.getElementById("feedbackForm").onsubmit = function(event) {
    event.preventDefault(); // Prevent the form from submitting through the browser
    var feedback = document.getElementById("feedbackText").value;
    console.log("Feedback submitted: " + feedback);
    // Here you would typically send the feedback to the server
    modal.style.display = "none";
    // Optionally clear the textarea or give the user a message of success
  }

  var timeSlots = document.getElementsByClassName("time-slot");
  for (var i = 0; i < timeSlots.length; i++) {
    timeSlots[i].onclick = function() {
      document.getElementById('offer-results').style.display = 'none';
    }
  }
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

