// Load jobs when page opens
window.onload = function () {

    loadJobs();

    const email = localStorage.getItem("email");

    if (email) {

        document.getElementById("welcomeUser").innerHTML =
            "Welcome, " + email;

    }

};

// -------------------- LOAD ALL JOBS --------------------

async function loadJobs() {

    try {

        const response =
            await fetch("/api/jobs");

        const jobs =
            await response.json();

        displayJobs(jobs);

    } catch (error) {

        console.error(error);

    }
}

// -------------------- DISPLAY JOBS --------------------

function displayJobs(jobs) {

    const container =
        document.getElementById("jobsContainer");

    container.innerHTML = "";

    if (jobs.length === 0) {

        container.innerHTML =
            "<h2>No Jobs Found</h2>";

        return;

    }

    jobs.forEach(job => {

        container.innerHTML += `

        <div class="job-card">

            <h3>${job.jobTitle}</h3>

            <p><strong>Company:</strong> ${job.companyName}</p>

            <p><strong>Location:</strong> ${job.location}</p>

            <p><strong>Salary:</strong> ${job.salary}</p>

            <p><strong>Skills:</strong> ${job.skillsRequired}</p>

            <p>${job.description}</p>

            <button
                class="apply-btn"
                onclick="applyJob(${job.id})">

                Apply Now

            </button>

        </div>

        `;

    });
   
}

// -------------------- SEARCH --------------------

async function searchJobs() {

    const skill =
        document.getElementById("skill").value.trim();

    const location =
        document.getElementById("location").value.trim();

    let url = "/api/jobs";

    if (skill !== "" && location !== "") {

        url =
            `/api/jobs/search?skill=${skill}&location=${location}`;

    }

    else if (skill !== "") {

        url =
            `/api/jobs/search/skill/${skill}`;

    }

    else if (location !== "") {

        url =
            `/api/jobs/search/location/${location}`;

    }

    try {

        const response =
            await fetch(url);

        const jobs =
            await response.json();

        displayJobs(jobs);

    }

    catch (error) {

        console.log(error);

    }

}

// -------------------- APPLY --------------------

async function applyJob(jobId) {

    const userId = 1;

    try {

        const response =
            await fetch("/api/applications", {

                method: "POST",

                headers: {

                    "Content-Type": "application/json"

                },

                body: JSON.stringify({

                    userId: userId,

                    jobId: jobId

                })

            });

        const message =
            await response.text();

        alert(message);

    }

    catch (error) {

        alert("Application Failed");

    }

}

// -------------------- LOGOUT --------------------

function logout() {

    localStorage.removeItem("token");

    localStorage.removeItem("email");

    window.location.href =
        "/login.html";

}