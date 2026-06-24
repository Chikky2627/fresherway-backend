async function login() {

    const email =
        document.getElementById("email").value;

    const password =
        document.getElementById("password").value;

    const response =
        await fetch(
            "http://localhost:8086/api/auth/login",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    email: email,
                    password: password
                })
            }
        );

    const data = await response.json();

    document.getElementById(
        "message"
    ).innerText =
        data.message;

    if (data.token) {

        localStorage.setItem(
            "token",
            data.token
        );

        alert(
            "Login Successful"
        );
    }
}