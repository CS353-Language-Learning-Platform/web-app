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

    // Seçilen div'i göster
    document.getElementById(id).style.display = 'block';
}
