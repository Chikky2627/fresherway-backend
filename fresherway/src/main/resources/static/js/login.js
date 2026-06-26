async function login() {

    const email =
        document.getElementById("email").value.trim();

    const password =
        document.getElementById("password").value.trim();

    const message =
        document.getElementById("message");

    message.innerHTML = "";

    if (email === "" || password === "") {

        message.style.color = "red";
        message.innerHTML = "Please enter email and password.";

        return;
    }

    try {

        const response = await fetch("/api/auth/login", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                email: email,
                password: password
            })

        });

        const data = await response.json();

        if (response.ok && data.token) {

            localStorage.setItem("token", data.token);
            localStorage.setItem("email", email);

            message.style.color = "green";
            message.innerHTML = "Login Successful ✓";

            setTimeout(() => {

                window.location.href = "/jobs.html";

            }, 1000);

        } else {

            message.style.color = "red";
            message.innerHTML = data.message;

        }

    } catch (error) {

        console.error(error);

        message.style.color = "red";
        message.innerHTML = "Unable to connect to server.";

    }

}