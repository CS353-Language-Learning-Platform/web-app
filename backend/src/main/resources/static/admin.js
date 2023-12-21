 function showDiv(id) {
  // Tüm div'leri gizle
  document.getElementById('langlearner').style.display = 'none';
  document.getElementById('teacher').style.display = 'none';


  // Seçilen div'i göster
  document.getElementById(id).style.display = 'block';
}
function showInfo() {
  // Tüm div'leri gizle
  fetch('http://localhost:8080/languages/target/1')
    .then(response => response.json())
    .then(users => {
        // Kullanıcıyı bul
        console.log(users.languageId);
        console.log(users.learnerId);
        console.log(users.proficiencyLevel);
    
      })
      .catch((error) => console.error('Hata:', error));


}
