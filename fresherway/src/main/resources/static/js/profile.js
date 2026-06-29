// ==================== PAGE LOAD ====================

window.onload = function () {

    loadProfile();

};

// Temporary userId
// Later replace with logged-in user's ID

const userId =
    localStorage.getItem("userId");

// ==================== LOAD PROFILE ====================

async function loadProfile() {

    try {

        const response =
            await fetch("/api/profile/" + userId);

        if (!response.ok) {

            return;

        }

        const profile =
            await response.json();

        document.getElementById("college").value =
            profile.college || "";

        document.getElementById("branch").value =
            profile.branch || "";

        document.getElementById("cgpa").value =
            profile.cgpa || "";

        document.getElementById("skills").value =
            profile.skills || "";

    }

    catch (error) {

        console.log(error);

    }

}

// ==================== SAVE PROFILE ====================

async function saveProfile() {

    const profile = {

        userId: userId,

        college:
            document.getElementById("college").value,

        branch:
            document.getElementById("branch").value,

        cgpa:
            document.getElementById("cgpa").value,

        skills:
            document.getElementById("skills").value,

        resumeUrl: ""

    };

    try {

        let response =
            await fetch("/api/profile/" + userId);

        if (response.ok) {

            response =
                await fetch("/api/profile/" + userId, {

                    method: "PUT",

                    headers: {

                        "Content-Type": "application/json"

                    },

                    body: JSON.stringify(profile)

                });

        }

        else {

            response =
                await fetch("/api/profile", {

                    method: "POST",

                    headers: {

                        "Content-Type": "application/json"

                    },

                    body: JSON.stringify(profile)

                });

        }

        const message =
            await response.text();

        document.getElementById("message").innerHTML =
            message;

    }

    catch (error) {

        console.log(error);

    }

}

// ==================== UPLOAD RESUME ====================

async function uploadResume() {

    const file =
        document.getElementById("resumeFile").files[0];

    if (!file) {

        alert("Please select a resume.");

        return;

    }

    const formData =
        new FormData();

    formData.append("userId", userId);

    formData.append("file", file);

    try {

        const response =
            await fetch("/api/resume/upload", {

                method: "POST",

                body: formData

            });

        const message =
            await response.text();

        document.getElementById("message").innerHTML =
            message;

    }

    catch (error) {

        console.log(error);

        document.getElementById("message").innerHTML =
            "Upload Failed";

    }

}

// ==================== LOGOUT ====================

function logout() {

    localStorage.removeItem("token");

    localStorage.removeItem("email");

    window.location.href =
        "/login.html";

}