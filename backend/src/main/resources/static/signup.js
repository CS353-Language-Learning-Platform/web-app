/*document.addEventListener('DOMContentLoaded', function () {
    // Sayfa yüklendiğinde çağrılacak fonksiyon
 
});
*/
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
    let name = document.getElementById('username').value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;


    let userAddRequest = {
        name: name,
        email: email,
        password: password,
        birthDate: new Date("2022-03-25"),
        biography: "noBio",
        nationality: "nationality",
    };
    var userType = document.querySelector('select').value;
    console.log(userType);
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
    .then(data => {

        fetch('http://localhost:8080/users')
    .then(response => response.json())
    .then(users => {
        // Kullanıcıyı bul
        let user = users.find(user => user.email === email);
        console.log(user.userId);

         if(userType == "en")
         {
            let learnerAddRequest = {
                userId: user.userId
             };
            fetch('http://localhost:8080/learners', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(learnerAddRequest)
            })
            .then(response => {
                console.log('Response Headers:', response.headers);
            })
            .then(data => {
        
              //  window.location.href = "http://localhost:8080/login.html";
            }).catch(error => console.error('Hata:', error));
         
         }
         else
         {
            let teacherAddRequest = {
                userId: user.userId,
                isApproved: true
             };
            fetch('http://localhost:8080/teachers', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(teacherAddRequest)
            })
            .then(response => {
                console.log('Response Headers:', response.headers);
            })
            .then(data => {
        
              //  window.location.href = "http://localhost:8080/login.html";
            }).catch(error => console.error('Hata:', error));
         
         }
       
    })
    .catch(error => console.error('Hata:', error));
      
})
.catch((error) => console.error('Hata:', error))



}
