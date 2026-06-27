// ===================== LOAD PAGE =====================

window.onload = function () {

    loadApplications();

};

// ===================== LOAD APPLICATIONS =====================

async function loadApplications() {

    // Temporary userId
    // Later replace with:
    // const userId = localStorage.getItem("userId");

    const userId = 1;

    try {

        const response =
            await fetch(
                "/api/applications/user/" + userId
            );

        const applications =
            await response.json();

        displayApplications(applications);

    }

    catch (error) {

        console.log(error);

        document.getElementById(
            "applicationsContainer"
        ).innerHTML =

        "<h2>Unable to load applications.</h2>";

    }

}

// ===================== DISPLAY APPLICATIONS =====================

function displayApplications(applications) {

    const container =
        document.getElementById(
            "applicationsContainer"
        );

    container.innerHTML = "";

    if (applications.length === 0) {

        container.innerHTML =

        "<h2>No Applications Found</h2>";

        return;

    }

    applications.forEach(application => {

        let statusClass = "";

        if (application.status === "APPLIED") {

            statusClass = "applied";

        }

        else if (application.status === "INTERVIEW") {

            statusClass = "interview";

        }

        else if (application.status === "SELECTED") {

            statusClass = "selected";

        }

        else if (application.status === "REJECTED") {

            statusClass = "rejected";

        }

        container.innerHTML += `

        <div class="application-card">

            <h2>

                Application #${application.id}

            </h2>

            <p>

                <strong>User ID :</strong>

                ${application.userId}

            </p>

            <p>

                <strong>Job ID :</strong>

                ${application.jobId}

            </p>

            <p>

                <strong>Status :</strong>

                <span class="status ${statusClass}">

                    ${application.status}

                </span>

            </p>

        </div>

        `;

    });

}

// ===================== LOGOUT =====================

function logout() {

    localStorage.removeItem("token");

    localStorage.removeItem("email");

    window.location.href = "/login.html";

}