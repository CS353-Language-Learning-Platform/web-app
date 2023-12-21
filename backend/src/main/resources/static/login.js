function getAllUsers() {
    // Sunucudan tüm kullanıcı verilerini al
    
    fetch('http://localhost:8080/users')
        .then(response => response.json())
        .then(users => {
            // Verileri HTML içerisine yerleştir
            const userList = document.getElementById('user-list');
            users.forEach(user => {
                const listItem = document.createElement('li');
                listItem.textContent = user.email;
                userList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Hata:', error));
}

async function loginUser() {

    event.preventDefault()

    
    let email = document.getElementById('email').value;
let password = document.getElementById('password').value;

fetch('http://localhost:8080/users')
    .then(response => response.json())
    .then(users => {
        // Kullanıcıyı bul
        let user = users.find(user => user.email === email);
        console.log(user);
        console.log(password);

        // Eğer kullanıcı varsa ve şifre eşleşiyorsa, bir mesaj logla
        if (user && user.password === password) {
            localStorage.setItem('user', JSON.stringify(user));
            window.location.href = "http://localhost:8080/userProfilePage.html";
        } else {
            alert('Kullanıcı adı veya şifre yanlış');
        }
    })
    .catch(error => console.error('Hata:', error));

}
