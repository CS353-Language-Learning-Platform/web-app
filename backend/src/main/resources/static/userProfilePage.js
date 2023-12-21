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
function follow(id) {
  document.getElementById('teacherInfo').style.display = 'none';
}
  var modal;

// Function to show the buy session modal
window.onload = function() {
  modal = document.getElementById("buySessionModal");
  var buttons = document.getElementsByClassName("time-slot");
  var myFunction = function() {
    modal.style.display = 'block';
  };
  for (var i = 0; i < buttons.length; i++) {
      buttons[i].addEventListener('click', myFunction, false);
  }
}
window.onclick = function(event) {
  if (event.target == modal) {
      modal.style.display = "none";
  }
}


