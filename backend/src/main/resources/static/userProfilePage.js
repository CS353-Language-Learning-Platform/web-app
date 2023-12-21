function myFunction() {
  var targetLanguageAddRequest = {
    languageId: 1,
    learnerId: 1,
    proficiencyLevel: "Medium"
  };
  
  fetch('http://localhost:8080/languages/target', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(targetLanguageAddRequest)
  })
  .then(response => 
  {
      console.log('Response Headers:', response.headers);
  })
  .then(data => {
      console.log('Response Data:', data);
     
  })
  .catch((error) => console.error('Hata:', error));


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

  let user = JSON.parse(localStorage.getItem('user'));

      // Verileri HTML içerisine yerleştir
      document.getElementById('fullname').value = user.name;
      document.getElementById('email').value = user.email;
 
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

