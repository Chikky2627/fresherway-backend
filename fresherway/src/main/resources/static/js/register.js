async function register() {

    const name =
        document.getElementById("name").value.trim();

    const email =
        document.getElementById("email").value.trim();

    const password =
        document.getElementById("password").value.trim();

    const role =
        document.getElementById("role").value;

    const message =
        document.getElementById("message");

    message.innerHTML = "";

    // Validation

    if (name === "" ||
        email === "" ||
        password === "") {

        message.style.color = "red";

        message.innerHTML =
            "Please fill all fields.";

        return;
    }

    if (password.length < 6) {

        message.style.color = "red";

        message.innerHTML =
            "Password must be at least 6 characters.";

        return;
    }

    try {

        const response =
            await fetch("/api/auth/register", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify({

                    name: name,

                    email: email,

                    password: password,

                    role: role

                })

            });

        const data =
            await response.json();

        if (response.ok) {

            message.style.color = "green";

            message.innerHTML =
                data.message;

            alert(
                "Registration Successful!\nPlease verify your email before logging in."
            );

            setTimeout(() => {

                window.location.href =
                    "/login.html";

            }, 2000);

        } else {

            message.style.color = "red";

            message.innerHTML =
                data.message;

        }

    } catch (error) {

        console.error(error);

        message.style.color = "red";

        message.innerHTML =
            "Unable to connect to server.";

    }

}