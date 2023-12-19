function myFunction() {
    alert("Butona tıklandı!");
  }
  function showDiv(id) {
    // Tüm div'leri gizle
    document.getElementById('accountSettings').style.display = 'none';
    document.getElementById('notifications').style.display = 'none';
    document.getElementById('memberships').style.display = 'none';
    document.getElementById('student-session-container').style.display = 'none';
    document.getElementById('search-results').style.display = 'none';
    document.getElementById('buy-results').style.display = 'none';
    


    // Seçilen div'i göster
    document.getElementById(id).style.display = 'block';
}
function searchTeachersOnly(id)
{
  document.getElementById(id).style.display = 'block';
}
function buySession(id) {
  document.getElementById('accountSettings').style.display = 'none';
  document.getElementById('notifications').style.display = 'none';
  document.getElementById('memberships').style.display = 'none';
  document.getElementById('student-session-container').style.display = 'none';
  document.getElementById('search-results').style.display = 'none';
  document.getElementById('teacherInfo').style.display = 'none';

  // Seçilen div'i göster
  document.getElementById(id).style.display = 'block';
}


// Function to show the buy session modal
function showBuySessionModal() {
  var modal = document.getElementById('buySessionModal');
  modal.style.display = 'block';
}

// Get all the time-slot buttons and attach the click event to them
var timeSlots = document.getElementsByClassName('time-slot');
for (var i = 0; i < timeSlots.length; i++) {
  timeSlots[i].addEventListener('click', showBuySessionModal);
}

// Get the modal close button and the modal itself
var closeModal = document.getElementsByClassName('close')[0];
var modal = document.getElementById('buySessionModal');

// Close the modal when the close button (x) is clicked
closeModal.onclick = function() {
  modal.style.display = 'none';
}

// Also close the modal if the user clicks the No button
document.getElementById('noButton').onclick = function() {
  modal.style.display = 'none';
}

// If the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target === modal) {
    modal.style.display = 'none';
  }
}
