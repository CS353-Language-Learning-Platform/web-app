document.addEventListener('DOMContentLoaded', function () {
    // Sayfa yüklendiğinde çağrılacak fonksiyon
    //addUser();
    getAllUsers();
    addUser();
});

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
function addUser() {
    let userAddRequest = {
         // Make sure to include all required properties
        name: "saas",
        email: "z@31sdz",
        password: "password123",
        birthDate:  new Date("2022-03-25"),
        biography: "Some bio",
        nationality: "Some nationality",
    };
 
     console.log(JSON.stringify(userAddRequest));
     fetch('http://localhost:8080/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userAddRequest)
    })
    .then(response => {
        console.log('Response Headers:', response.headers);
    })
    .then(data => console.log('Response Data:', data))
    .catch((error) => console.error('Hata:', error));
    
}
