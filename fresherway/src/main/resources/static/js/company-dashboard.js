// ==================== PAGE LOAD ====================

window.onload = function () {

    loadCompany();

    loadJobs();

};

// ==================== LOAD COMPANY ====================

async function loadCompany() {

    // Temporary userId
    // Later replace with logged-in user's ID

    const userId = 13;

    try {

        const response =
            await fetch("/api/company/" + userId);

        if (!response.ok) {

            return;

        }

        const company =
            await response.json();

        document.getElementById(
            "companyName"
        ).innerHTML =
            "Welcome, " + company.companyName;

        document.getElementById(
            "companyNameInput"
        ).value =
            company.companyName;

        document.getElementById(
            "website"
        ).value =
            company.website;

        document.getElementById(
            "location"
        ).value =
            company.location;

        document.getElementById(
            "description"
        ).value =
            company.description;

    }

    catch(error){

        console.log(error);

    }

}

// ==================== SAVE COMPANY ====================

async function saveCompany() {

    const company = {

        userId : 13,

        companyName :
            document.getElementById(
                "companyNameInput"
            ).value,

        website :
            document.getElementById(
                "website"
            ).value,

        location :
            document.getElementById(
                "location"
            ).value,

        description :
            document.getElementById(
                "description"
            ).value

    };

    try{

        const response =
            await fetch("/api/company",{

                method:"POST",

                headers:{

                    "Content-Type":"application/json"

                },

                body:JSON.stringify(company)

            });

        const message =
            await response.text();

        alert(message);

    }

    catch(error){

        alert("Unable to save company.");

    }

}

// ==================== POST JOB ====================

async function postJob() {

    const job = {

        companyName :
            document.getElementById(
                "companyNameInput"
            ).value,

        jobTitle :
            document.getElementById(
                "jobTitle"
            ).value,

        location :
            document.getElementById(
                "jobLocation"
            ).value,

        salary :
            document.getElementById(
                "salary"
            ).value,

        skillsRequired :
            document.getElementById(
                "skills"
            ).value,

        description :
            document.getElementById(
                "jobDescription"
            ).value

    };

    try{

        const response =
            await fetch("/api/jobs",{

                method:"POST",

                headers:{

                    "Content-Type":"application/json"

                },

                body:JSON.stringify(job)

            });

        const message =
            await response.text();

        alert(message);

        loadJobs();

    }

    catch(error){

        alert("Unable to post job.");

    }

}

// ==================== LOAD JOBS ====================

async function loadJobs() {

    try{

        const response =
            await fetch("/api/jobs");

        const jobs =
            await response.json();

        displayJobs(jobs);

    }

    catch(error){

        console.log(error);

    }

}

// ==================== DISPLAY JOBS ====================

function displayJobs(jobs){

    const container =
        document.getElementById(
            "jobsContainer"
        );

    container.innerHTML = "";

    jobs.forEach(job=>{

        container.innerHTML +=`

        <div class="job-item">

            <h3>${job.jobTitle}</h3>

            <p>

                <strong>Company:</strong>

                ${job.companyName}

            </p>

            <p>

                <strong>Location:</strong>

                ${job.location}

            </p>

            <p>

                <strong>Salary:</strong>

                ₹${job.salary}

            </p>

            <div class="actions">

                <button
                    class="edit-btn">

                    Edit

                </button>

                <button
                    class="delete-btn">

                    Delete

                </button>

            </div>

        </div>

        `;

    });

}

// ==================== LOGOUT ====================

function logout(){

    localStorage.removeItem("token");

    localStorage.removeItem("email");

    window.location.href =
        "/login.html";

}