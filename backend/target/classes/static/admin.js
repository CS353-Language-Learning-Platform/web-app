 function showDiv(id) {
  // Tüm div'leri gizle
  document.getElementById('langlearner').style.display = 'none';
  document.getElementById('teacher').style.display = 'none';


  // Seçilen div'i göster
  document.getElementById(id).style.display = 'block';
}
