
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
    let user;
    fetch('http://localhost:8080/users')
    .then(response => response.json())
    .then(users => {
         user = users;
      })
      .catch((error) => console.error('Hata:', error));

    fetch('http://localhost:8080/learners')
    .then(response => response.json())
    .then(learners => {
      for(let i = 0; i < learners.length; i++)
      {
          var apiUrl = 'http://localhost:8080/languages/target/' + learners[i].userId;
          fetch(apiUrl)
          .then(response => response.json())
          .then(users => {
              // Kullanıcıyı bul

              if( users[0] && users[0].languageId == 2)
              {
                console.log("created");

                let studentInfoUl = document.getElementById('studentInfo');
                let languageId = 3;

                // Yeni li öğesini oluştur
                let li = document.createElement('li');
                li.className = 'search-results';

                // Bilgi div'i oluştur
                let infoDiv = document.createElement('div');
                infoDiv.className = 'info';

                // İsim span'ı oluştur
                let nameSpan = document.createElement('span');
                nameSpan.className = 'name';
                nameSpan.textContent = user[learners[i].userId].name;

                // Dil span'ı oluştur
                let languageSpan = document.createElement('span');
                languageSpan.className = 'language';
                languageSpan.textContent = 'Target Language-+>English ';

                // Buton oluştur
                let button = document.createElement('button');
                button.className = 'offer-button';
                button.onclick = function() { offerSession('offer-results'); };
                button.textContent = 'Offer Session';

                // Elementleri birleştir
                infoDiv.appendChild(nameSpan);
                infoDiv.appendChild(languageSpan);
                li.appendChild(infoDiv);
                li.appendChild(button);

                // Yeni li öğesini ul içine ekle
                studentInfoUl.appendChild(li);
                //user[learners[i].userId].name; // Öğrencinin adını kullan
               
              }
            })
            .catch((error) => console.error('Hata:', error));

      }
    })
    .catch(error => console.error('Hata:', error));
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

