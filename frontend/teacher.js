
function showDiv(id) {
  // Tüm div'leri gizle
  document.getElementById('sessions').style.display = 'none';
  document.getElementById('notifications').style.display = 'none';
  document.getElementById('sources').style.display = 'none';
  document.getElementById('makeAnnouncement').style.display = 'none';

  // Seçilen div'i göster
  document.getElementById(id).style.display = 'block';
}