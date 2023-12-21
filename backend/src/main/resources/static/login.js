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
            
            console.log(user.userId);

            
            fetch('http://localhost:8080/learners')
            .then(response => response.json())
            .then(learners => {
                // Verileri HTML içerisine yerleştir
                fetch('http://localhost:8080/teachers')
                .then(response => response.json())
                .then(teachers => {
                    // Verileri HTML içerisine yerleştir
                    let learner = learners.find(learner => learner.userId === user.userId)

                    let teacher = teachers.find(teacher => teacher.userId === user.userId)

                    localStorage.setItem('user', JSON.stringify(user));
                    if(learner)
                    {
                        window.location.href = "http://localhost:8080/userProfilePage.html";
                    }
                    else if(teacher)
                    {
                        window.location.href = "http://localhost:8080/teacher.html";
                    }
                    else
                    {
                        window.location.href = "http://localhost:8080/admin.html";
                    }
    
                })
                .catch(error => console.error('Hata:', error));

   

            })
            .catch(error => console.error('Hata:', error));


        } else {
            alert('Kullanıcı adı veya şifre yanlış');
        }
    })
    .catch(error => console.error('Hata:', error));

}
